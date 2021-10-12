<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/header" />
<main class="container-fluid p-4">

	<h3>Employee List</h3>
	
	<c:choose>
		<c:when test="${emps ne null and emps.size()>0}">
			<table class="table table-border table stripped mt-2">
				<thead>
					<tr>
						<th>Employee#</th>
						<th>Name</th>
						<th>Salary</th>
						<th>Join Date</th>
				</thead>
				<tbody>
					<c:forEach items="${emps }" var="e">
						<tr>
							<td>${e.empId }</td>
							<td>${e.fullName }</td>
							<td>${e.salary }</td>
							<td>${e.joinDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alet alert-info p-2 mt-2">
				<strong>No employee records.</strong>
			</div>
		</c:otherwise>
	</c:choose>
</main>
<jsp:include page="/footer" />