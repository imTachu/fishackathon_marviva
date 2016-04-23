(function() {
    'use strict';
    angular
        .module('marvivaApp')
        .factory('Fish', Fish);

    Fish.$inject = ['$resource'];

    function Fish ($resource) {
        var resourceUrl =  'api/fish/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
