/**
 * Created by balas on 27/07/15.
 */

var catModule = angular.module('categoryModule', []);

catModule.controller('categoryController', function($scope, $http, $state){
    $scope.categories = [];
    $scope.message = '';

    var listCategories= function() {
        $http.get('/GADemo/categories')
            .success(function(data, status, headers, config){
                $scope.categories = data;

            }).error(function(data, status, headers, config){
                switch(status) {
                    case 400 : {
                        $scope.message = "Some error occured";
                    }
                    case 500 : {
                        $scope.message = "Internal error occured";
                        break;
                    }
                }
                console.log(status);
            });
    };

    listCategories();

    $scope.deleteCategory = function (catid) {
        console.log(catid);
        $http.delete('/GADemo/category/' + catid)
            .success(function (data, status, headers, config) {
                $scope.message = data.message;
                listCategories();
            }).error(function(data, status, headers, config){
            $scope.message = data.message;
        });
    };

    $scope.createCategory = function() {
        $state.go('home.newcat');
    };

    $scope.editCategory = function(catid) {
        console.log(catid);
        $state.go('home.editcat', {"catid": catid});
    };

});

app.controller('saveCategoryController', function($scope, $http, $state){
    $scope.category = {};
    $scope.message = '';

    $scope.saveCategory = function(category) {
        $http.post('/GADemo/category', category)
            .success(function(data, status, headers, config){
                $state.go('home.categories');
            }).error(function(data, status, headers, config){
                $scope.message = data.message;
            });
    };

});

app.controller('editCategoryController', function($scope, $http, $state, $stateParams){
    var catid = $stateParams.catid;
    console.log(catid);
    $http.get('/GADemo/category/' + catid)
        .success(function(data, status, headers, config){
            $scope.editcat = data;
            $scope.message = data.message;

        }).error(function(data, status, headers, config){
            $scope.message = data.message;
        });

    $scope.updateCategory = function(category) {
        $http.put('/GADemo/category/' + category.id, category)
            .success(function(data, status, headers, config){
                $state.go('home.categories');
            }).error(function(data, status, headers, config){
                $scope.message = data.message;
            });
    };

});

app.controller('showCategoryController', function($scope, $http, $state, $stateParams){
    var catid = $stateParams.catid;
    console.log(catid);
    $http.get('/GADemo/category/' + catid)
        .success(function(data, status, headers, config){
            $scope.cat = data;
            $scope.message = data.message;

        }).error(function(data, status, headers, config){
            $scope.message = data.message;
        });

});