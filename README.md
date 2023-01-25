# SpringBootAndSpringCloudDemo
Spring Boot, Spring Cloud (config, eureka, openfeign, loadbalance (through eureka and feign), api gateway), Docker, Kubernetes and REST API (REST Web Services)

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
API: http://localhost:8000/currency-exchange/findAll
API: http://localhost:8000/currency-exchange/create
API: http://localhost:8000/currency-exchange/update
API: http://localhost:8000/currency-exchange/delete/{id}

#4. Currency conversion service
port: 8100
http://localhost:8100/currency-conversion/exchange-by-feign/{from}/to/{to}/{amount}

#5. Eureka naming service
localhost:8761

#6. Api Gateway
localhost:8765

