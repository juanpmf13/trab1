@echo off
call mvn clean package
call docker build -t com.mycompany/persistenc .
call docker rm -f persistenc
call docker run -d -p 9080:9080 -p 9443:9443 --name persistenc com.mycompany/persistenc