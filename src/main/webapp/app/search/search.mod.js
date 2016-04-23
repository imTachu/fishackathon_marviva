angular.module('marvivaApp')
        .config(['$stateProvider', function ($stateProvider) {
                $stateProvider.state('search', {
                    url: '/search?q',
                    templateUrl: 'app/search/search.html',
                    controller: 'searchCtrl',
                    resolve: {
                        fishes: ['Restangular', '$stateParams', function(r, params){
                                var builder = r.all('fish');
                                if(params.q){
                                    return builder.getList({q: params.q});
                                }
                                return builder.getList();
                        }]
                    }
                });
            }]);