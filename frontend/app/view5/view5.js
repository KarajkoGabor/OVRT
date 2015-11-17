/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view5', ['ngRoute'])
    .controller('View5Ctrl', ['$scope', '$routeParams', 'CarsService', 'Page',
        function($scope, $routeParams, CarsService, Page) {
            Page.setTitle('Happiness!');
            Page.setCurrentStep(5);
            Page.setProgressBarClass('progress-bar-success');

            $scope.ids=$routeParams.ids.split(',');
            $scope.cars = CarsService.query();
        }]);