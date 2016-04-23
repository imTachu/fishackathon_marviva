package co.com.fishackathon.marviva.web.rest.util;

import org.springframework.http.HttpHeaders;

/**
 * Utility class for HTTP headers creation.
 *
 */
public class HeaderUtil {

    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-marvivaApp-alert", message);
        headers.add("X-marvivaApp-params", param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return createAlert("marvivaApp." + entityName + ".created", param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert("marvivaApp." + entityName + ".updated", param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert("marvivaApp." + entityName + ".deleted", param);
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-marvivaApp-error", "error." + errorKey);
        headers.add("X-marvivaApp-params", entityName);
        return headers;
    }
}
