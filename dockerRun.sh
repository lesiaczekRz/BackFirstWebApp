#!/bin/bash

docker run --name BackFirstWebApp --network network-postgres -p 8080:8080 \
  -v /home/lesiaczek/DockerVolume:/mnt/DockerVolume \
  springio/gs-spring-boot-docker
