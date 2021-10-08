<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<main class="container-fluid p-4">

	<h3>Arithemtic Example</h3>
	<form class="form-inline">
		<input type="number" placeholder="Operand1" name="op1" class="form-control mr-2" required />
		<input type="number" placeholder="Operand2" name="op2" class="form-control mr-2" required />
		<button class="btn btn-primary btn-sm mr-2" formaction="/arth/sum">SUM</button>
		<button class="btn btn-primary btn-sm mr-2" formaction="/arth/dif">Difference</button>
		<button class="btn btn-primary btn-sm mr-2" formaction="/arth/prd">Product</button>
		<button class="btn btn-primary btn-sm mr-2" formaction="/arth/qut">Quotiont</button>
	</form>
	
	<c:if test="${msg ne null }">
		<div class="alert alert-info p-2 mt-2">
			<strong>${msg }</strong>
		</div>
	</c:if>
</main>
<jsp:include page="/footer" />