$(function () {
    $("#jqGrid").jqGrid({
        url: '../classtype/list',
        datatype: "json",
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '班级名称', name: 'className', index: 'class_name', width: 80},
			/*{label: '计费方式', name: 'bilingId', index: 'biling_id', width: 80},*/
			
			{label: '价格', name: 'pice', index: 'pice', width: 80},
			{label: '课时/学期', name: 'hoursTerm', index: 'hours_term', width: 80,formatter: function (value){
				return value == "1"?"课时":"学期";
			}},
			
			
			{label: '开始时间', name: 'startTime', index: 'start_time', width: 80},
			{label: '结束时间', name: 'endTime', index: 'end_time', width: 80},
			{label: '创建时间', name: 'gmtCreate', index: 'gmt_create', width: 80},
			{label: '实时修改时间', name: 'gmtModified', index: 'gmt_modified', width: 80},
			{label: '备注', name: 'remarks', index: 'remarks', width: 80}],
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
		classType: {hoursTerm:1},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		},
		bilings:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.classType = {
					hoursTerm :1
			};
			vm.bilings = [];
			
			this.getBillsBy();
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
            let url = vm.classType.id == null ? "../classtype/save" : "../classtype/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.classType),
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
				    url: "../classtype/delete",
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
			$.get("../classtype/info/"+id, function (r) {
                vm.classType = r.classType;
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
		
		//获取 支付方式
		getBillsBy :function(){
			$.get("../biling/queryAll",function (r){
				vm.bilings = r.list;
			});
			
		},	
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        
        
        //测试 弹出事件
        alertTo: function (val){
        	alert(vm.classType.hoursTerm+"    val===>"+val);
        }
        
        
	}
});