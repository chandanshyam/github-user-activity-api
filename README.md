# GitHub Activity CLI

A command-line interface (CLI) application built with Spring Boot to fetch and display recent public activity of a GitHub user. The application uses the GitHub API to retrieve user activity and displays it directly in the terminal.

## Features

- Fetch recent public activity for a given GitHub username.
- Display activity directly in the terminal.
- Handles invalid usernames and empty activity gracefully.
- Built using Java 17, Spring Boot, OkHttp, and Jackson.

## Prerequisites

- **Java 17** or later installed.
- **Gradle** installed (or use the Gradle wrapper included in the project).
- An active internet connection (to call the GitHub API).

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-repo/github-activity-cli.git
cd github-activity-cli
```

### 2. Build the Application

```bash
./gradlew build
```

### 3. Run the Application

```bash
java -jar build/libs/github-activity-cli-1.0-SNAPSHOT.jar <GitHub-username>
```

### 4. Project URL

* https://roadmap.sh/projects/github-user-activity

