'use strict';

angular.module('myApp.view2', ['ngRoute'])
  .controller('View2Ctrl', ['$scope', '$location', '$routeParams', 'TrimLevelService', 'CarBuilderService', 'Page', View2Ctrl]);

function View2Ctrl($scope, $location, $routeParams, TrimLevelService, CarBuilderService, Page) {
  Page.setTitle('Select a starter package');
  Page.setCurrentStep(2);
  Page.setProgressBarClass('');

  $scope.chosenCarUUID = $routeParams.carTemplateId;
  $scope.car = TrimLevelService.query($scope.chosenCarUUID);

  $scope.buildCar = function(packageUUID) {
    CarBuilderService.query($scope.chosenCarUUID, packageUUID).$promise.then(function(response) {
      var carId = response.carId;
      if (carId !== undefined) {
        $location.path('/view3').search({carId: carId});
      } else {
        alert('Error.')
      }
    });
  }
}
