package com.example.github_activity_cli;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GithubService {
    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String GITHUB_EVENTS_PATH = "/users/%s/events";
    private static final String GITHUB_EVENTS_URL = GITHUB_API_URL + GITHUB_EVENTS_PATH;

    public String fetchEvents(String username) throws IOException {
        String url = String.format(GITHUB_EVENTS_URL, username);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(var response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON response into a List
            List<Map<String, Object>> activities =
                    objectMapper.readValue(response.body().string(), new TypeReference<>() {});

            // Pretty print the JSON response
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            return  writer.writeValueAsString(activities);
        }
    }
}