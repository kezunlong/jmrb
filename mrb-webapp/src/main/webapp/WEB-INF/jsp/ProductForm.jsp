<title>Add Product Form</title>
<content tag="heading">
<h1>
	Input Product <small> <i
		class="ace-icon fa fa-angle-double-right"></i> input product information
	</small>
</h1>
</content>
<body>
	<div>
		Current Locale : ${pageContext.response.locale}
		<br/>
		accept-language header: ${header["accept-language"]}
	</div>
	<spring:message code="application.name"/>
	
	<form action="save-product" method="post">
		<fieldset>
			<legend>Add a product</legend>
			<p>
				<label for="name">Product Name: </label> <input type="text"
					id="name" name="name" tabindex="1">
			</p>
			<p>
				<label for="description">Description: </label> <input type="text"
					id="description" name="description" tabindex="2">
			</p>
			<p>
				<label for="price">Price: </label> <input type="text" id="price"
					name="price" tabindex="3">
			</p>
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4"> <input
					id="submit" type="submit" tabindex="5" value="Add Product">
			</p>
		</fieldset>
	</form>
</body>