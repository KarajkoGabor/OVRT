/**
 * Created by Laci on 2015.10.15..
 */
'use strict';

angular.module('myApp.view3', ['ngRoute'])
    .controller('View3Ctrl', ['$scope', '$routeParams', 'CarService', 'ComponentsService', 'Page', View3Ctrl]);

function View3Ctrl($scope, $routeParams, CarService, ComponentsService, Page) {
    Page.setTitle('Tuning!');
    Page.setCurrentStep(3);
    Page.setProgressBarClass('progress-bar-info');

    $scope.carId = $routeParams.carId;
    $scope.car = CarService.query($scope.carId);

    $scope.car.$promise.then(function (response) {
        var trimlevelUUID = response.trimLevelId;
        $scope.compatibleComponents = ComponentsService.query($scope.carId, trimlevelUUID);
    });

    $scope.getString = function(string) {
        return string.replace(Page.getLabel('carPart'), '');
    }

    $scope.getImageLink = function(link) {
        return link === null ? 'imgs/package.png' : link;
    }
}