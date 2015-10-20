'use strict';

angular.module('myApp.view2', ['ngRoute'])

.controller('View2Ctrl', ['$scope', '$routeParams', 'PackagesService', 'Page',
      function($scope, $routeParams, PackagesService, Page) {
        Page.setTitle('Select a starter package');
        Page.setCurrentStep(2);
        Page.setProgressBarClass('');

        $scope.chosenCarId = $routeParams.carId;
        $scope.packages = PackagesService.query();
        $scope.currentPackageType="Street";
        $scope.packageTypes=["Street","Off Road","Racing","Eco"];

        $scope.setCurrentPackageType = function(selectedString) {
            $scope.currentPackageType = selectedString;
        };
}]);