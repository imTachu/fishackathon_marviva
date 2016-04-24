angular.module('marvivaApp')
        .controller('detailsCtrl', ['$scope', 'fish', '$state', function ($scope, fish, $state) {
                $scope.fish = fish;
                $scope.conservationClass = fish.estadoConservacion === 'SIN_RIESGO' ? 'na' : fish.estadoConservacion.toLowerCase();
                $scope.search = function (q) {
                    $state.go('search', {q: q});
                };
            }]);