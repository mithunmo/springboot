<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
<spring:message code="${filetype.failMessageCode}" />
</div>
<input type="hidden" id="upload_status" value="${upload_status}" />
<%-- <input type="hidden" id="upload_filename" value="${upload_filename}" />
<input type="hidden" id="upload_ext" value="${upload_ext}" />
<input type="hidden" id="upload_filename_100x100" value="${upload_filename_100x100}" />
<input type="hidden" id="upload_filename_400x400" value="${upload_filename_400x400}" />
<input type="hidden" id="upload_filename_original" value="${upload_filename_original}" /> --%>
<div class="button close" id="close_upload_success">Close</div>