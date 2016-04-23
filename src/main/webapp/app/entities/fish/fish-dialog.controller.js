(function() {
    'use strict';

    angular
        .module('marvivaApp')
        .controller('FishDialogController', FishDialogController);

    FishDialogController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Fish'];

    function FishDialogController ($scope, $stateParams, $uibModalInstance, entity, Fish) {
        var vm = this;
        vm.fish = entity;
        vm.load = function(id) {
            Fish.get({id : id}, function(result) {
                vm.fish = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('marvivaApp:fishUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        };

        var onSaveError = function () {
            vm.isSaving = false;
        };

        vm.save = function () {
            vm.isSaving = true;
            if (vm.fish.id !== null) {
                Fish.update(vm.fish, onSaveSuccess, onSaveError);
            } else {
                Fish.save(vm.fish, onSaveSuccess, onSaveError);
            }
        };

        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
