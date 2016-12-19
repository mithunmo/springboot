<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!---set specific id to set  popup width-------->
<!-- <link rel="stylesheet" href="/css/uploadify/uploadify.css" type="text/css" media="all" /> -->
<div class="popup" id="upload"> 
<div class="header">
	<spring:message code="${filetype.titleMessageCode}" />
    <div class="close">X</div>
</div>
	<!---Set id to fill in data--->
	<div class="content" id="popup_upload">
		<div class="upload_info">
			<h3><spring:message code="${filetype.contentMessageCode}" /></h3>
			<div class="description">
				Support file type:&nbsp; 
				<b><spring:message code="${filetype.typesMessageCode}" /></b>
				<div>	
					<p>Click on the select files button to upload</p>
				</div>
			</div>
		</div>
		<input id="uploadify" type="file">
 		<%-- <form:form modelAttribute="uploadbean" method="post" enctype="multipart/form-data">
 		</form:form> --%>
	</div>    
</div>