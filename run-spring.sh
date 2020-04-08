#!/bin/bash

java -jar /home/mary/projetcs/springBootServices/configServer/target/*.jar &

java -jar /home/mary/projetcs/springBootServices/eurekaServer/target/*.jar &

java -jar /home/mary/projetcs/springBootServices/myRestRepoMySql/target/*.jar &

java -jar /home/mary/projetcs/springBootServices/myMvcMongo/target/*.jar &

java -jar /home/mary/projetcs/springBootServices/myKafla/target/*.jar &

java -jar /home/mary/projetcs/springBootServices/zuulGateWay/target/*.jar &
