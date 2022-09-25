
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/style1.css">
<meta charset="ISO-8859-1">
<style>
	body{
		background-color:rgb(130, 178, 219);
	}
</style>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="amb">
	<div class="container" style="width: 30%; margin-top: 50px;">
		<h2 style="text-align: center">Upload File</h2>
		<form action="importusers" method="post" enctype="multipart/form-data"
			id="importusers">
			<div class="form-group">
				<input type="file" class="form-control-file border" name="file"
					id="file" style="border: 5px">
			</div>
			<div style="text-align: center; margin-top: 30px;">
				<button type="submit" class="btn btn-primary">Upload</button>
			</div>
		</form>
	</div></div>
</body>
</html>