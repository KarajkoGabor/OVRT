/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view5', ['ngRoute'])
    .controller('View5Ctrl', ['$scope', '$routeParams', '$http', 'Page',
        function($scope, $routeParams, $http, Page) {
            Page.setTitle('Happiness!');
            Page.setCurrentStep(5);
            Page.setProgressBarClass('progress-bar-success');
            $scope.ids=$routeParams.ids.split(',');
            $http.get('jsons/cars.json').success(function(data) {
                $scope.cars = data;
            });

        }]);