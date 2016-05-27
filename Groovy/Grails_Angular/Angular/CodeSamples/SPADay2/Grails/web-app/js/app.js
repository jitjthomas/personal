/**
 * Created by balas on 27/07/15.
 */
var app = angular.module('grapp', ['ui.router', 'categoryModule']);

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/login');
    $urlRouterProvider.when('/home', '/home/default');

    $stateProvider
        .state('login', {
            url : '/login',
            templateUrl: 'pages/login-tpl.html',
            controller : 'loginController'
        })
        .state('home', {
            url : '/home',
            templateUrl : 'pages/home-tpl.html'
        })
        .state('home.default', {
            url : '/default',
            templateUrl : 'pages/defhome-tpl.html'
        })
        .state('home.categories', {
            url : '/categories',
            templateUrl : 'pages/category/catlist-tpl.html',
            controller : 'categoryController'
        })
        .state('home.newcat', {
            url : '/newcat',
            templateUrl : 'pages/category/catnew-tpl.html',
            controller : 'saveCategoryController'
        })
        .state('home.editcat', {
            url : '/editcat',
            templateUrl : 'pages/category/catedit-tpl.html',
            params : {"catid" :0},
            controller : 'editCategoryController'
        })
        .state('home.showcat', {
            url : '/showcat',
            templateUrl : 'pages/category/catshow-tpl.html',
            params : {"catid" :0},
            controller : 'showCategoryController'
        });
});

app.controller('loginController', function($scope, $state){
    $scope.loginClicked = function() {
        //check login credentials here...
        $state.go('home');
    }
});

