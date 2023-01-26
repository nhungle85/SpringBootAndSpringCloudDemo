Docker command:

Create image
./gradlew bootBuildImage --imageName=misssg85/currency-exchange:0.0.1-SNAPSHOT

Push to repository
docker push docker.io/misssg85/currency-exchange:0.0.1-SNAPSHOT
