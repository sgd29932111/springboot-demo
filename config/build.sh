#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t config .

docker tag 2d498cf3fc90 registry.cn-shanghai.aliyuncs.com/werun/config:latest

docker push registry.cn-shanghai.aliyuncs.com/werun/config:latest