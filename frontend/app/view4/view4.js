/**
 * Created by DLaci on 2015.10.19..
 */
'use strict';

angular.module('myApp.view4', ['ngRoute'])

    .controller('View4Ctrl', ['$scope', '$routeParams', 'CarService', 'ComponentsService', 'TrimLevelService' , 'Page',
        function($scope, $routeParams, CarService, ComponentsService, TrimLevelService,  Page) {
            Page.setTitle('Pay the ride');
            Page.setCurrentStep(4);
            Page.setProgressBarClass('progress-bar-warning');

            $scope.carId = $routeParams.carId;
            $scope.car = CarService.query($scope.carId);


            $scope.car.$promise.then(function (response) {
                //var carTemplateId = response.carTemplateId;
                $scope.carTemplate = TrimLevelService.query($scope.car.carTemplateId);
                $scope.totalSum = 0;
                for(var i=0; i<$scope.car.parts.length; i++){
                    $scope.totalSum = $scope.totalSum + $scope.car.parts[i].price
                }
            });

        }]);
