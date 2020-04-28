#!/bin/sh
mvn clean package && docker build -t com.bmw/car2 .
docker rm -f car2 || true && docker run -d -p 8080:8080 -p 4848:4848 --name car2 com.bmw/car2 
