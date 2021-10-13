<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/header" />
<main class="container-fluid p-4">

	<div class="col-sm-6 mx-auto">
		<h3 class="text-center mb-2">Employee</h3>
		<form:form class="form bg-info p-4" modelAttribute="emp" method="POST">
			<div class="form-group">
				<form:label path="empId">Employee Id</form:label>
				<form:input path="empId" readonly="true" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="fullName">Full Name</form:label>
				<form:input path="fullName" class="form-control"/>
				<form:errors path="fullName" />
			</div>
			<div class="form-group">
				<form:label path="salary">Salary</form:label>
				<form:input path="salary" tye="number" class="form-control"/>
				<form:errors path="salary" />
			</div>
			<div class="form-group">
				<form:label path="joinDate">Join Date</form:label>
				<form:input path="joinDate" type="date" class="form-control"/>
				<form:errors path="joinDate" />
			</div>
			<button class="btn btn-secondary btn-block">SAVE</button>
		</form:form> 
	</div>
</main>
<jsp:include page="/footer" />