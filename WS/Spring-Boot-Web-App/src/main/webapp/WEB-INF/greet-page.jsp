<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<main class="container-fluid p-4">

	<h3>Greeting Example</h3>
	<form class="form-inline">
		<input type="text" placeholder="User Name" name="unm" class="form-control mr-2" />
		<button class="btn btn-primary btn-sm">GREET</button>
	</form>
	
	<c:if test="${msg ne null }">
		<div class="alert alert-info p-2 mt-2">
			<strong>${msg }</strong>
		</div>
	</c:if>
</main>
<jsp:include page="/footer" />