(function() {
    'use strict';

    angular
        .module('marvivaApp', [
            'ngStorage', 
            'tmh.dynamicLocale',
            'pascalprecht.translate', 
            'ngResource',
            'ngCookies',
            'ngAria',
            'ngCacheBuster',
            'ngFileUpload',
            'ui.bootstrap',
            'ui.bootstrap.datetimepicker',
            'ui.router',
            'infinite-scroll',
            // jhipster-needle-angularjs-add-module JHipster will add new module here
            'angular-loading-bar',
            'restangular'
        ]).config(['RestangularProvider', function(rp){
                rp.setBaseUrl('api');
        }]).run(['$state', function($state){
            $state.go('home');
        }]);
})();
