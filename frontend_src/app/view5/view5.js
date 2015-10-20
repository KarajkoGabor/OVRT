/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view5', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/view5/', {
            templateUrl: 'view5/view5.html',
            controller: 'View5Ctrl'
        });
    }])

    .controller('View5Ctrl', ['$scope', '$routeParams', '$http',
        function($scope, $routeParams, $http) {
            $scope.ids=$routeParams.ids.split(',');
            $http.get('jsons/cars.json').success(function(data) {
                $scope.cars = data;
            });

        }]);