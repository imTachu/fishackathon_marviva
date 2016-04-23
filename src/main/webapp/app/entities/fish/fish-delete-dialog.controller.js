(function() {
    'use strict';

    angular
        .module('marvivaApp')
        .controller('FishDeleteController',FishDeleteController);

    FishDeleteController.$inject = ['$uibModalInstance', 'entity', 'Fish'];

    function FishDeleteController($uibModalInstance, entity, Fish) {
        var vm = this;
        vm.fish = entity;
        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        vm.confirmDelete = function (id) {
            Fish.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };
    }
})();
