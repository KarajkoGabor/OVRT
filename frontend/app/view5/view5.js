/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view5', ['ngRoute'])
    .controller('View5Ctrl', ['$scope', '$routeParams', 'CarService', 'TrimLevelService' , 'Page',
        function($scope, $routeParams, CarService, TrimLevelService, Page) {
            Page.setTitle('Happiness!');
            Page.setCurrentStep(5);
            Page.setProgressBarClass('progress-bar-success');

            $scope.carId = $routeParams.carId;
            $scope.car = CarService.query($scope.carId);


            $scope.car.$promise.then(function (response) {
                $scope.carTemplate = TrimLevelService.query($scope.car.carTemplateId);
            });

        }]);