'use strict';

angular.module('myApp.view2', ['ngRoute'])

.controller('View2Ctrl', ['$scope', '$routeParams', 'PackagesService', 'TrimLevelService', 'Page',
      function($scope, $routeParams, PackagesService, TrimLevelService, Page) {
        Page.setTitle('Select a starter package');
        Page.setCurrentStep(2);
        Page.setProgressBarClass('');

        $scope.chosenCarId = $routeParams.carId;
        $scope.car = TrimLevelService.query($scope.chosenCarId);

}]);