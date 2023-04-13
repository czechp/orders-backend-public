FROM openjdk:17-alpine
RUN apk update
RUN apk add tzdata
ENV TZ="Europe/Warsaw"
WORKDIR /BackendOrdersApp
COPY orders-backend.jar .
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/BackendOrdersApp/orders-backend.jar"]
