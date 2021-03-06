'use strict';

// Declare app level module which depends on views, and components
var app = angular.module('myApp', [
  'kutyaServices',
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.view3',
  'myApp.view4',
  'myApp.view5',
  'myApp.version',
  'ui.bootstrap'
]);

app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
  $routeProvider.
      when('/view1', {templateUrl: 'view1/view1.html', controller: 'View1Ctrl' }).
      when('/view2', {templateUrl: 'view2/view2.html', controller: 'View2Ctrl' }).
      when('/view3', {templateUrl: 'view3/view3.html', controller: 'View3Ctrl' }).
      when('/view4', {templateUrl: 'view4/view4.html', controller: 'View4Ctrl' }).
      when('/view5', {templateUrl: 'view5/view5.html', controller: 'View5Ctrl' }).
      otherwise({redirectTo: '/view1'});
  $locationProvider.html5Mode(false);
}]);

app.factory('Page', function(){
  var title = 'default',
      currentStep = 0,
      numberOfSteps = 5,
      progressBarClass = '',
      labels = {
          'carPart' : 'hu.kutya.car.domain.'
      };
  return {
      title: function() { return title; },
      currentStep: function() { return currentStep; },
      setTitle: function(newTitle) { title = newTitle;},
      setCurrentStep: function(step) { currentStep = step; },
      numberOfSteps: function() { return numberOfSteps; },
      progressBarClass: function() { return progressBarClass;},
      setProgressBarClass: function(pClass) { progressBarClass = pClass; },
      getLabel: function(label) { return labels[label]; }
  };
});

app.controller('mainController', ['$scope', 'Page',
  function($scope, Page) {
      $scope.Page = Page;
  }]
);