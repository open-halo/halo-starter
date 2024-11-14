# Quarkus JPA Maven Starter

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


