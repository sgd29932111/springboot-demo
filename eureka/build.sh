#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t eureka .

docker tag 8e7136ee3477 registry.cn-shanghai.aliyuncs.com/werun/eureka:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/eureka:latest