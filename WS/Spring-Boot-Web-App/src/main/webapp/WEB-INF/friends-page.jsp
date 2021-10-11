<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<main class="container-fluid p-4">

	<h3>Friends Example</h3>
	<form class="form-inline">
		<input type="text" placeholder="Friend Name" name="fnm" class="form-control mr-2" />
		<button class="btn btn-primary btn-sm">ADD</button>
	</form>
	
	<c:if test="${(friends!=null) && (friends.size()>0) }">
		<ol class="alert alert-info p-2 mt-2">
			<c:forEach var="f" items="${friends }">
				<li>${f }</li>
			</c:forEach>
		</ol>
	</c:if>
</main>
<jsp:include page="/footer" />