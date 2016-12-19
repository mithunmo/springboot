<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Image Viewer</title>
		<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js"></script>
		<style>
			.fit { max-width: 100%; max-height: 100%;}
			img { cursor:crosshair;}
		</style>
		<script type="text/javascript">
		$(document).ready(function() {
			$("img").click(function() {
				$(this).toggleClass("fit");
			});
		});
		</script>
	</head>
<body>
	<img class="fit" src="${imageUrl}" />
</body>
</html>