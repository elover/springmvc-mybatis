<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">添加新同学</stripes:layout-component>
   <stripes:layout-component name="script">
      <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
   </stripes:layout-component>
   <stripes:layout-component name="legend">添加新同学</stripes:layout-component>
   <stripes:layout-component name="content">
      <form action="${ctx}/console/student/save" method="post">
         <table class="tableForm">
            <tr>
               <th>学号：</th>
               <td><input type="text" name="studentId" id="studentId" />
               <input type="button" class="btn" value="检测学号是否可用" id="checkId" /><form:errors path="studentId" cssClass="error" /></td>
            </tr>
            <tr>
               <th>姓名：</th>
               <td><input type="text" name="name" /><form:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
               <th>密码：</th>
               <td><input type="password" name="password" /></td>
            </tr>
            <tr>
               <th>专业：</th>
               <td><input type="text" name="major" /></td>
            </tr>
            <tr>
               <th>年龄：</th>
               <td><input type="text" name="age" /></td>
            </tr>
            <tr>
               <th>备注：</th>
               <td><input type="text" name="remark" /></td>
            </tr>
            <tr>
               <th></th>
               <td><input type="submit" name="register" value="提交" class="btn" /> &nbsp;<input type="reset"
                  name="reset" value="重填" class="btn" /></td>
            </tr>
         </table>
      </form>
      <script type="text/javascript">
		$("#checkId").click(function() {
			var studentId = document.getElementById("studentId").value;
			if (studentId=="") {
				alert("学号不能为空！");
                return false;
			}
			$.ajax({
				type : "POST",
				url : "${ctx}/console/student/"+ studentId +"/check",
				dataType : "html",
				data : $("form").serialize(),
				success : function(msg) {
					if (msg == "success") {
						alert("学号未占用！");
					} else if (msg == "false") {
						alert("学号已被占用！");
					}
				}
			});

		});
	</script>
   </stripes:layout-component>
</stripes:layout-render>