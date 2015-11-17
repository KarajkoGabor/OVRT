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
        //return $resource('jsons/packages.json', {}, {
        return $resource(backendURI + '/car_templates', {}, {
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
        return $resource('jsons/components.json', {}, {
            query: {method:'GET', isArray:true}
        });
    }]);