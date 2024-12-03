package com.example.github_activity_cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GithubActivityCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GithubActivityCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	if (args.length == 0) {
		System.out.println("Please provide a GitHub username as an argument");
		return;
	}
	String username = args[0];
	GithubService service = new GithubService();

        try {
            var events = service.fetchEvents(username);
            if(events.isEmpty()) {
                System.out.println("No events found for user " + username);
            } else {
             System.out.println(events);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
