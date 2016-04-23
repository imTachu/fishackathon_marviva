angular.module('marvivaApp')
        .controller('detailsCtrl', ['$scope', 'fish', function($scope, fish){
                $scope.fish = fish;
        }])