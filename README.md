# SpringBootAndSpringCloudDemo
Spring Boot, Spring Cloud, Docker, Kubernetes and REST API (REST Web Services)

# Projects:
#1. Limits Service
++ Start service: /gradlew bootRun
++ API: http://localhost:8080/limits

#2. Spring-boot-config-server
port=8888
Load config from local git repo
++ Start service: /gradlew bootRun
++ Tests: 
Access limits service config: 
http://localhost:8888/limits-service/default
http://localhost:8888/currency-exchange/default

#3. Currency exchange service 
port: 8000 (spring-cloud-config), 8001 (default)

API: http://localhost:8000/currency-exchange/{from}/to/{to}
