<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function () {
        $('#dg').edatagrid({
            url:'/cmfs/picture/queryAll',
            updateUrl:'${pageContext.request.contextPath}/picture/update',
            destroyUrl:'${pageContext.request.contextPath}/picture/delete',

            singleSelect:false,
            ctrlSelect:true,

        fit:true,
            fitColumns:true,
            pagination:true,
            pageList:[5,10,15,20],
            pageSize:5,
            toolbar:but,
            columns:[[
                {field:'title',title:'标题',width:100},
                {field:'id',title:'id',width:100,hidden:true},
                {field:'status',title:'状态',width:100,

                    editor:{
                        type:'text',
                        options:{required:true}
                    }
                },
                {field:'data',title:'时间',width:100,align:'right'}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="../'+ rowData.imgPath +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.desc + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '<p>Data: ' + rowData.data + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

    })
         var but=$('#dg').datagrid({
                toolbar: [{
                        iconCls: 'icon-add',
                        text:'添加',
                        handler: function(){
                                $("#dd").dialog('open')
                                 }
                        },'-',{
                            iconCls: 'icon-remove',
                            text:'删除',
                        handler: function(){
                            //先找到删除行
                            var row =$("#dg").edatagrid("getSelections");
                            //通过行找到对应的id字段，也可以是行号
                            if(row==null){alert('请选择删除行')}

                            // 删除对应的行
                           $("#dg").edatagrid('destroyRow' );
                        }
                    },'-',{
                    iconCls: 'icon-edit',
                    text:'修改',
                    handler: function(){

                       var row= $('#dg').edatagrid("getSelections");
                       if(row==null){alert("请选中行")}
                       else{

                           $('#dg').edatagrid("editors",$('#dg').edatagrid("getRowIndex",row))
                       }

                    }
                },'-',{
                    iconCls: 'icon-save',
                    text:'保存',

                    handler: function(){
                        $('#dg').edatagrid('saveRow');
                    }
                },'-',{
                    iconCls: 'icon-save',
                    text:'自定义导出',

                    handler: function(){
                        $('#custome_dialog').dialog('open');
                        $("#btn4").linkbutton({
                            onClick:function () {
                                var a=$("#custome_cc").combobox('getText');
                                var b=$("#custome_cc").combobox('getValues');
                                console.log(a);//console.log(b);
                                var title="";
                                $.each(b,function (index,value) {
                                    if(index!=b.length-1){
                                        title+=value+',';
                                    }else{title+=value;}

                                })
                                console.log(title);
                                $('#customer_dialog').form('submit',{
                                    queryParams:{"title":a,"fileds":title},
                                    url:'${pageContext.request.contextPath}/user/customerExport',
                                })
                            }

                        })

                    }

                }]

            });





</script>
<table id="dg"> </table>
<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px; "
     data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true,buttons:[{
				text:'提交',
				handler:function(){

                     $('#ff').form('submit', {

                     url:'${pageContext.request.contextPath}/picture/add'
                     })
                    $('#dg').dialog('reload',)
                  }
			},{
				text:'关闭',
				handler:function(){
				    $('#dd').dialog('close')
				}
			}]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <div >
        <label for="title">图片名字:</label>
        <input class="easyui-validatebox" id="title" type="text" name="title" data-options="required:true" />
        </div>
         <div >
            <label for="desc">描述:</label>
            <input   id="desc" type="text" name="desc" data-options="required:true" />
        </div>
        <div>
            <label for="status">是否展示:</label>
            <select id="status" class="easyui-combobox"  data-options="width: '150px',multiple:false"  name="status" >
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </div>
       <%-- <div>
            <label for="data">日期:</label>
            <input  id="data"  type= "text" class= "easyui-datebox" name='data'data-options="required:true,"> </input>
        </div>--%>
        <input  type="file"   name="img">

    </form>

</div>
<div id="custome_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="customer_dialog" method="post">
        <select id="custome_cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'${pageContext.request.contextPath}/json/comboTree.json',required:true,checkbox:true,multiple:true">

        </select>
    </form>
    <a id="btn4" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导出</a>
</div>
