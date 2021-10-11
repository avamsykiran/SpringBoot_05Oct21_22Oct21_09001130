<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/header" />
<main class="container-fluid p-4">

	<div class="col-sm-5 mx-auto">
		<h3 class="text-center mb-2">Loan Example</h3>

		<form:form class="form bg-primary p-2 mb-2" method="POST"
			modelAttribute="loan">
			<div class="form-group">
				<form:label path="prinicpal">Prinicpal</form:label>
				<form:input path="prinicpal" class="form-control" type="number" />
			</div>
			<div class="form-group">
				<form:label path="rateOfInterest">ROI</form:label>
				<form:input path="rateOfInterest" class="form-control"
					type="decimal-local" />
			</div>
			<div class="form-group">
				<form:label path="term">Number of Months</form:label>
				<form:input path="term" class="form-control" type="number" />
			</div>
			<div class="form-group">
				<form:label path="type">Loan Type</form:label>
				<form:select path="type" class="form-control" items="${loanTypes }" />
			</div>
			<button class="btn btn-secondary btn-block">Compute</button>
		</form:form>

		<div class="alert alert-info p-2">
			EMI: <strong>${loan.emi }</strong>
		</div>
	</div>

</main>
<jsp:include page="/footer" />