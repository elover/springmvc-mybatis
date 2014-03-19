<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="script">
   <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
   <script language="javascript">
   function getJsonData(studentId) {
        var cfg = {
           type: 'POST',
           url: '${ctx}/console/student/'+ studentId +'/json',
           dataType: 'json',
           contentType:'application/json;charset=UTF-8',
           success: function(student) {
               document.getElementById('studentId').innerText = student.studentId;
               document.getElementById('name').innerText = student.name;
               document.getElementById('major').innerText = student.major;
               document.getElementById('age').innerText = student.age;
               document.getElementById('remark').innerText = student.remark;
               if (student.photo!=null) {
                  document.getElementById('photo').src = "${ctx}/photo/" + student.photo;
                  document.getElementById('photo').style.height = '200px';
               } else {
                  document.getElementById('photo').src = '';
                  document.getElementById('photo').style.height = '0px';
               }
           }
         };
      $.ajax(cfg);
   }
   
   function getJsonList() {
        var cfg = {
           type: 'POST',
           url: '${ctx}/console/student/jsonList',
           dataType: 'json',
           contentType:'application/json;charset=UTF-8',
           success: function(list) {
               var selectStudent = document.getElementById('selectStudent');
               selectStudent.options.length = 0;
               for (var i = 0; i < list.length; i++ ) {
                  var student = list[i];
                  var varItem = new Option(student.name, student.studentId);
                  selectStudent.options.add(varItem);
               }
           }
         };
      $.ajax(cfg);
   }
   </script>
   </stripes:layout-component>
   <stripes:layout-component name="title">学生列表</stripes:layout-component>
   <stripes:layout-component name="legend">学生列表</stripes:layout-component>
   <stripes:layout-component name="content">
      <table class="tableList">
         <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>专业</th>
            <th>年龄</th>
            <th>操作</th>
         </tr>
         <c:forEach items="${studentList}" var="student">
            <tr onclick="getJsonData('${student.studentId}');">
               <td>${student.studentId}</td>
               <td>${student.name}</td>
               <td>${student.password}</td>
               <td>${student.major}</td>
               <td>${student.age}</td>
               <td><a href="${ctx}/console/student/${student.studentId}">查看</a>
               <a href="${ctx}/console/student/${student.studentId}/edit">编辑</a> <a
                  href="${ctx}/console/student/${student.studentId}/delete">删除</a> </td>
         </c:forEach>
      </table>
          <table class="tableForm">
            <tr>
               <th>学号：</th>
               <td id="studentId"></td>
            </tr>
            <tr>
               <th>姓名：</th>
               <td id="name"></td>
            </tr>
            <tr>
               <th>专业：</th>
               <td id="major"></td>
            </tr>
            <tr>
               <th>年龄：</th>
               <td id="age"></td>
            </tr>
            <tr>
               <th>备注：</th>
               <td id="remark"></td>
            </tr>
            <tr>
               <th>照片：</th>
               <td><img id="photo" src="" style="height: 0px;"/></td>
            </tr>
         </table><br/>
         ajax加载select下拉单
         <input type="button" value="加载下拉菜单" onclick="getJsonList();" />
         <select id="selectStudent">
            <option value="">请选择</option>
         </select>
   </stripes:layout-component>
</stripes:layout-render>