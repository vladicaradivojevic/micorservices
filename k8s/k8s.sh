#!/bin/bash
source ~/.bashrc
if [[ "$1" == "-b" ]]; then
  mvn clean package -DskipTests=true -f ./common-lib
  mvn clean package -DskipTests=true -f ./user-microservice
  mvn clean package -DskipTests=true -f ./cinema-microservice
  mvn clean package -DskipTests=true -f ./movie-microservice
  mvn clean package -DskipTests=true -f ./cinema-gateway
fi

docker build -t user-service ./user-microservice
docker build -t cinema-service ./cinema-microservice
docker build -t movie-service ./movie-microservice
docker build -t cinema-gateway ./cinema-gateway

kubectl delete service user-service
kubectl delete service cinema-service
kubectl delete service movie-service
kubectl delete service cinema-gateway
kubectl delete deployment user-service
kubectl delete deployment cinema-service
kubectl delete deployment movie-service
kubectl delete deployment cinema-gateway
kubectl apply -f cinema-service-k8s.yaml
kubectl apply -f user-service-k8s.yaml
kubectl apply -f movie-service-k8s.yaml
kubectl apply -f cinema-gateway-k8s.yaml
docker image prune -f
docker image ls
docker ps 
