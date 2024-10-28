## spring优化
1. 我们希望使用jakarta的标准注解，需要引入resteasy
2. 我们希望使用undertow，追求更高的性能，而不是默认的tomcat
3. 我们希望使用log4j2，而不是默认的logback

为此我们需要做如下配置：
```xml
<!-- begin of jakarta spring servlet -->
        <dependency>
            <groupId>org.jboss.resteasy</groupId>
            <artifactId>resteasy-servlet-spring-boot-starter</artifactId>
            <version>6.2.0.Final</version>
            <scope>runtime</scope>
            <!-- we don't want spring with tomcat and logback by default -->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- we need undertow instead of tomcat -->
        <!-- we need log4j2   instead of logback -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        <!-- end of jakarta spring servlet -->
```
 