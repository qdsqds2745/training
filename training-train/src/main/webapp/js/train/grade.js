$(function () {
    $("#jqGrid").jqGrid({
        url: '../grade/list',
        datatype: "json",
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '等级的级数', name: 'series', index: 'series', width: 80},
			{label: '达到series等级的经验', name: 'experience', index: 'experience', width: 80},
			{label: '', name: 'gmtModified', index: 'gmt_modified', width: 80},
			{label: '', name: 'gmtCreate', index: 'gmt_create', width: 80}],
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
		grade: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.grade = {};
		},
		update: function (event) {
            let id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.grade.id == null ? "../grade/save" : "../grade/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.grade),
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
            let ids = getSelectedRows();
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
				$.ajax({
					type: "POST",
				    url: "../grade/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get("../grade/info/"+id, function (r) {
                vm.grade = r.grade;
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