angular.module('marvivaApp')
        .controller('homeCtrl', ['$scope', '$state', function($scope, $state){
                $scope.search = function(q){
                    $state.go('search', {q: q});
                }
        }])