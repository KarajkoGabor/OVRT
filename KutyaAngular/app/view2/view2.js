'use strict';

angular.module('myApp.view2', ['ngRoute'])


.controller('View2Ctrl', ['$scope', '$routeParams', '$http', 'Page',
      function($scope, $routeParams, $http, Page) {
          Page.setTitle('Select a starter package');
          Page.setCurrentStep(2);
          Page.setProgressBarClass('');
        $scope.chosenCarId = $routeParams.carId;
        $http.get('jsons/packages.json').success(function(data) {
            $scope.packages = data;
            $scope.currentPackageType="Street";
        });

          $scope.packageTypes=["Street","Off Road","Racing","Eco"];

          $scope.setCurrentPackageType = function(selectedString) {
              $scope.currentPackageType = selectedString;
          };


}]);