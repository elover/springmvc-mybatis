<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">添加课程</stripes:layout-component>
   <stripes:layout-component name="script">
      <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
      <script type="text/javascript">
function getJson() {
	var courseId = document.getElementById('courseId').value;
	var name = document.getElementById('name').value;
	var teacher = document.getElementById('teacher').value;
	var jsonStr = {
		"courseId" : courseId,
		"name" : name,
		"teacher" : teacher
	};
    if (courseId == '' || name == '') {
      alert("courseId = null");
      return false; 
    }
	var cfg = {
		type : 'POST',
		url : '${ctx}/console/course/jsonSave',
		data : JSON.stringify(jsonStr),
		dataType: 'html',
        contentType:'application/json;charset=UTF-8',
		success : function(data) {
            var msg = document.getElementById('msg');
            if (data == "true") {
               msg.style.color = "green";
               msg.innerText = "添加成功";
            } else {
               msg.style.color = "red";
               msg.innerText = "添加失败：课程号已存在";
            }
           // $("#msg").fadeIn(1500);
           // $("#msg").fadeOut(3500);
           $("#msg").fadeIn(1000).delay(3000).fadeOut(1000);
		}
	};
	$.ajax(cfg);
}
</script>
   </stripes:layout-component>
   <stripes:layout-component name="legend">添加课程</stripes:layout-component>
   <stripes:layout-component name="content">
      <form action="${ctx}/console/course/save" id="inputForm" method="post">
         <table class="tableForm">
            <tr>
               <th>课程编号：</th>
               <td><input type="text" name="courseId" id="courseId" /></td>
            </tr>
            <tr>
               <th>课程名称：</th>
               <td><input type="text" name="name" id="name" /></td>
            </tr>
            <tr>
               <th>主讲教师：</th>
               <td><input type="text" name="teacher" id="teacher" /></td>
            </tr>
            <tr>
               <th></th>
               <td><input type="submit" name="submit" value="提交" class="btn" /> &nbsp;<input type="reset"
                  name="reset" value="重填" class="btn" />
                   <input type="button" name="submit2" value="JSON无刷新提交" class="btn" onclick="getJson();" />
                  <span id="msg" style="padding-left:1em;color: green"></span> &nbsp;<br/><a href="batchInput">批量录入</a></td>
            </tr>
         </table>
      </form>
   </stripes:layout-component>
</stripes:layout-render>