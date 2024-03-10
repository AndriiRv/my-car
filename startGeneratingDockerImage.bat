echo off
cls

set tagValue=s1

call generateDockerImages.bat cars Cars
call generateDockerImages.bat customers Customers
call generateDockerImages.bat servicepartners ServicePartners
call generateDockerImages.bat configserver "Spring Cloud Config server"
call generateDockerImages.bat eurekaserver "Spring Cloud Eureka server"
call generateDockerImages.bat gatewayserver "Spring Cloud Gateway server"

PAUSE
