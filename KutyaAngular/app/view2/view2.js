'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2/:carId', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', '$routeParams', '$http',
      function($scope, $routeParams, $http) {
        $scope.chosenCarId = $routeParams.carId;
        $http.get('jsons/packages.json').success(function(data) {
            $scope.packages = data;
            $scope.currentPackageType="street";
        });

          $scope.packageTypes=["Street","Off Road","Racing","Eco"];

          $scope.setCurrentPackageType = function(selectedString) {
              $scope.currentPackageType = selectedString;
          };


}]);