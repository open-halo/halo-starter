# Quarkus JPA Maven Starter

## 这就是目前开发体验最好的框架
（1）REST接口兼容了jakarta注解，基本做到了代码和框架无关，同时支持生成OpenAPI文档  
（2）GRPC使用vert.x，在编译到graalvm的时候是无痛的，现在grpc-java的官方example编译到graalvm还困难  
（3）Panache配合JPA，把JPA的操作体验拉高了一个等级
（4）热更新体验很好

## 其他一些框架的痛点
（1）Spring/helidon/micronaut的热更新体验都不如quarkus
（2）Spring的rest接口要想用jakarta需要用类似resteasy的东西，文档生成又有问题
（3）我个人是喜欢MyBatis-Flex的，但是MyBatis-Flex现在和spring的耦合还太深

## Memory Footprint
|type| memory | binary size |
|--|--------|-------------|
|native| 267.5M | 120M        |

## Why it is relative bigger than we expect?
### quarkus is not very small 
* netty is big
* vert.x is big

### when use grpc, it includes many dependencies
* grpc module is big

### jackson is the biggest json library
* jackson is big

### JPA with hibernate is another big monster
* jpa with panache is big

### Hutool has so many convenient function, and it's big
* hutool is big

### This example use h2 as embedded database
* h2 is big


