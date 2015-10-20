'use strict';

angular.module('myApp.view1', ['ngRoute'])

.controller('View1Ctrl', ['$scope', 'CarsService', 'Page',
      function($scope, CarsService, Page) {
          Page.setTitle('Select a car');
          Page.setCurrentStep(1);
          Page.setProgressBarClass('');
          $scope.cars = CarsService.query();
}]);