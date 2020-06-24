#!/bin/bash

docker run --name springboot-mariadb \
-e MYSQL_ROOT_PASSWORD=my-secret-pw \
-e MYSQL_DATABASE=PERSONS \
-e MYSQL_USER=spring \
-e MYSQL_PASSWORD=spring \
-p 3306:3306 \
mariadb