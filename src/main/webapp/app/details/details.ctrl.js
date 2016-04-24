angular.module('marvivaApp')
        .controller('detailsCtrl', ['$scope', 'fish', '$state', function($scope, fish, $state){
                $scope.fish = fish;
                $scope.search = function(q){
                    $state.go('search', {q: q});
                };
        }]);