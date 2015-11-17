/**
 * Created by Laci on 2015.10.20..
 */
var kutyaServices = angular.module('kutyaServices', ['ngResource']),
    backendURI = 'http://localhost:8080';

kutyaServices.factory('CarsService', ['$resource',
    function($resource){
        return $resource(backendURI + '/car_templates', {}, {
            query: {method:'GET', isArray:true}
        });
    }]);

kutyaServices.factory('PackagesService', ['$resource',
    function($resource){
        return $resource('jsons/packages.json', {}, {
            query: {method:'GET', params:{carId:'defCarId'}, isArray:true}
        });
    }]);

kutyaServices.factory('TrimLevelService', ['$resource',
    function($resource){
        return {
            query: function(carUUID) {
                return $resource(backendURI + '/car_templates/' + carUUID, {}, {
                    query: {method:'GET', isArray:false}
                }).query();
            }
        }
    }]);

kutyaServices.factory('ComponentsService', ['$resource',
    function($resource){
        return {
            query: function(carUUID, trimLevelUUID) {
                return $resource(backendURI + '/car_templates/' + carUUID + '/trim_levels/' + trimLevelUUID + '/compatible_parts', [], {
                    query: {method:'GET', isArray:false}
                }).query();
            }
        }
    }]);

kutyaServices.factory('CarBuilderService', ['$resource',
    function($resource){
        return {
            query: function(carTemplateUUID, trimLevelUUID) {
                return $resource(backendURI + '/car_templates/' + carTemplateUUID + '/trim_levels/' + trimLevelUUID + '/build', [], {
                    query: {method:'POST', isArray:false}
                }).query();
            }
        }
    }]);

kutyaServices.factory('CarService', ['$resource',
    function($resource){
        return {
            query: function(carUUID) {
                return $resource(backendURI + '/cars/' + carUUID, [], {
                    query: {method:'GET', isArray:false}
                }).query();
            }
        }
    }]);