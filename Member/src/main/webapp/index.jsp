
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.2.3/foundation.css"
	rel="stylesheet" />
</head>
<body ng-app="myApp" ng-controller="myController">
	<h1>Members are:</h1>
	<button ng-click="loadData()">Load Data</button>
	<table>
		<tr>
			<th>Name</th>
			<th>Salary</th>
		</tr>

		<tr ng-repeat="member in members | orderBy:'name'">
			<td>{{member.name}}</td>
			<td>{{member.salary}}</td>
		</tr>

	</table>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js
"></script>
	<script>
		var app = angular.module('myApp', []);

		app.controller('myController', function($scope, $http) {
			$scope.loadData = function() {
				$http({
					url : 'rest/findAll',
					method : 'GET'
				}).success(function(data) {
					console.log('Recieved something from the server')
					console.log(data);
					$scope.members = data;
				})
			}
		})
	</script>
</body>
</html>