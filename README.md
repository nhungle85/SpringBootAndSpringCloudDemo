# SpringBootAndSpringCloudDemo
Spring Boot, Spring Cloud, Docker, Kubernetes and REST API (REST Web Services)
Projects:
#1. Limits Service
++ Start service: /gradlew bootRun
++ Access api: http://localhost:8080/limits

#2. Spring-boot-config-server
port=8888
Load config from local git repo
++ Start service: /gradlew bootRun
++ Tests: 
Access limits service config: http://localhost:8888/limits-service/default
