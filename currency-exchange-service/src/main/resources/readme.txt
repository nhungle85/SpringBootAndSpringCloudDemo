Docker command:

Create image

#Naming service
./gradlew bootBuildImage --imageName=misssg85/naming-server:0.0.1-SNAPSHOT
./gradlew bootBuildImage --imageName=misssg85/naming-server:0.0.1-SNAPSHOT

#Currency exchange
./gradlew bootBuildImage --imageName=misssg85/currency-exchange:0.0.1-SNAPSHOT
docker push docker.io/misssg85/currency-exchange:0.0.1-SNAPSHOT

#Currency conversion
./gradlew bootBuildImage --imageName=misssg85/currency-conversion:0.0.1-SNAPSHOT
docker push docker.io/misssg85/currency-conversion:0.0.1-SNAPSHOT

#Limit service
./gradlew bootBuildImage --imageName=misssg85/limits-service:0.0.1-SNAPSHOT
docker push docker.io/misssg85/limits-service:0.0.1-SNAPSHOT

#API gateway
./gradlew bootBuildImage --imageName=misssg85/api-gateway:0.0.1-SNAPSHOT
docker push docker.io/misssg85/api-gateway:0.0.1-SNAPSHOT