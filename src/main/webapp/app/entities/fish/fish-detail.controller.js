(function() {
    'use strict';

    angular
        .module('marvivaApp')
        .controller('FishDetailController', FishDetailController);

    FishDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Fish'];

    function FishDetailController($scope, $rootScope, $stateParams, entity, Fish) {
        var vm = this;
        vm.fish = entity;
        vm.load = function (id) {
            Fish.get({id: id}, function(result) {
                vm.fish = result;
            });
        };
        var unsubscribe = $rootScope.$on('marvivaApp:fishUpdate', function(event, result) {
            vm.fish = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
