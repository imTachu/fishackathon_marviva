(function() {
    'use strict';

    angular
        .module('marvivaApp')
        .controller('FishController', FishController);

    FishController.$inject = ['$scope', '$state', 'Fish'];

    function FishController ($scope, $state, Fish) {
        var vm = this;
        vm.fish = [];
        vm.loadAll = function() {
            Fish.query(function(result) {
                vm.fish = result;
            });
        };

        vm.loadAll();
        
    }
})();
