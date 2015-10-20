/**
 * Created by Laci on 2015.10.15..
 */
'use strict';

angular.module('myApp.view3', ['ngRoute'])


    .controller('View3Ctrl', ['$scope', '$routeParams', '$http', 'Page',
        function($scope, $routeParams, $http, Page) {
            Page.setTitle('Tuning!');
            Page.setCurrentStep(3);
            Page.setProgressBarClass('progress-bar-info');
            $scope.ids=$routeParams.ids.split(',');
            $scope.componentTypes=["engine","rims","tires","exhaust"];

            $http.get('jsons/components.json').success(function(data) {
                $scope.components = data;
                $scope.currentComponentType = "rims";
            });

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