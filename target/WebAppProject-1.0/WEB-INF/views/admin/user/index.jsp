<%@include file="../shared/header.jsp" %>
<h1>Skills</h1>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="skill" items="${requestScope.skills}">
        <tr>
            <td>${skill.id}</td>
            <td>${skill.name}</td>
            <td>Edit Delete</td>
        </tr>
    </c:forEach>
</table>
<%@include file="../shared/footer.jsp" %>