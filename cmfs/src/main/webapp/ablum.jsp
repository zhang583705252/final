<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function () {
        $('#album').treegrid({
            url:'${pageContext.request.contextPath}/album/queryAllAlbum',
            idField:'id',
            treeField:'aname',
            fit:true,
            fitColumns:true,
            pagination:true,
            pageList:[5,10,15,20],
            pageSize:5,
            toolbar:but,
            columns:[[
                {field:'aname',title:'名字',width:60,align:'right'},
                {field:'size',title:'音频大小',width:80},
                {field:'downPath',title:'下载路径',width:80},
                {field:'ablum_id',title:'专辑标识',width:80},
                {field:'duration',title:'封面',width:80},

            ]]
        });
    })
    var but=$('#album').datagrid({
        toolbar: [{
            iconCls: 'icon-edit',
            text:'专辑详情',
            handler: function(){
                //先获取选中的行
                var row=$('#album').treegrid('getSelected');

                if(row==null){alert('请先选中行')}
                else{if(row.ablum_id==null){
                    //弹出一个专辑详情的对话框
                    $('#album_dialog').dialog('open');
                   // 将页面的数据填充到对话框
                    $('#album_ff').form('load',row);
                    //将页面的图片路径填充到对话框
                    $('#coverImg').prop('src',row.coverImg);
                    }else{alert('请选中专辑');}
                }
            }
        },'-',{
            iconCls: 'icon-help',
            text:'添加专辑',
            handler: function(){
                //弹出一个添加专辑 的对话框
                $('#album_dialogAdd').dialog('open');
            }
        },'-',{
            iconCls: 'icon-help',
            text:'添加章节',
            handler: function(){
                //先获取选中的行
                var row=$('#album').treegrid('getSelected');

                if(row==null){alert('请先选中行')}
                else{if(row.ablum_id==null){
                    //弹出一个添加章节的对话框
                    $('#capter_dialog').dialog('open');
                    console.log(row.id)
                    $('#album_id').textbox("setValue",row.id);

                }else{alert('请选中专辑');}
                }

            }
        },'-',{
            iconCls: 'icon-help',
            text:'下载音频',
            handler: function(){
                $('#capter_down').dialog('open');
            }
        }]
    });



</script>
<table id="album"> </table>
<div id="album_dialog" class="easyui-dialog" title="专辑详情" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <form id="album_ff" method="post">
        <div>
            <label for="aname">名称:</label>
            <input class="easyui-validatebox" type="text" id="aname" name="aname"/>
        </div>
        <div>
            <label for="count">集数:</label>
            <input class="easyui-validatebox" type="text" id="count"  name="count"/>
        </div>
        <div>
            <label for="coverImg">封面</label>
             <img src="#" id="coverImg"/>
        </div>
        <div>
            <label for="author">作者:</label>
            <input class="easyui-validatebox" type="text" id="author" name="author"/>
        </div>
        <div>
            <label for="broadCast">播音:</label>
            <input class="easyui-validatebox" type="text" id="broadCast"  name="broadCast"/>
        </div>

        <div>
            <label for="prief">简介:</label>
            <input class="easyui-validatebox" type="text" id="prief"   name="prief"/>
        </div>
        <div>
            <label for="star">推荐指数:</label>
            <input class="easyui-validatebox" type="text" id="star"  name="star"/>
        </div>

        <div>
            <label for="publishDate">发布时间:</label>
            <input class="easyui-validatebox" type="text" id="publishDate"   name="publishDate"/>
        </div>
        <div>
            <label for="id"> </label>
            <input class="easyui-validatebox" type="text" id="id"  hidden=true name="id"/>
        </div>
        ...
    </form>

    <div id="album_dialogAdd" class="easyui-dialog" title="添加专辑" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'提交',

        handler:function(){
            $('#album_dd').form('submit',{
                url:'${pageContext.request.contextPath}/album/addAblum'
                })
               <%--$('#album').dialog('reload')--%>
                }
            },{
        text:'关闭',
        handler:function(){
        $('#album_dialogAdd').dialog('close')
        }
 }]">
        <form id="album_dd" method="post" enctype="multipart/form-data">
            <div>
                 名称:<input class="easyui-validatebox" type="text"  name="aname"/>
            </div>
            <div>
                 集数:<input class="easyui-validatebox" type="text"  name="count"/>
            </div>
            <div>
                 封面<input type="text" name="coverImg"/>
            </div>
            <div>
                 作者:<input class="easyui-validatebox" type="text"  name="author"/>
            </div>
            <div>
                 播音:<input class="easyui-validatebox" type="text"   name="broadCast"/>
            </div>
            <div>
                 简介:<input class="easyui-validatebox" type="text"    name="prief"/>
            </div>
            <div>
                推荐指数:<input class="easyui-validatebox" type="text"    name="star"/>
            </div>
            <div>
                 发布时间:<input class="easyui-validatebox" type="text"    name="publishDate"/>
            </div>
            <div>
                <input class="easyui-validatebox" type="text"   hidden=true name="id"/>
            </div>
        </form>
    </div>


    <div id="capter_dialog" class="easyui-dialog" title="添加章节" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'提交',
        handler:function(){

         $('#capter_ff').form('submit',{

            url:'${pageContext.request.contextPath}/capter/addCapter'
            })
           <%-- $('#album').dialog('reload')
            success:function(data){
                alert(data)
            }--%>
         }
      },{
        text:'关闭',
        handler:function(){
             $('#capter_dialog').dialog('close')
        }
 }]">
        <form  id="capter_ff" method="post" enctype="multipart/form-data">
            <div>
                <label for="album_id"> </label>
                <input class="easyui-textbox" id="album_id" type="hidden" name="id"/>
            </div>
            <div>
                <label for="file"> </label>
                <input  class="easyui-filebox" id="file"  name="eudio"/>
            </div>
        </form>
    </div>

    <div id="capter_down" class="easyui-dialog" title="下载视频" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'提交',
        handler:function(){

         $('#capter_dd').form('submit',{

            url:'${pageContext.request.contextPath}/capter/downCapter'
            })
           <%-- $('#album').dialog('reload')
            success:function(data){
                alert(data)
            }--%>
         }
      },{
        text:'关闭',
        handler:function(){
             $('#capter_down').dialog('close')
        }
    }]">
        <form  id="capter_dd" method="post" enctype="multipart/form-data">
            <div>
               下载文件的路径： <input class="easyui-textbox"   type="text" name="url"/>
            </div>
            <div>
               下载文件的名字： <input  class="easyui-textbox"  name="oldName">
            </div>
        </form>
    </div>
</div>