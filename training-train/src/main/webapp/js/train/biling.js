$(function () {
    $("#jqGrid").jqGrid({
        url: '../biling/list',
        datatype: "json",
        colModel: [
			{label: 'bilingId', name: 'bilingId', index: 'biling_id', key: true, hidden: true},
			{label: '价格', name: 'pice', index: 'pice', width: 80},
			{label: '课时或者学期', name: 'hoursTerm', index: 'hours_term', width: 80,formatter:function (value){
				return value == 1 ? "课时":"学期";
			}},
			{label: '创建时间', name: 'gmtCreate', index: 'gmt_create', width: 80},
			{label: '修改时间', name: 'gmtModified', index: 'gmt_modified', width: 80}],
		viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		biling: {
			hoursTerm : 1,
		},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		},
		
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.biling = {
					hoursTerm : 1,
			};
		},
		update: function (event) {
            let bilingId = getSelectedRow();
			if (bilingId == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(bilingId)
		},
		saveOrUpdate: function (event) {
            let url = vm.biling.bilingId == null ? "../biling/save" : "../biling/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.biling),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
			});
		},
		del: function (event) {
            let bilingIds = getSelectedRows();
			if (bilingIds == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
				$.ajax({
					type: "POST",
				    url: "../biling/delete",
				    contentType: "application/json",
				    data: JSON.stringify(bilingIds),
				    success: function (r) {
						if (r.code == 0) {
							alert('操作成功', function (index) {
								$("#jqGrid").trigger("reloadGrid");
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(bilingId){
			$.get("../biling/info/"+bilingId, function (r) {
                vm.biling = r.biling;
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});