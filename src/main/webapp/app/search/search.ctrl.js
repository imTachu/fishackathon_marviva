angular.module('marvivaApp')
        .controller('searchCtrl', ['$scope', 'fishes', function($scope, fishes){
                $scope.fishes = fishes;
        }])