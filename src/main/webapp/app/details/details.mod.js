angular.module('marvivaApp')
        .config(['$stateProvider', function ($stateProvider) {
                $stateProvider.state('details', {
                    url: '/details/{id:int}',
                    templateUrl: 'app/details/details.html',
                    controller: 'detailsCtrl',
                    resolve: {
                        fish: ['Restangular', '$stateParams', function(r, params){
                                return r.one('fish', params.id).get();
                        }]
                    }
                });
            }]);