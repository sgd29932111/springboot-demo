#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t order .

docker tag 1e2d5636dcb1 registry.cn-shanghai.aliyuncs.com/werun/order:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/order:latest