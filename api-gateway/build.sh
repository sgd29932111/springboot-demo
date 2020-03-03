#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t api-gateway .

docker tag 1616c85f8da6 registry.cn-shanghai.aliyuncs.com/werun/api-gateway:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/api-gateway:latest