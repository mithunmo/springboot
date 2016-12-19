<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <html>
 <head>
	 <link rel="stylesheet" href="<c:url value="/resources/js/jquery/uploadify/uploadify.css"/>" type="text/css" media="all" />
	 <!-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/uploadify/uploadify.css"/>" media="all" /> -->
	
	 <script src= "<c:url value="/resources/js/jquery/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
	 <!-- <script type="text/javascript" src= "<c:url value="/resources/uploadify/swfobject.js"/>"></script> -->
	 <script type="text/javascript" src= "<c:url value="/resources/js/jquery/uploadify/jquery.uploadify-3.1.min.js"/>"></script>
	 <script type="text/javascript">
	 var appPath="/webapp-1.0.0-BUILD-SNAPSHOT/";
		 $(document).ready(function() 
		 {
			 $('#upload').click(function() 
		 	 {
				 $('#uploadify').uploadify('upload');
			 });
				 $('#uploadify').uploadify(
				 {
				 	'swf': appPath+'/resources/js/jquery/uploadify/uploadify.swf',
				 	'uploader': appPath+'/uploadPictures?jsessionid=${sessionId}',
				 	'multi': false,
				 	'auto' : true,
				 	'fileDesc': 'AI Files',
				 	'fileExt' : '*.ai',
				 	'cancelImg': appPath+'/resources/js/jquery/uploadify/cancel.png',
				 	'onUploadComplete' : function(file) 
				 	{
			            alert('The file ' + file.name + ' finished processing.');
			        },
			        'onUploadSuccess' : function(file, data, response) 
			        {
			            alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
			        }
				 });
		 });
 </script>

 </head>
 <body>
 
 	

	<div>
		
		<h3>Upload jpeg images for your profile picture and content.</h3>
		
		<div>	
			<p>Click on the select files button to upload <B>(.jpeg, .jpg)</B></p>
			<p>Close this window once you have finished uploading your pictures.</p>
		</div>
		<p>${UploadResult}</p>
	
		<input id="uploadify" type="file">
 		<form:form modelAttribute="uploadbean" method="post" enctype="multipart/form-data">
 		</form:form>

 	</div>
 	<div id="upload">Upload</div>
 
 </body>
 </html>