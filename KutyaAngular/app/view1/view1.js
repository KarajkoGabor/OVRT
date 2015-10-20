'use strict';

angular.module('myApp.view1', ['ngRoute'])

.controller('View1Ctrl', ['$scope', '$http', 'Page',
      function($scope, $http, Page) {
          Page.setTitle('Select a car');
          Page.setCurrentStep(1);
          Page.setProgressBarClass('');
        $http.get('jsons/cars.json').success(function(data) {
          $scope.cars = data;
        });

}]);