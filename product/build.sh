#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t product .

docker tag 32b39c8114e8 registry.cn-shanghai.aliyuncs.com/werun/product:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/product:latest