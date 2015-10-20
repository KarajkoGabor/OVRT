/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view4', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/view4/', {
            templateUrl: 'view4/view4.html',
            controller: 'View4Ctrl'
        });
    }])

    .controller('View4Ctrl', ['$scope', '$routeParams', '$http',
        function($scope, $routeParams, $http) {
            $scope.ids=$routeParams.ids.split(',');
            $scope.componentTypes=["engine","rims","tires","exhaust"];

            $http.get('jsons/components.json').success(function(data) {
                $scope.components = data;
            });


        }]);