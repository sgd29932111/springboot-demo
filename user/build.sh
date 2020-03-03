#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t user .

docker tag 20c96e5f87b7 registry.cn-shanghai.aliyuncs.com/werun/user:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/user:latest