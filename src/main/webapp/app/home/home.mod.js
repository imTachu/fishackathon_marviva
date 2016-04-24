angular.module('marvivaApp')
        .config(['$stateProvider', function ($stateProvider) {
                $stateProvider.state('home', {
                    url: '/home',
                    templateUrl: 'app/home/home.html',
                    controller: 'homeCtrl'
                }).state(
                    'tips', {
                        url: '/tips',
                        templateUrl: 'app/home/tips.html'
                    }

                );
            }]);
