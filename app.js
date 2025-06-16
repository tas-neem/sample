var app = angular.module('userApp', []);

app.controller('UserController', ['$scope', function($scope) {
    $scope.user = {
        name: '',
        age: null,
        email: ''
    };

    $scope.message = '';

    $scope.register = function(user) {
        if ($scope.userForm.$valid) {
            $scope.message = user.name + " registered.";
        } else {
            $scope.message = '';
        }
    };
}]);
