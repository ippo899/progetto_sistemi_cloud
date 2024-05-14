#!/bin/bash -x

mvn package -DskipTests
docker build --tag client:latest