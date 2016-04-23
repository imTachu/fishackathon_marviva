(function() {
    'use strict';

    angular
        .module('marvivaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('fish', {
            parent: 'entity',
            url: '/fish',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'marvivaApp.fish.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/fish/fish.html',
                    controller: 'FishController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('fish');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('fish-detail', {
            parent: 'entity',
            url: '/fish/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'marvivaApp.fish.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/fish/fish-detail.html',
                    controller: 'FishDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('fish');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Fish', function($stateParams, Fish) {
                    return Fish.get({id : $stateParams.id});
                }]
            }
        })
        .state('fish.new', {
            parent: 'fish',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/fish/fish-dialog.html',
                    controller: 'FishDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                nombre_comun: null,
                                nombre_cientifico: null,
                                longitud: null,
                                peso: null,
                                imagen: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('fish', null, { reload: true });
                }, function() {
                    $state.go('fish');
                });
            }]
        })
        .state('fish.edit', {
            parent: 'fish',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/fish/fish-dialog.html',
                    controller: 'FishDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Fish', function(Fish) {
                            return Fish.get({id : $stateParams.id});
                        }]
                    }
                }).result.then(function() {
                    $state.go('fish', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('fish.delete', {
            parent: 'fish',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/fish/fish-delete-dialog.html',
                    controller: 'FishDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Fish', function(Fish) {
                            return Fish.get({id : $stateParams.id});
                        }]
                    }
                }).result.then(function() {
                    $state.go('fish', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
