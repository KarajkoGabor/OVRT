/**
 * Created by Laci on 2015.10.15..
 */
'use strict';

angular.module('myApp.view3', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/view3/', {
            templateUrl: 'view3/view3.html',
            controller: 'View3Ctrl'
        });
    }])

    .controller('View3Ctrl', ['$scope', '$routeParams', 'ComponentsService',
        function($scope, $routeParams, ComponentsService) {
            $scope.ids=$routeParams.ids.split(',');
            $scope.componentTypes=["engine","rims","tires","exhaust"];
            $scope.components = ComponentsService.query();
            $scope.currentComponentType = "rims";

            $scope.setCurrentComponentType = function(selectedString) {
                $scope.currentComponentType = selectedString;
            };

            $scope.setComponent = function(component) {
                if (component.type==="engine"){
                    $scope.ids[1]=component.id;
                }
                if (component.type==="rims"){
                    $scope.ids[2]=component.id;
                }
                if (component.type==="tires"){
                    $scope.ids[3]=component.id;
                }
                if (component.type==="exhaust"){
                    $scope.ids[4]=component.id;
                }
            };

        }]);