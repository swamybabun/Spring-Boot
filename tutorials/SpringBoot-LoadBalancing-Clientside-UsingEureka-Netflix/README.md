# SpringBoot-LoadBalancing-Clientside-UsingEureka-Netflix
 Spring Boot Client Side Load Balancing using Spring Cloud Ribbon as Load Balancer and Eureka as Registry Service
 
Reference:  

https://howtodoinjava.com/spring-cloud/spring-boot-ribbon-eureka/

Testing:

Eureka first, then the back-end micro service(eureka-server) and finally the frontend micro service (eureka-client).

http://localhost:8761/ in browser and check that eureka server is running with all microservices are registed with desired number of instances.

In the frontend microservice, we are calling the backend microservice using RestTemplate. Rest tempate is enabled as client side load balancer using @LoadBalanced annotation.