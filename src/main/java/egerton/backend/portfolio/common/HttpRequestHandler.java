package egerton.backend.portfolio.common;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestHandler {

    private HttpRequestHandler() {
        throw new IllegalStateException("HttpRequest Handler Utility class");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestHandler.class);

    public static String sendGetRequestUSAJobs(String url, String userAgent, String authorizationKey) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", userAgent)
                .header("Authorization-Key", authorizationKey)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info(String.format("HttpResponse successful"));
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info( "Interrupted!", e);
            return "USAJobs API Service Not Available."; 
        }
    }

    public static String sendGetRequestWeather(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info(String.format("HttpResponse successful"));
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info( "Interrupted!", e);
            return "Weather API Service Not Available."; 
        }
    }
}