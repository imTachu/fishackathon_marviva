angular.module('marvivaApp')
        .config(['$stateProvider', function ($stateProvider) {
                $stateProvider.state('search', {
                    url: '/search?q',
                    templateUrl: 'app/search/search.html',
                    controller: 'searchCtrl',
                    resolve: {
                        fishes: ['Restangular', '$stateParams', function (r, params) {
                                return [{
                                        id: 1,
                                        nombreComun: 'Pargo',
                                        nombreCientifico: 'Iltonus arrogantus'
                                    }, {
                                        id: 2,
                                        nombreComun: 'Oso',
                                        nombreCientifico: 'Fish Fisher'
                                    }, {
                                        id: 2,
                                        nombreComun: 'Oso',
                                        nombreCientifico: 'Fish Fisher'
                                    }, {
                                        id: 2,
                                        nombreComun: 'Oso',
                                        nombreCientifico: 'Fish Fisher'
                                    }]
                                var builder = r.all('fish');
                                if (params.q) {
                                    return builder.getList({q: params.q});
                                }
                                return builder.getList();
                            }]
                    }
                });
            }]);