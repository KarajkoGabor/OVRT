/**
 * Created by Laci on 2015.10.15..
 */
'use strict';

angular.module('myApp.view3', ['ngRoute'])
    .controller('View3Ctrl', ['$scope', '$routeParams', 'CarService', 'TrimLevelService', 'ComponentsService', 'CarPartUpdateService', 'Page', View3Ctrl]);

function View3Ctrl($scope, $routeParams, CarService, TrimLevelService, ComponentsService, CarPartUpdateService, Page) {
    Page.setTitle('Tuning!');
    Page.setCurrentStep(3);
    Page.setProgressBarClass('progress-bar-info');

    $scope.carId = $routeParams.carId;
    $scope.car = CarService.query($scope.carId);
    $scope.componentTypes = [];
    $scope.currentComponentType = null;

    $scope.car.$promise.then(function (response) {
        var trimLevelUUID = response.trimLevelId,
            carTemplateUUID = response.carTemplateId;
        $scope.compatibleComponents = ComponentsService.query(carTemplateUUID, trimLevelUUID);
        $scope.carTemplate = TrimLevelService.query(carTemplateUUID);

        $scope.compatibleComponents.$promise.then(function (response) {
            angular.forEach(response, function(component) {
                if (this.indexOf(component.type) === -1) {
                    this.push(component.type);
                }
                if ($scope.currentComponentType === null) {
                    $scope.currentComponentType = component.type;
                }
            }, $scope.componentTypes);
        });
    });

    $scope.getString = function(string) {
        return string.replace(Page.getLabel('carPart'), '');
    }

    $scope.getImageLink = function(link) {
        return link === null ? 'imgs/package.png' : link;
    }

    $scope.setCurrentComponentType = function(type) {
        $scope.currentComponentType = type;
    }

    $scope.setComponent = function(component, event) {
        event.preventDefault();
        event.stopPropagation();
        var carPartUUID = component.id;
        $scope.car = CarPartUpdateService.query($scope.carId, carPartUUID);
    }

    $scope.isCurrentComponent = function(component) {
        var currentComponent = null;
        angular.forEach($scope.car.parts, function(carPart) {
            if ((carPart.type === component.type) && (carPart.id === component.id)) {
                currentComponent = carPart;
            }
        });
        if (currentComponent !== null) {
            console.log(currentComponent.id == component.id ? true : false);
            return currentComponent.id == component.id ? true : false;
        } else {
            return false;
        }}

}