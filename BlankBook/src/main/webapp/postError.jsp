<!DOCTYPE html>
<html>
<head>

<jsp:include page="mainHeader.jsp"/>

</head>
<body>

<div class="px-4 py-5 my-5 text-center">
  <img class="d-block mx-auto mb-4" src="./brand/bootstrap-logo.svg" alt="" width="72" height="57">
  <h1 class="display-5 fw-bold">Connection failure</h1>
  <div class="col-lg-6 mx-auto">
    <p class="lead mb-4">Sorry but something went wrong. Want to try again?</p>
    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
    <form id="Retry" action="/BlankBook/main.jsp" method="GET">
    	<button type="submit" class="btn btn-primary btn-lg px-4 me-sm-3">Try Again</button>
    </form>

    </div>
  </div>
</div>

</body>
</html>