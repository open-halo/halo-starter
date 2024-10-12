# Halo
![alt text](.docs/flagship.png)
Halo is the flagship of the interstellar fleet in the Remembrance of Earth's Past trilogy.

# multi-lingual docs
[中文](README-zh.md)

## what is on board of this \[template\] \[boilerplate\]？
1. Provide a base project to quickly start a Spring Boot/Helidon/Quarkus/Micronaut project.
This involves setting up a foundational template that developers can use to bootstrap a new project with one of the mentioned frameworks, ensuring a consistent and efficient starting point.
2. A well-structured and battle-tested project module and package interface that adheres to DDD (Domain-Driven Design) best practices.
The project structure should be organized in a way that aligns with DDD principles, making it easier to manage and scale the application. This includes clear separation of concerns, domain models, and service layers.
3. Provide basic naming conventions and guidelines to reduce potential communication ambiguities.
Establishing a set of naming conventions for classes, methods, variables, and packages helps ensure consistency and clarity across the codebase, reducing misunderstandings and improving maintainability.
4. Offer a variety of tools to enhance the development experience, such as Lombok, MapStruct, and SLF4J.
These tools can significantly improve developer productivity by reducing boilerplate code, automating common tasks, and providing robust logging capabilities.
5. Enforce code style checks and basic error checks using PMD, and integrate with Git hooks to eliminate potential basic errors.
Implementing code style and quality checks, along with integrating them into the Git workflow, ensures that code adheres to the defined standards and catches common issues before they are committed to the repository.
6. Provide a collection of modern, best-practice utility classes.
A set of well-designed and reusable utility classes can help developers avoid reinventing the wheel and ensure that common tasks are performed consistently and efficiently.

## QUICK START
*for now, archetype has not publised to maven central，so you can install it locally:
```shell
# clone git repository
git clone https://github.com/open-halo/halo-starter.git

# install archetype to local
cd halo-starter/archetypes/spring-boot-maven && mvn install

# generate new project from archetype
cd ~/your-awesome-projext-dir
mvn archetype:generate -DarchetypeCatalog=local
```

## what's offer to you ？
### [1] a multi-module Domain-Driver-Design project structure
```html
-- api           # api module
   |-- rest         # restful layer
   |-- grpc         # grpc layer
   |-- dubbo        # dubbo layer
-- api-adapter   # api implements module
   |-- rest         # restful implements layer
   |-- grpc         # grpc implements layer
   |-- dubbo        # dubbo implements layer
-- common        # common tools module
-- core          # core module
   |-- model        # core module layer
   |-- service      # core service layer
   |-- gateway      # core gateway layer
-- infra         # infrastructure module
   |-- persistent   # database layer
   |-- message      # message queue layer
-- external      # external anti-corrosion module
   |-- xxxA         # anti-corrosion layer A
   |-- xxxB         # anti-corrosion layer B
-- starter       # startup container layer
```

### [2] Elaborately Selected Dependencies
Choosing the right versions is often a complex task as several factors need to be considered:

Freshness: Prefer the latest version that is compatible with the JDK, such as the latest Spring Boot.  
Compatibility: Libraries and packages need to be compatible with each other. Sometimes, directly updating to the latest version can result in incompatibilities between different libraries.  
Correctness: Some packages may have memory leaks or other unknown issues.  
Proven: Choose libraries that have been battle-tested and are widely used.  
For example, using Hutool.  
For example, using Jimmer for the database operation layer.  
Validation: The library should be used by a large number of projects, and there should be live, accessible projects available for online validation.  

### [3] Engineering to Ensure Code Style
When taking over an old project, one of the most undesirable tasks is global code formatting because it usually means a large number of Git changes, making code review almost impossible. As a technical manager, the ideal scenario is that all submitted code is already formatted. This formatting should be achieved through engineering techniques rather than company management policies. Code style is more important than just formatting, such as disallowing unused imports.

### [4] Engineering to Avoid Low-Level Errors
Use PMD check tools and enforce checks before commits using Git hooks. This can significantly reduce low-level errors:  

For example, avoid using == to compare Object instances, as == compares object references, which is rarely what you want.  
For example, avoid catching NPE (NullPointerException) without proper handling.  
For example, avoid empty try-catch blocks that swallow exceptions.  

### [5] Default Configurations Following Best Practices
Use Undertow as the embedded container in Spring Boot.  
Use Log4j2 as the default logging library and configure the default log4j2.xml.  
Enable graceful shutdown by default.  

### [6] Cloud-Native Friendly
Support startup, readiness, and liveness probes in Kubernetes by default.  
Provide default Docker configurations.  
Some frameworks support generating GraalVM native images.  

### [7] Frontend Friendly
Support online documentation similar to Swagger.  
Automatically generate TypeScript interface files that can be directly used by the frontend.

### [8] Production-Ready
Default support for rate limiting.  
Default support for circuit breaking.  

### [9] Traceable
Default design for a call tracing log strategy, including logging of input and output parameters.  

## How Much Time We Can Save?
Setting up an excellent template might take at least 1 day for an experienced programmer.
A well-structured and battle-tested module and package design can save a significant amount of time on code reviews and reduce the cost of understanding the code.
Enforcing code style and avoiding low-level errors through engineering practices can prevent many low-level errors, ensuring a baseline of project quality and saving time that would otherwise be spent fixing these errors.
Automatically generating frontend interfaces can save a lot of time on interface alignment and parameter synchronization.
Package Size and Startup Performance

|Template|	Package Size|	Startup Time|
|--|--|--|
|Spring Boot|	47M	|2.041s|

The larger dependencies include: Spring itself, MySQL driver, Jimmer, Jackson, Log4j2, Hutool, and H2.
Jimmer takes up about 10M and has some unnecessary dependencies, which should be reduced as it matures.
* H2 is not a necessary dependency and can be removed in production builds; it is only strongly depended on in the example project because it uses H2 as the database.
* Replacing Jackson with another implementation might significantly reduce the package size.
* Hutool is very powerful, so it is relatively large, but it is worth it.
* Spring, MySQL driver, and Log4j2 are not easily reducible parts.
* 
## What Are the Core Design Principles of This Template/Boilerplate?
The core design principles of this project are to pursue "external flexibility" and "core stability" in software engineering:

* External Flexibility refers to the ability of the software to adapt to different external environments. For example, allowing the project to switch flexibly between Spring Boot and Quarkus, or between MySQL and PostgreSQL, or between RocketMQ and Kafka. This isolation is not just to cope with potential changes but also to encourage developers to focus on the core business logic.
Core Stability means that we want the most fundamental logic of the software to be relatively stable. Only with this stability and testability can we ensure the continuous stability of the project. We aim to convert all implicit concepts into domain modeling through DDD and solidify them in the core.
Why Enforce DDD Style? Is It Too Heavy for Small Projects?
We firmly endorse the following three values:

* Having a clear and fixed structure for files and classes by adding more layers is more important than saving a package/directory level.
Defining "variables," "functions," and "objects" with a few extra lines of code to make the logic clear is more important than saving a few lines of code.
Enforcing isolation between modules can reduce a lot of confusion caused by unclear logical layering. If we agree with these values, we won't consider having a few extra layers or packages as being too heavy. We believe that ordered layers are far better than a flat, unorganized structure.


## Layer Definitions：
![alt text](examples/spring-boot-maven/.docs/halo-design.png)

* api: Interface layer, purely defines interfaces and objects with no logic. It has a weak dependency on Spring Boot due to annotations.
* api-adapter: Adapter layer, implements the interfaces defined in the api module. It contains simple implementations and forwards core logic to the core service layer.
core: Core logic implementation layer, contains pure business logic and is the heart of the entire project.
* infra: Infrastructure layer, handles foundational setup and configurations.
* external: Anti-corrosion layer, all external calls must go through this layer before being called internally.
* common: Utility layer, contains pure function utility classes and can include some external tool libraries.
* starter: Starter module, centralizes configuration files.

## Global Dependencies:
* api: No dependencies, as it may be imported by other parties. Fewer dependencies are better to avoid library pollution.
* common: Pure utility classes, does not depend on any other modules. It can wrap some libraries and can be used by all modules except api.
* api-adapter: Depends on api, core, and common.
* external: Depends only on common and some external SDKs or third-party JARs.
* infra: Depends on common and core. It introduces the gateway from core and implements the interfaces in the gateway.
* core: Depends only on common. This is an example of dependency inversion.
* starter: Depends on all modules.
* 
## Tool Selection
* JSON Tool: Chose xjsonkit as the facade framework, which isolates the underlying implementation. The default underlying JSON library is Jackson, but it can use other popular JSON libraries.
* Date and Format Conversion Tools: Used Hutool for date and format conversion.
* Logging: Used SLF4J with Lombok, with Log4j2 as the underlying logging framework.
* Internal ORM Framework: Defaulted to Jimmer.
* Simple Query Needs: Defaulted to BeanSearcher for simple query requirements.
* 
## TODO List
-[x] Add DAL (Data Access Layer) examples
-[x] Add PMD code checks
-[x] Add Git commit hooks to enforce PMD checks
-[x] Add formatting tools to automatically format code before commits
-[x] Add full configuration for SLF4J + Log4j2
-[x] Add basic utility classes 
-[ ] Add best practice markdown documentation for each layer
-[ ] Add Docker configuration
-[ ] Add GraalVM configuration
-[ ] Add gRPC/Dubbo modules
-[ ] Add a unified interceptor
-[ ] Add Spring Doc implementation
-[ ] Automatically generate TypeScript code

## LICENSE
Apache OR MIT

