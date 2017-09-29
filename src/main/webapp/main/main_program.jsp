<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/25
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>星标项目1</title>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../resources/css/jquery.dad.css"/>
    <link rel="stylesheet" href="../resources/css/program_css.css"/>
    <link rel="stylesheet" href="../resources/css/program_xq_navbar.css"/>
    <link rel="stylesheet" href="../resources/css/program_xq.css"/>
    <link rel="stylesheet" href="../resources/css/program_icono.min.css "/>
    <link rel="stylesheet" href="../resources/css/program_style.css"/>
    <link rel="shortcut icon" href="../resources/demo/favicon.png">
    <link rel="apple-touch-icon image_src" href="../resources/demo/favicon.png">
    <link rel="author" href="../resources/humans.txt">
    <link rel="stylesheet" href="../resources/demo/highlight-9.5.0.min.css">
    <link rel="stylesheet" href="../resources/program_dist/css/checkbix.min.css">
    <link rel="stylesheet" href="../resources/demo/demo.css">
    <link rel="stylesheet" href="../resources/css/program_checked.min.css"/>
    <link rel="stylesheet" href="../resources/css/program_jquery.notebook.css"/>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.notebook.js"></script>
    <script src="http://www.jq22.com/js/jq.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.dad.min.js"></script>
    <script src="../resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="../resources/js/xq_navbar.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        $(document).on('ready', function onReady() {
            var checkbox = $('#checkbox'),
                radio = $('#radio'),
                select = $('select'),
                radioLabel = $('#radio-label'),
                checkboxLabel = $('#checkbox-label'),
                timeout;
            radio.attr('checked', 'checked');
            checkbox.attr('checked', 'checked');
            checkbox.bind('click', function (e) {
                e.preventDefault();
            });
            select.change(function onChange(e, a, b) {
                var selected = select.find(':selected').text();
                clearTimeout(timeout);
                radio.attr('class', '');
                checkbox.attr('class', '');
                var timeout = setTimeout(function () {
                    radioLabel.text(selected.toString());
                    checkboxLabel.text(selected.toString());
                    radio.attr('class', 'checked-' + selected.toString().toLowerCase());
                    checkbox.attr('class', 'checked-' + selected.toString().toLowerCase());
                }, 650);
            });
        });
    </script>
    <script type="text/javascript">
        /**
         * 把毫秒级时间转换成字符串
         * 格式：yyyy年MM月dd日
         * @param date
         * @returns {string}
         */
        function dateFormat(date) {
            var dateStr = new Date(date);
            // 重写toString方法
            Date.prototype.toLocaleString = function () {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
            };
            return dateStr.toLocaleString();
        }
        // 任务栏
        function aaab() {
            $("#taskadd").empty();
            $.ajax({
                type: "Post",
                url: "/Task/TaskList",
                dataType: "json",
                success: function (result) {
                    $.each(result.data, function (n, v) {
                        $("#taskadd").append(
                            "<a name='" + v.taskId + "' href='#'style='color: pink;margin-left: 10px;'onclick='queryTask(name)'>" + v.taskName + "</a><br>"
                        )
                    })
                },
                error: function () {
                    alert("遍历所有任务失败")
                }
            })
            $("#task_detail").hide()
            $("#task_alltask").show()
            $("#filediv").hide()
            $("#taskdiv").fadeIn()
            $("#discussdiv").hide()
            $("#schedulediv").hide()
            $("#countdiv").hide()
            $("#memberdiv").hide()
            $("#task_ed").hide()
        }
        $(document).ready(function () {
            $("#infile").click(function () {
                $("#filediv").fadeIn()
                $("#taskdiv").hide()
                $("#discussdiv").hide()
                $("#schedulediv").hide()
                $("#countdiv").hide()
                $("#memberdiv").hide()

            })
            $("#indiscuss").click(function () {
                $("#filediv").hide()
                $("#taskdiv").hide()
                $("#discussdiv").fadeIn()
                $("#schedulediv").hide()
                $("#countdiv").hide()
                $("#memberdiv").hide()
            })
            $("#inschedule").click(function () {
                $("#filediv").hide()
                $("#taskdiv").hide()
                $("#discussdiv").hide()
                $("#schedulediv").fadeIn()
                $("#countdiv").hide()
                $("#memberdiv").hide()
            })
            $("#incount").click(function () {
                $("#filediv").hide()
                $("#taskdiv").hide()
                $("#discussdiv").hide()
                $("#schedulediv").hide()
                $("#countdiv").fadeIn()
                $("#memberdiv").hide()
            })
            $("#inmember").click(function () {
                $("#filediv").hide()
                $("#taskdiv").hide()
                $("#discussdiv").hide()
                $("#schedulediv").hide()
                $("#countdiv").hide()
                $("#memberdiv").fadeIn()
            })
            $("#bar3").xq_navbar({
                "type": "line",
                "liwidth": "avg",
                "bgcolor": "black"
            });
            $("#taskdiv").show()
            $("#addschedulediv").hide()
            $("#schedulediv").hide()
            $("#inaddschedule").click(function () {
                $("#addschedulediv").show()
                $("#allschedulediv").hide()
            })
            $("#backschedule1").click(function () {
                $("#addschedulediv").hide()
                $("#allschedulediv").show()
            })
            $("#addschedule_sure").click(function () {
                $("#addschedulediv").hide()
                $("#allschedulediv").show()
            })
            $("#addschedule_cancel").click(function () {
                $("#addschedulediv").hide()
                $("#allschedulediv").show()
            })
            $("#addtaskdiv").hide()
            $("#inaddtask1").click(function () {
                $("#addtaskdiv").slideToggle()
                $("#task_detail").hide()
                $("#task_ed").hide()
                $("#list_detail").hide()
                $("#list_ed").hide()
                $("#task_alltask").show()
            })
            $("#inaddtask2").click(function () {
                $.ajax({
                    type: "Post",
                    url: "/project/projecter",
                    dataType: "json",
                    success: function (result) {
                        // 先清空
                        $("#people2").empty();
                        $.each(result.data, function (n, v) {
                            $("#people2").append(
                                "<input type='radio' name='qq' class='checked-boom' checked='true' value='" + v.uId + "'/>" +
                                "<span style='color: pink;font-size: 15px;'>" + v.uName + "</span>&nbsp;"
                            )
                        })
                    },
                    error: function () {
                        alert("遍历项目成员失败")
                    }
                })
                $("#addtaskdiv").slideToggle()
                $("#task_detail").hide()
                $("#task_ed").hide()
                $("#list_detail").hide()
                $("#list_ed").hide()
                $("#task_alltask").slideToggle()
            })

            $("#addtask_cancel").click(function () {
                $("#addtaskdiv").slideToggle()
                $("#task_alltask").slideToggle()

            })
            $("#addlistdiv").hide()
            $("#inaddlist").click(function () {
                $("#addlistdiv").slideToggle()
                $("#task_detail").hide()
                $("#task_ed").hide()
                $("#list_detail").hide()
                $("#list_ed").hide()
                $("#task_alltask").show()
            })
            $("#addlist_sure").click(function () {
                $("#addlistdiv").slideToggle()
            })
            $("#addlist_cancel").click(function () {
                $("#addlistdiv").slideToggle()
            })
            $("#adddiscussdiv").hide()
            $("#inadddiscuss1").click(function () {
                $("#adddiscussdiv").slideToggle()
            })
            $("#inadddiscuss2").click(function () {
                $("#adddiscussdiv").slideToggle()
            })
            $("#adddiscuss_sure").click(function () {
                $("#adddiscussdiv").slideToggle()
            })
            $("#adddiscuss_cancel").click(function () {
                $("#adddiscussdiv").slideToggle()
            })
            $(".discuss1hide").hide()
            $(".discuss1").click(function () {
                $(".discuss1hide").slideToggle()
            })
            $("#discuss1div").hide();
            $("#indiscuss1com").click(function () {
                $("#discuss1div").slideToggle();
            })
            $("#discuss1com_sure").click(function () {
                $("#discuss1div").hide();
                $("#discuss_newcom").show()
            })
            $("#discuss1com_cancel").click(function () {
                $("#discuss1div").slideToggle();
            })
            $("#discuss_newcom").hide()
            $("#discussdiv").hide()
            $("#discussdiv").hide()
            $("#filediv").hide()
            $("#file_filediv1").hide()
            $("#file_filediv2").hide()
            $("#file_allfile").hide()
            $(".infolderdiv").click(function () {
                $("#file_filediv1").hide()
                $("#file_filediv2").hide()
                $("#file_folderdiv").show()
                $("#file_allfile").hide()
            })
            $("#inallfile").click(function () {
                $("#file_filediv1").hide()
                $("#file_filediv2").hide()
                $("#file_folderdiv").hide()
                $("#file_allfile").show()
            })
            $("#file_folder1").click(function () {
                $("#file_filediv1").show()
                $("#file_filediv2").hide()
                $("#file_folderdiv").hide()
                $("#file_allfile").hide()
            })
            $("#file_folder2").click(function () {
                $("#file_filediv1").hide()
                $("#file_filediv2").show()
                $("#file_folderdiv").hide()
                $("#file_allfile").hide()
            })
            $("#edschedule1").hide()
            $("#inedschedule1").click(function () {
                $("#edschedule1").show()
                $("#allschedulediv").hide()
            })
            $("#backschedule2").click(function () {
                $("#edschedule1").hide()
                $("#allschedulediv").show()
            })
            $("#edschedule1_sure").click(function () {
                $("#edschedule1").hide()
                $("#allschedulediv").show()
            })
            $("#edschedule1_cancel").click(function () {
                $("#edschedule1").hide()
                $("#allschedulediv").show()
            })
            $("#countdiv2").hide()
            $("#countdiv3").hide()
            $("#incountdiv1").click(function () {
                $("#countdiv1").fadeIn()
                $("#countdiv2").hide()
                $("#countdiv3").hide()
            })
            $("#incountdiv2").click(function () {
                $("#countdiv1").hide()
                $("#countdiv2").fadeIn()
                $("#countdiv3").hide()
            })
            $("#incountdiv3").click(function () {
                $("#countdiv1").hide()
                $("#countdiv2").hide()
                $("#countdiv3").fadeIn()
            })
            $("#countdiv").hide()
            $("#memberdiv").hide()
            $("#edmember").hide()
            $("#member_ed").click(function () {
                $("#allmember").hide()
                $("#edmember").show()
            })
            $("#member_save").click(function () {
                $("#allmember").show()
                $("#edmember").hide()
            })
            $("#member_quit").click(function () {
                alert("你确定要退出吗")
            })
        })
        // 查询选中任务
        function queryTask(a) {
            $.ajax({
                type: "Post",
                url: "/Task/TaskListInfor",
                dataType: "json",
                data: {
                    taskId: a,
                    type: 0
                },
                success: function (result) {
                    $("#taskname2").text(result.data.taskName);
                    $("#taskdes").text(result.data.taskDescribe);
                    $("#creatName").text(result.data.taskUser);
                    $("#betaskdo").text(result.data.taskAssigner);
                    $("#creattask").text(dateFormat(result.data.taskCreatetime));
                    // 目前下面这个有错
                    if(result.data.taskFinishtime!=null){
                        $("#downtask").append(dateFormat(result.data.taskFinishtime));
                    }
//                    $("#downtask").append(dateFormat(result.data.taskFinishtime));
                    $("#task_del").attr("name", result.data.taskId);
                    $("#task_ined").attr("name", result.data.taskId);
                    $("#taskname").val(result.data.taskName);
                },
                error: function () {
                    alert("显示任务失败")
                }
            })
            $("#task_detail").show()
            $("#task_alltask").hide()

        }
        // 编辑任务的时候遍历项目成员
        function cTask1() {
            $.ajax({
                type: "Post",
                url: "/project/projecter",
                dataType: "json",
                success: function (result) {
                    // 先清空
                    $("#people1").empty();
                    $.each(result.data, function (n, v) {
                        $("#people1").append(
                            "<input type='radio' name='q' class='checked-boom' checked='true' value='" + v.uId + "'/>" +
                            "<span style='color: pink;font-size: 15px;'>" + v.uName + "</span>&nbsp;"
                        )
                    })
                },
                error: function () {
                    alert("遍历项目成员失败")
                }
            })
        }
        // 修改任务
        function cTask2() {
            $.ajax({
                type: "Post",
                url: "/Task/UpdateTask",
                dataType: "json",
                data: {
                    taskId: $("#task_del").attr("name"),
                    taskName: $("#taskname").val(),
                    taskAssigner:$("input[name='q']:checked").val(),
                    taskUser: $("#creatName").text(),
                    endTime:$("#time2").val()
                },
                success: function (result) {
                    queryTask($("#creatName").text());
                },
                error: function () {
                    alert("删除任务失败")
                }
            })
        }
        // 删除任务
        function delTask() {
            var idd = $("#task_del").attr("name");
            $.ajax({
                type: "Post",
                url: "/Task/TaskDelete",
                dataType: "json",
                data: {
                    taskId: idd,
                },
                success: function (result) {
                    alert(result.info);
                    aaab();
                },
                error: function () {
                    alert("删除任务失败")
                }
            })
        }
        // 新增任务
        function newTask2() {
            $.ajax({
                type: "Post",
                url: "/Task/AddTask",
                dataType: "json",
                data: {
                    taskName: $("#newtaskname").val(),
                    taskAssigner:$("input[name='qq']:checked").val(),
                    taskDescribe:$("#taskmiao").val(),
                    endTime:$("#time1").val()
                },
                success: function (result) {
                    alert(result.info);
                },
                error: function () {
                    alert("新增任务失败")
                }
            })

            $("#addtaskdiv").slideToggle()
            $("#task_alltask").slideToggle()
        }
    </script>
    <script src="../resources/program_dist/js/checkbix.min.js"></script>
    <script>
        Checkbix.init();
    </script>

    <style>
        .datainp {
            width: 200px;
            height: 30px;
            border: 1px white solid;
        }

        .datep {
            margin-bottom: 40px;
            line-height: 24px;
            margin-right: 15px;
        }

        .wicon {
            background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAQCAYAAADj5tSrAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEgAACxIB0t1+/AAAABZ0RVh0Q3JlYXRpb24gVGltZQAwNi8xNS8xNGnF/oAAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzVxteM2AAAAoElEQVQ4jWPceOnNfwYqAz9dYRQ+E7UtwAaGjyUsDAyYYUgJ2HT5LXZLcEmSCnA6duOlN///////H0bDALl8dPH/////Z8FuNW6Qtvw2nL3lyjsGBgYGhlmRqnj1kGwJuqHIlhJlCXq8EOITEsdqCXLEbbr8FisfFkTo+vBZRFZwERNEFFkCiw90nxJtCalxQmzegltCzVyP1RJq5HZ8AABuNZr0628DMwAAAABJRU5ErkJggg==");
            background-repeat: no-repeat;
            background-position: right center;
        }
    </style>


    <%--对项目进行操作--%>
    <script type="text/javascript">
        $(document).ready(function () {
            //            页面加载时遍历项目信息
            $.ajax({
                type: "Post",
                url: "/project/displayProject",
                dataType: "json",
                data: {
                    pId:${param.pId},
                },
                success: function (result) {
                    $("#project").append("<h2 style='font-size: 25px;color: deeppink'>" + result.data.pName + "</h2>" +
                        "<h3 style='font-size: 15px;color: grey;margin-top: 0px;'>" + result.data.pDescribe + "</h3>")
                },
                error: function () {
                    alert("项目输出错了");
                }
            })
        })

        //页面加载时遍历任务清单
        $(document).ready(function () {
            $.ajax({
                type: "Post",
                url: "/TaskInfo/taskInfoList",
                dataType: "json",
                data: {
                    pId:${param.pId},
                },
                success: function (result) {
                    $.each(result.data, function (n, v) {
                        $("#task_list").append("<div><div><h2>" +
                            "<a href='../TaskInfo/displayonetaskinfo.jsp?taskinfoId=" + v.taskinfoId + "'>" + v.taskinfoName + "</a>" +
                            "</h2></div></div><br>")
                    })
                },
                error: function () {
                    alert("任务遍历失败");
                },
            })
        })

        //页面加载时遍历讨论表
        $(document).ready(function () {
            $.ajax({
                type: "Post",
                url: "/discus/QueryDiscus",
                dataType: "json",
                data: {
                    pId:${param.pId},
                },
                success:function (result) {
                    if(result.errcode==1) {
                        $.each(result.data, function (n, v) {
                            $("#discus_all").append("<a class='ps_btn' style='display: inline;font-size: 20px;'>" + v.uName + "</a><br>" +
                                "<a name='" + v.discusId + "' onclick='opencomment(this)'>" +
                                "<h3 class='ps_btn' style='color: white;margin-left:0px; font-weight: bold;'>" + v.dTopic + "</h3></a>" +
                                "<div class='discuss1' style='color: grey;margin-left:0px;font-size: 15px;'>" + v.dContent + "</div>")
                        })
                    }else{
                        alert("该项目现在还没有讨论");
                    }
                },
                error: function () {
                    alert("遍历评论错了")
                }
            })
        })

        //页面加载的时候加载文件和文件夹
        $(document).ready(function () {
            $.ajax({
                type: "Post",
                url: "/total/QueryFileByPid",
                dataType: "json",
                data: {
                    pId:${param.pId},
                },
                success:function (result) {
                    if(result.errcode==1) {
                        $.each(result.data, function (n, v) {
                            if (v.type == 0) {
                                $("#file_folderdiv").append("<i class='icono-folder' " +
                                    "id='file_folder" + v.fileId + "' style='cursor: pointer;margin-left: 10px;'></i>" +
                                    "<span style='color: white;' id='" + v.fileId + "'>" + v.fileName + "</span>");
                            }
                            if (v.type == 1) {
                                $("#file_folderdiv").append("<i class='icono-folder' " +
                                    "id='file_folder" + v.folderId + "' style='cursor: pointer;margin-left: 10px;'></i>" +
                                    "<span style='color: white;'>" +
                                    "<a onclick=intofolder('" + v.folderId + "','" + v.folderName + "')>" + v.folderName + "</a></span>")
                            }
                        })
                    }else{
                        alert("该项目还没有文件或者文件夹");
                    }
                },
                error: function () {
                    alert("文件遍历了失败");
                }
            })
        })
    </script>

    <script type="text/javascript">
        /**
         * 把毫秒级时间转换成字符串
         * 格式：yyyy年MM月dd日
         * @param date
         * @returns {string}
         */
        function dateFormat(date) {
            var dateStr = new Date(date);
            // 重写toString方法
            Date.prototype.toLocaleString = function() {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
            };
            return dateStr.toLocaleString();
        }
        //打开上传文件的表单
        function upfile() {
            $("#upfile").show();
            $("#file_folderdiv").hide();
            $("#file_filediv1").hide();
        }
        //关闭上传文件的表单
        function closefile() {
            $("#file_filediv1").hide()
            $("#file_filediv2").hide()
            $("#file_folderdiv").show()
            $("#file_allfile").hide()
            $("#upfile").hide();
            $("#file_folderdiv").show();
        }
        //        上传文件
        function doUpload() {
            var formData = new FormData($("#uploadForm")[0]);
            //用form 表单直接 构造formData 对象就不需要下面的append 方法来为表单进行赋值了。
            $.ajax({
                url: "/file/uploadfile",
                type: "Post",
                data: formData,
                async: false,//要求同步 不是不需看你的需求
                cache: false,
                contentType: false,  //必须false才会自动加上正确的Content-Type
                processData: false, //必须false才会避开jQuery对 formdata 的默认处理
                success: function (result) {
                    alert(result.errcode);
                },
                error: function () {
                    alert("上传失败");
                }
            })
        }
    
        //打开创建文件夹位置
        function openfolder() {
            $("#creatfolder").show();
            $("#file_folderdiv").hide();

        }
        
        //关掉创建文件夹位置
        function closefolder() {
            $("#creatfolder").hide();
            $("#file_folderdiv").show();
        }
        
        
        //        创建文件夹
        function startfolder() {
            $.ajax({
                type:"Post",
                url:"/Folder/AddFolder",
                dataType:"json",
                data:{
                    folderName:$("#folderName").val(),
                    pId:${param.pId},
                },
                success:function (result) {
                    $("#creatfolder").hide();
                    $("#file_folderdiv").show();
                    $("#file_folderdiv").append("<i class='icono-folder' id='file_folder"+result.data.folderId+"' " +
                        "style='cursor: pointer;margin-left: 10px;'></i>" +
                        "<span style='color: white;'>" +
                        "<a onclick=intofolder('"+result.data.folderId+"','"+result.data.folderName+"')>"+result.data.folderName+"</a></span>")

                },
                error:function () {
                    alert("文件夹创建错误");
                }
            })
        }
        
    //进入文件夹中
        function intofolder(a,b) {
            var folderId=a;
            $.ajax({
                type:"Post",
                url:"/Folder/queryFileByFolderId",
                dataType:"json",
                data:{
                    folderId:folderId,
                },
                success:function (result){
                    $("#file_folderdiv").hide();
                    $("#file_filediv1").show();
                    $("#file_filediv1").html("");
                    $("#file_filediv1").append("<h2><a onclick='backfolder()'>文件：>"+b+"</a></h2>");
                    if(result.errcode==1) {
                        $.each(result.data, function (n, v) {
                            $("#file_filediv1").append("<span style='color: white;'>" +
                                "<i class='icono-file'  style='cursor: pointer;margin-left: 10px;'></i>" + v.fileName + "" +
                                "<button class='ps_btn' href='#' style='border: none;' >下载</button>" +
                                "<button style='border: none;' class='ps_btn' href='#' >删除</button></span>")
                        })
                    }else{
                        alert("该文件夹中还没有文件");
                    }
                },
                error:function () {
                    alert("文件夹中的文件遍历失败");
                }
            })
        }

        //返回文件夹总榜
        function backfolder() {
            $("#file_filediv1").hide();
            $("#file_folderdiv").show();
        }


        //发起讨论
        function startdiscus() {
            $.ajax({
                type:"Post",
                url:"/discus/creatDiscus",
                dataType:"json",
                data:{
                    pId:${param.pId},
                    dTopic:$("#dTopic").val(),
                    dContent:$("#dContent").val(),
                },
                success:function (result) {
                    $("#discus_all").append("<a class='ps_btn' style='display: inline;font-size: 20px;'>"+result.data.uName+"</a><br>" +
                        "<a name='"+result.data.discusId+"' onclick='opencomment(this)'>" +
                        "<h3 class='ps_btn' style='color: white;margin-left:0px; font-weight: bold;'>"+result.data.dTopic+"</h3></a>" +
                        "<div class='discuss1' style='color: grey;margin-left:0px;font-size: 15px;'>"+result.data.dContent+"</div>")
                },
                error:function () {
                    alert("发起讨论失败");
                }
            })
        }

        //进入单个讨论表
        function opencomment(obj) {
            var discusId=obj.name;
            $("#discus_all").hide();
            $("#discus_one").show();
            $("#discus_one_discus").html("");
            $("#discus_one_comment").html("");
            $("#didiscus_one_addcomment_buttom").html("");
            $.ajax({
                type:"Post",
                url:"/discus/selectDiscusByDid",
                dataType:"json",
                data:{
                    discusId:discusId,
                },
                success:function (result) {
                    $("#commentTheDiscus").show();
                    $("#discus_one_discus").append("<h2><a href='#' style='color: white;' onclick='backdiscus()'>讨论：>"+result.data.dTopic+"</a></h2>" +
                        "<h3 style='color: white;'>"+result.data.dContent+"</h3>");
                    if(result.errcode==1) {
                        $.each(result.page, function (n, v) {
                            $("#discus_one_comment").append("<span style='color: white;'>" + v.uName + "评论了: " + v.cContent + "" +
                                "&nbsp<span style='color: white;'>" + dateFormat(v.cTime) + "</span></span><br>")
                        });
                        $("#discus_one_addcomment").show();
                        $("#didiscus_one_addcomment_buttom").append("<button name='" + result.data.discusId + "' class='ps_btn' onclick='addcomment(this)'>发表评论</button>");
                    }else {
                        alert("讨论中还没有评论")
                    }
                },
                error:function () {
                    alert("进入讨论单表失败");
                }
            })
        }
        
        //对讨论表发表评论
        function addcomment(obj) {
            var discusId=obj.name;
            $.ajax({
                type:"Post",
                url:"/Comment/cContent",
                dataType:"json",
                data:{
                    cContent:$("#cContent").val(),
                    discusId:discusId,
                },
                success:function (result) {
                    $("#discus_one_comment").append("<span>"+result.data.uName+"评论了: "+result.data.cContent+"" +
                        "&nbsp<span>"+dateFormat(result.data.cTime)+"</span></span><br>")
                },
                error:function () {
                    alert("发表评论失败");
                }
            })
        }

        

        //返回讨论总表
        function backdiscus() {
            $("#discus_one").hide()
            $("#discus_all").show();
        }
    </script>
</head>

<body style="background-color: #212121;">
<div style="margin: 30px;">
    <!--最上面的部分-->
    <div>
				<span>
				    <div id="project" class="container">
                    </div>
                    <br>
			    </span>
        <span style="margin-left: 830px;margin-top: -30px;">
				<span> <button class="ps_btn" id="incount" href="#" style="border: none;">待处理任务（10）</button> </span>
				<span> <button class="ps_btn" id="inmember" href="#" style="border: none;">成员（2）</button> </span>
            <!--<span> <button class="ps_btn" id="setting" href="#">设置</button> </span>-->
				</span>
    </div>

    <!--菜单栏-->
    <div class="xq_bag" id="bar3" style="margin-top: 10px;margin-bottom: 20px;">
        <ul class="xq_navbar">
            <!--改颜色要去JS改-->
            <li class="xq_navli"><a id="intask" style="font-size: 30px;" href="#" onclick="aaab()">任务</a></li>
            <li class="xq_navli"><a id="indiscuss" style="font-size: 30px;" href="#">讨论</a></li>
            <li class="xq_navli"><a id="infile" style="font-size: 30px;" href="#">文件</a></li>
            <li class="xq_navli"><a id="inschedule" style="font-size: 30px;" href="#">日程</a></li>
        </ul>
    </div>

    <!--任务模块-->
    <div id="taskdiv">
        <ul class="menu" style="  background-color: #212121;border: none;">
            <li>
                <a id="inaddtask12" href="#">- 添加任务 -</a>
                <ul class="submenu">
                    <li><a id="inaddtask2" style="text-align: center;" href="#">添加任务</a></li>
                    <%--<li><a id="inaddlist" style="text-align: center;" href="#">添加清单</a></li>--%>
                </ul>
            </li>
        </ul>
        <textarea></textarea>

        <!--任务详情-->
        <div id="task_detail" style="margin-left: 210px;margin-top:-20px;width: 960px;">
            <a href="#" class="backtask" class="infolderdiv" style="font-size: 25px;color: pink;">任务名称</a>
            <a style="font-size: 25px;color: white;"> > </a>
            <a id="taskname2" style="font-size: 25px;color: white;">600个俯卧撑</a>
            <button id="task_ined" class="ps_btn" onclick="cTask1()">编辑</button>
            <button id="task_del" class="ps_btn" style="margin-left: 20px;" onclick="delTask()">删除</button>
            <br>
            <%--<input id="mycheckbox1" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">--%>
            &nbsp;&nbsp;<a href="#" style="color: pink;margin-left: -10px;" id="taskdes">任务描述</a>
            <br><br>
            <span style="color: grey;">任务创建者</span><br>
            <span style="color: pink;font-size: 15px;" id="creatName">赵信</span>&nbsp;&nbsp;<br>
            <span style="color: grey;">任务指派人</span>
            <br>
            <span style="color: pink;font-size: 15px;" id="betaskdo">赵信</span>&nbsp;&nbsp;
            <!--日历-->
            <br><br>
            <span style="color: grey;">任务创建时间</span>
            <br>
            <span id="creattask" style="color: pink"></span>
            <br>
            <span style="color: grey;">截止日期</span>
            <br>
            <span id="downtask" style="color: pink"></span>
            <br><br>
            <br>
            <textarea placeholder="发表评论"
                      style=" calc(5px);margin-left: 0px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px;"></textarea>
            <br>
            <button id="task_comsure" class="ps_btn" style="margin-top: 5px; font-size: 15px;">评论</button>
        </div>

        <div id="task_ed" style="margin-left: 210px;margin-top:-20px;width: 960px;">
            <a href="#" class="backtask" class="infolderdiv" style="font-size: 25px;color: pink;">任务名称</a>
            <br><a style="font-size: 25px;color: white;"> > </a>
            <input type="text"
                   style="font-size: 25px;color: pink;border-left:0px;border-top:0px;border-right:0px;border-bottom:1px;background-color: transparent"
                   id="taskname">
            <br>
            <br>
            <span style="color: grey;">指派成员完成该任务</span>
            <div id="people1">
            </div>

            <!--日历-->
            <br>
            <br>
            <span style="color: grey;">截止日期</span>
            <br>
            <input  id="time2" name="createdatetimeStart" style="width: 120px;border: none;background-color: #212121;color: #0abd6a;cursor: pointer;font-size: 20px"
                    onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
            <br><br>
            <button id="task_edsure" class="ps_btn" style="margin-top: 5px; font-size: 15px;" onclick="cTask2()">保存</button>
        </div>

        <!--清单详情-->
        <div id="list_detail" style="margin-left: 210px;margin-top:-20px;width: 960px;">
            <a href="#" class="backlist" class="infolderdiv" style="font-size: 25px;color: pink;">所有清单</a>
            <a style="font-size: 25px;color: white;"> > </a>
            <a style="font-size: 25px;color: white;">买1斤大白菜</a>
            <button class="ps_btn" id="list_ined">编辑</button>
            <button class="ps_btn" id="list_follow" style="margin-left: 20px;">关注</button>
            <button class="ps_btn" style="margin-left: 20px;">删除</button>
            <br>
            <br>
            <a style="color: white;margin-left: 0px;">买1斤大白菜</a>
            <br><br>
            <p id="list_com1" style="color:white ;">PG ONE : 这是一条新的评论</p>
            <br>
            <textarea placeholder="发表评论"
                      style=" calc(5px);margin-left: 0px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px;"></textarea>
            <br>
            <button id="list_comsure" class="ps_btn" style="margin-top: 5px; font-size: 15px;">评论</button>
        </div>

        <div id="list_ed" style="margin-left: 210px;margin-top:-20px;width: 960px;">
            <textarea placeholder="请输入任务名称"
                      style=" calc(5px);margin-left: 0px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px;">买1斤大白菜</textarea>
            <br>
            <button id="list_edsure" class="ps_btn" style="margin-top: 5px; font-size: 15px;">保存</button>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#task_alltask").show()
                $("#task_detail").hide()
                $("#task_ed").hide()
                $("#list_detail").hide()
                $("#list_ed").hide()

                $("#list1").click(function () {
                    $("#task_alltask").hide()
                    $("#list_detail").show()
                })

                $(".backlist").click(function () {
                    $("#task_alltask").show()
                    $("#list_detail").hide()
                })

                $("#list_ined").click(function () {
                    $("#list_detail").hide()
                    $("#list_ed").show()
                })

                $("#list_edsure").click(function () {
                    $("#list_ed").hide()
                    $("#list_detail").show()
                })

                $("#list_com1").hide()
                $("#list_comsure").click(function () {
                    $("#list_com1").slideDown()
                })

                $("#list_follow").click(function () {
                    $("#list_follow").css("background-color", "deepskyblue")
                })


                $("#task_edsure").click(function () {
                    $("#task_detail").show()
                    $("#task_ed").hide()
                })
                $("#task_ined").click(function () {
                    $("#task_detail").hide()
                    $("#task_ed").show()
                })

                $("#task_follow").click(function () {
                    $("#task_follow").css("background-color", "deepskyblue")
                })

                $("#task_com1").hide()
                $("#task_comsure").click(function () {
                    $("#task_com1").slideDown()
                })

                $("#task1_sure").click(function () {
                    $("#task_detail").hide()
                    $("#task_alltask").show()
                })
                $("#task1_cancel").click(function () {
                    $("#task_detail").hide()
                    $("#task_alltask").show()
                })
                $("#task1").click(function () {
                    $("#task_detail").show()
                    $("#task_alltask").hide()
                })
                $(".backtask").click(function () {
                    $("#task_detail").hide()
                    $("#task_alltask").show()
                })
            })
        </script>

        <!--点击添加任务弹出DIV-->
        <div id="addtaskdiv" style="margin-left: 200px;margin-top: -30px;margin-bottom: 70px;">
            <a href="#" class="backtask" class="infolderdiv" style="font-size: 25px;color: pink;">任务名称</a><br>
            <input type="text" style="font-size: 25px;color: pink;border-left:0px;border-top:0px;border-right:0px;border-bottom:1px;background-color: transparent" id="newtaskname">
            <br>
            <a href="#" class="backtask" class="infolderdiv" style="font-size: 25px;color: pink;">任务描述</a>
            <br>
            <textarea type="text"
                   style="color: pink;background-color: transparent" id="taskmiao">
            </textarea>
            <br><br>

            <span style="color: grey;">指派成员完成该任务</span>
            <div id="people2">
            </div>
            <!--日历-->
            <br>
            <br>
            <span style="color: grey;">截止日期</span>
            <br>
            <input  id="time1" name="createdatetimeStart" style="width: 120px;border: none;background-color: #212121;color: #0abd6a;cursor: pointer;font-size: 20px"
                    onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
            <br>
            <br>
            <button id="addtask_sure" class="ps_btn" style="font-size: 20px;" onclick="newTask2()">确定</button>
            <button id="addtask_cancel" class="ps_btn" style="font-size: 20px;">取消</button>
        </div>

        <!--点击添加清单弹出DIV-->
        <div id="addlistdiv" style="margin-left: 200px;margin-top: -30px;margin-bottom: 70px;">
            <textarea id="listinput"
                      style="height: 30px;resize: none;font-size: 20px;background-color: #212121;border-radius: calc(5px);color: pink;"
                      placeholder="新的清单"></textarea>
            <br>
            <br>
            <button id="addlist_sure" class="ps_btn" style="font-size: 20px;">保存</button>
            <button id="addlist_cancel" class="ps_btn" style="font-size: 20px;">取消</button>
        </div>

        <!--任务栏-->
        <div id="task_alltask" style="margin-left: 200px;margin-top: -30px;">
            <a style="font-size: 25px;color: white;">当前任务</a>
            <br>
            <%--<input id="mycheckboxt1" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">--%>
            <div id="taskadd">

            </div>

            <!--清单栏-->
            <div id="task_list" style="margin-left: 0px;margin-top: 30px;">
                <a style="font-size: 25px;color: white;">当前清单</a>
                <br>
                </a>
            </div>
        </div>
    </div>

    <!--讨论-->
    <div id="discussdiv">
        <ul class="menu" style="  background-color: #212121;border: none;">
            <li>
                <a id="inadddiscuss1" href="#">- 发起讨论 -</a>
                <ul class="submenu">
                    <li><a id="inadddiscuss2" style="text-align: center;" href="#">发起讨论</a></li>
                    <li><a id="" style="text-align: center;" href="#">发起视频讨论</a></li>
                </ul>
            </li>
        </ul>
        <!--新建讨论&富文本编辑器-->
        <div id="adddiscussdiv" style="margin-left: 210px;margin-top:10px;">
            <input id="dTopic" name="dTopic"   placeholder="标题" style=" calc(5px);margin-top: 10px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px;"></input>
            <br>
            <input id="dContent" name="dContent" placeholder="编辑讨论内容" style="margin-top: 10px;height: 200px;width: 600px;border-radius: calc(5px);background-color: #212121;resize: none;color: pink;font-size: 20px;"></input>
            <br>,
            <br />
            <button id="adddiscuss_sure" class="ps_btn" style="font-size: 20px;" onclick="startdiscus()">发起讨论</button>
            <button id="adddiscuss_cancel" class="ps_btn" style="font-size: 20px;">取消</button>
        </div>
        <!--讨论列表-->
        <div id="discus_all" style="margin-left: 210px;margin-top:10px;">
            <a style="font-size: 25px;color: white;">当前讨论</a>
            <br>
            <%--<button class="ps_btn" href="#" style="display: inline;font-size: 20px;">PG ONE万磁王</button>--%>
            <%--</br>--%>
            <%--</br>--%>
            <%--<a class="discuss1 " href="#	" style="color: white;margin-left: 55px; font-weight: bold;">竞猜：谁是冠军!!</a></br>--%>
            <%--<a class="discuss1 " href="#" style="color: grey;margin-left: 55px;font-size: 15px;">大家都来说说今晚我会不会拿冠军</a>--%>
            <!--评论列表-->
            <%--<div style="margin-left: 55px;margin-top:10px;">--%>
                <%--<a id="discuss_newcom" style="color: white;font-size: 15px;"><span>勇郭：</span>这是一条新添加的评论</a>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<div id="discuss1div">--%>
                <%--<textarea placeholder="标题" style=" calc(5px);margin-left: 55px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px;"></textarea>--%>
                <%--<br>--%>
                <%--<button id="discuss1com_sure" class="ps_btn" style="margin-left: 55px;margin-top: 5px; font-size: 15px;">评论</button>--%>
                <%--<button id="discuss1com_cancel" class="ps_btn" style="margin-left: 10px; font-size: 15px;">取消</button>--%>
                <%--<!--CLICK显示隐藏功能-->--%>
            <%--</div>--%>
            <%--<div class="discuss1 discuss1hide" style="margin-left: 60px;margin-top:-30px;">--%>
                <%--<button class="ps_btn" id="indiscuss1com">评论</button>--%>
                <%--<button class="ps_btn" style="margin-left: 20px;">关注</button>--%>
                <%--<button class="ps_btn" style="margin-left: 20px;">编辑</button>--%>
                <%--<button class="ps_btn" style="margin-left: 20px;">删除</button>--%>
            </div>
            <%--讨论单个的表--%>
            <div id="discus_one" style="margin-left: 210px;margin-top:10px;">
                <%--讨论的内容--%>
                <div id="discus_one_discus">
                </div>
                <%--评论的内容--%>
                <div id="discus_one_comment">
                </div>
                <%--提交评论的内容--%>
                <div id="discus_one_addcomment" hidden>
                    评论:<input id="cContent" name="cContent" type="text" style="height: 100px;width: 400px;border-radius: calc(5px);background-color: #212121;resize: none;color: pink;font-size: 20px;">
                    <div id="didiscus_one_addcomment_buttom">
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!--文件-->
    <div id="filediv">
        <!--左列菜单-->
        <ul class="menu" style="  background-color: #212121;border: none;">
            <li>
                <a id="inaddtask1" href="#">- 上传文件 -</a>
                <ul class="submenu">
                    <li><a id="inaddtask2" style="text-align: center;" onclick="upfile()">上传文件</a></li>
                    <li><a id="inaddlist" style="text-align: center;" onclick="openfolder()" href="#">创建文件夹</a></li>
                </ul>
            </li>
        </ul>
        <%--上传文件模块--%>
        <div id="upfile" style="margin-left: 210px;margin-top:10px;width: 960px;" hidden>
            <form id= "uploadForm" enctype="multipart/form-data">
                <p>上传文件： <input type="file" name="file"/></p>
                <input class="ps_btn" type="button" value="上传" onclick="doUpload()"/>
            </form>
            <button class="ps_btn" onclick="closefile()">取消</button>
        </div>
        
        <%--创建文件夹模块--%>
        <div id="creatfolder" style="margin-left: 210px;margin-top:10px;width: 960px;" hidden>
            文件夹名：<input id="folderName" type="text" name="folderName" >
            <button onclick="startfolder()">创建文件夹</button>
            <button onclick="closefolder()">取消</button>
        </div>
        <!--核心内容-->
        <div id="file_folderdiv" style="margin-left: 210px;margin-top:10px;width: 960px;">
            <a style="font-size: 25px;color: white;">文件夹列表</a>
            <br>
            <br>
            <%--<span style="color: white;">--%>
            <%--<i class="icono-folder" id="file_folder1" style="cursor: pointer;margin-left: 10px;"></i>--%>
            <%--需求文档--%>
            <%--</span>--%>
            <%--<span style="color: white;margin-left: 20px;">--%>
            <%--<i class="icono-folder" id="file_folder2" style="cursor: pointer;margin-left: 10px;"></i>--%>
            <%--参考资料--%>
            <%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<button class="ps_btn" id="inallfile" style="border: none;">查看所有文件</button>--%>
        </div>

        <!--需求文档点进去文件列表-->
        <div id="file_filediv1" style="margin-left: 210px;margin-top:10px;width: 960px;">
            <%--<a href="#" class="infolderdiv" style="font-size: 25px;color: pink;">文件夹列表</a>--%>
            <%--<a style="font-size: 25px;color: white;"> > </a>--%>
            <%--<a style="font-size: 25px;color: white;">需求文档</a>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--需求文档终板--%>
				<%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<button style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--笑话十则--%>
					 <%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				    <%--<buton style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
        </div>

        <%--<!--参考资料点进去文件列表-->--%>
        <%--<div id="file_filediv2" style="margin-left: 210px;margin-top:10px;width: 960px;">--%>
            <%--<a href="#" class="infolderdiv" style="font-size: 25px;color: pink;">文件夹列表</a><a style="font-size: 25px;color: white;"> > 参考资料</a>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--JAVA从入门到放弃--%>
				<%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<button style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--终极算法全篇--%>
					 <%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<buton style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
        <%--</div>--%>

        <%--<div id="file_allfile" style="margin-left: 210px;margin-top:10px;width: 960px;">--%>
            <%--<a href="#" class="infolderdiv" style="font-size: 25px;color: pink;">文件夹列表</a><a style="font-size: 25px;color: white;"> > 所有文件</a>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--JAVA从入门到放弃--%>
				<%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<button style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--终极算法全篇--%>
					 <%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<buton style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--需求文档终板--%>
				<%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<button style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<span style="color: white;">--%>
					<%--<i class="icono-file"  style="cursor: pointer;margin-left: 10px;"></i>--%>
					 <%--笑话十则--%>
					 <%--<button class="ps_btn" href="#" style="border: none;" >下载</button>--%>
				<%--<buton style="border: none;" class="ps_btn" href="#" >删除</button>--%>
				<%--</span>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!--日程-->
    <div id="schedulediv">
        <!--左列菜单-->
        <ul class="menu" style="  background-color: #212121;border: none;">
            <li>
                <a id="inaddschedule" href="#">- 创建日程 -</a>
            </li>
        </ul>
        <!--核心内容-->
        <div id="allschedulediv" style="margin-left: 210px;margin-top:10px;width: 960px;">
            <button class="ps_btn" id="inedschedule1" style="white;font-size: 25px;">2017年春游</button>
            <br>
            <a style="color: white;">2017年3月1日~2017年3月7日</a>
            <a style="color: grey;font-size: 15px;margin-left: 10px;">参与人：BF、JX、JH</a>
            <div class="menu-sep" style="width: 900px;margin-left: 0px;margin-top: 20px;margin-bottom: 20px;"></div>

            <button class="ps_btn" style="white;font-size: 25px;">国庆聚餐</button>
            <br>
            <a style="color: white;">2016年10月1日~2017年10月2日</a>
            <a style="color: grey;font-size: 15px;margin-left: 10px;">参与人：BF、JX、JH</a>
            <div class="menu-sep" style="width: 900px;margin-left: 0px;margin-top: 20px;margin-bottom: 20px;"></div>
        </div>

        <!--创建日程-->
        <div id="addschedulediv" style="margin-left: 210px;margin-top:10px;width: 960px;">
            <a id="backschedule1" href="#" style="font-size: 25px;color: pink;">日程</a>
            <a style="font-size: 25px;color: white;"> > 创建日程</a>
            </br>
            </br>
            <textarea cols="70" rows="5" placeholder="在这里输入日程内容"
                      style=" calc(5px);margin-left: 6px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;font-size: 20px;"></textarea>
            <br>
            <br><span style="color: grey;">开始</span>
            <input id="dd" type="text" class="easyui-datebox" required="required"></input>
            <br>
            <br><span style="color: grey;">结束</span>
            <input id="dd" type="text" class="easyui-datebox" required="required"></input>
            <br>
            <br><span style="color: grey;">重复</span>

            <label style="margin-left: 30px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每日</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每周</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每月</span>
            <br>

            <label style="margin-left:66px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每年</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">隔周</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">不重复</span>
            <br>
            <br>

            <span style="color: grey;">提醒</span>
            <label style="margin-left: 30px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">提前一天</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">提前一周</span>
            <br>

            <label style="margin-left: 66px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">不提醒</span>
            <label style="margin-left: 27px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">提前一小时</span>
            <br>
            <br>
            <span style="color: grey; float: left;">地点</span>
            <textarea cols="30" rows="1" placeholder="请输入地点"
                      style="resize: none;font-size: 15px;margin-left: 10px;border-radius: calc(5px);background-color: #212121;color: pink;"></textarea>
            <br>
            <br>
            <span style="color: grey;">邀请其他人加入</span>
            <input id="mycheckbox	b1" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">BF</a>
            <input id="mycheckboxb2" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">JX</a>
            <input id="mycheckboxb3" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">YG</a>
            <br>
            <br>
            <button id="addschedule_sure" class="ps_btn" style="font-size: 20px;">创建</button>
            <button id="addschedule_cancel" class="ps_btn" style="font-size: 20px;">取消</button>

        </div>

        <!--点击进入日程2017春游-->
        <div id="edschedule1" style="margin-left: 210px;margin-top:10px;width: 960px;">
            <a id="backschedule2" href="#" style="font-size: 25px;color: pink;">日程</a>
            <a style="font-size: 25px;color: white;"> > 2017年...</a>
            </br>
            </br>
            <textarea cols="70" rows="5" placeholder="点击此处编辑日程内容"
                      style=" calc(5px);margin-left: 6px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;font-size: 20px;">2017年春游</textarea>
            <br>
            <br><span style="color: grey;">开始</span>
            <input id="dd" type="text" class="easyui-datebox" value="2017-03-01" required="required"></input>
            <br>
            <br><span style="color: grey;">结束</span>
            <input id="dd" type="text" class="easyui-datebox" value="2017-03-07" required="required"></input>
            <br>
            <br><span style="color: grey;">重复</span>

            <label style="margin-left: 30px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每日</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每周</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom" checked="true" ;/>
            </label>
            <span style="color:white">每月</span>
            <br>

            <label style="margin-left:66px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">每年</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">隔周</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="x" class="checked-boom"/>
            </label>
            <span style="color:white">不重复</span>
            <br>
            <br>

            <span style="color: grey;">提醒</span>
            <label style="margin-left: 30px;">
                <input type="radio" name="xx" class="checked-boom"/>
            </label>
            <span style="color:white">提前一天</span>
            <label style="margin-left: 10px;">
                <input type="radio" name="xx" class="checked-boom" checked="true"/>
            </label>
            <span style="color:white">提前一周</span>
            <br>

            <label style="margin-left: 66px;">
                <input type="radio" name="xx" class="checked-boom"/>
            </label>
            <span style="color:white">不提醒</span>
            <label style="margin-left: 27px;">
                <input type="radio" name="xx" class="checked-boom"/>
            </label>
            <span style="color:white">提前一小时</span>
            <br>
            <br>
            <span style="color: grey; float: left;">地点</span>
            <textarea cols="30" rows="1" placeholder="请输入地点"
                      style="resize: none;font-size: 15px;margin-left: 10px;border-radius: calc(5px);background-color: #212121;color: pink;">德国、意大利、日本</textarea>
            <br>
            <br>
            <span style="color: grey;">邀请其他人加入</span>
            <input id="mycheckboxc1" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">BF</a>
            <input id="mycheckboxc2" name="a" type="checkbox" checked="true" class="checkbix" data-shape="circled"
                   data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">JX</a>
            <input id="mycheckboxc3" name="a" type="checkbox" checked="true" class="checkbix" data-shape="circled"
                   data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">YG</a>
            <br>
            <br>
            <button id="edschedule1_sure" class="ps_btn" style="font-size: 20px;">保存日程</button>
            <button id="edschedule1_cancel" class="ps_btn" style="font-size: 20px;">取消</button>

        </div>
    </div>

    <div id="countdiv">
        <!--待处理任务（统计）-->
        <div style="margin: 30px;">

            <ul class="menu" style="  background-color: #212121;border: none;">
                <li>
                    <a id="incountdiv1" href="#">总任务数（3）</a>
                    <ul class="submenu">
                        <li><a id="incountdiv2" style="text-align: center;" href="#">延误任务（1）</a></li>
                        <li><a id="incountdiv3" style="text-align: center;font-size: 15px;" href="#">待处理任务（1）</a></li>
                    </ul>
                </li>
            </ul>

            <div id="countdiv1" style="margin-left: 210px;margin-top:10px;width: 960px;">
                <h2 style="color: white;">进展</h2>
                <div class="menu-sep"
                     style="color: white; margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
                <span style="color: white; ">晚会后期准备   </span>
                <button style="width: 300px;height: 20px;background-color: gpalegreen;border-radius: calc(5px);"></button>
                <span style="color: grey;">0/1</span>
                <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

                <span style="color: white; ">晚会前期准备</span>
                <button style="width: 300px;height: 20px;background-color: pink;border-radius: calc(5px);"></button>
                <span style="color: grey;">1/1</span>
                <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

                <span style="color: white; ">晚会灯光问题</span>
                <button style="width: 300px;height: 20px;background-color: orangered;border-radius: calc(5px);"></button>
                <span style="color: grey;">0/1</span>
                <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

                <br>
                <h2 style="color: white;">贡献</h2>
                <p style="color: grey;">截至目前，共有 2 位成员对项目做出了贡献，产生 3 条讨论，上传 3 个文件。</p>
                <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
                <img src="img/fzl.jpg" style="height: 30px;"/><span style="font-size: 15px;color: white;">小明   </span>
                <button title="小明完成了5条任务"
                        style="width: 200px;height: 20px;background-color: pink;border-radius: calc(5px);">5
                </button>
                <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
                <img src="img/fzl2.jpg" style="height: 30px;"/><span style="font-size: 15px;color: white;">小娜   </span>
                <button title="小娜完成了2条任务"
                        style=" width:40px;height: 20px;background-color: pink;border-radius: calc(5px);">1
                </button>
            </div>

            <div id="countdiv2" style="margin-left: 210px;margin-top:10px;width: 960px;">
                <h2 style="color: white;">延误任务</h2>
                <br>
                <span style="color: white;margin-top: 20px;">晚会灯光问题</span>
                <button style="width: 300px;height: 20px;background-color: orangered;border-radius: calc(5px);"></button>
                <span style="color: grey;">0/1</span>
            </div>

            <div id="countdiv3" style="margin-left: 210px;margin-top:10px;width: 960px;">
                <h2 style="color: white;">待处理任务</h2>
                <br>
                <span style="color: white; ">晚会后期准备   </span>
                <button style="width: 300px;height: 20px;background-color: gpalegreen;border-radius: calc(5px);"></button>
                <span style="color: grey;">0/1</span>
            </div>
        </div>
    </div>

    <!--成员-->
    <div id="memberdiv" style="margin-left: 30px;">
        <a style="color: white;font-weight: lighter;font-size: 30px;">项目成员</a>
        <button id="member_ed" class="ps_btn" style="margin-left: 20px;">编辑</button>
        <button id="member_quit" class="ps_btn" style="margin-left: 10px;">退出项目</button>
        <br>
        <div id="allmember">
            <img src="img/fzl6.jpg" height="50px" style="margin-top: 20px;"/>
            <a style="font-size: 25px;color: pink;margin-left: 5px;">蜜桃酱儿</a>
            <a style="font-size: 20px;color: orange;">超级管理员</a>
            <br>
            <img src="img/fzl5.jpg" height="50px" style="margin-top: 20px;"/>
            <a style="font-size: 25px;color: pink;margin-left: 5px;">PG ONE万磁王</a>
            <a style="font-size: 20px;color: palegoldenrod;">管理员</a>
            <br>
            <img src="img/fzl7.jpg" height="50px" style="margin-top: 20px;"/>
            <a style="font-size: 25px;color: pink;margin-left: 5px;">哞哞牛</a>
            <a style="font-size: 20px;color: white;">成员</a>
        </div>

        <div id="edmember">
            <p style="color: white;margin-top: 30px;">选择项目成员</p>
            <p style="color: grey;">管理员可以邀请和移除项目成员，只有被邀请的团队成员才能访问该项目的信息。点击这里查看如何设置成员权限。</p>
            <br>
            <input id="w1" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">PG ONE万磁王</a>
            <br>
            <input id="w2" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">蜜桃酱儿</a>
            <br>
            <input id="w3" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">锦飞哥哥</a>
            <br>
            <input id="w4" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">加薪弟弟</a>
            <br>
            <input id="w5" name="a" type="checkbox" class="checkbix" data-shape="circled" data-text="">
            <a href="#" style="color: pink;margin-left: -10px;">程老师</a>
            <br>
            <br>

            <button id="member_save" class="ps_btn" style="font-size: 20px;">保存项目成员</button>
        </div>
    </div>
</div>

</body>

</html>
