<div style="text-align: center;">
  <h1>星环 [Halo]</h1>
</div>

![alt text](.docs/flagship.png)
星环是刘慈欣小说《三体》中星际舰队的旗舰  

# Docs
[English](README-en.md)

## 快速开始
*由于现在archetype还没有发布到maven中央仓库，所以可以按照本地安装流程使用
```shell
# clone git repository
git clone https://github.com/open-halo/halo-starter.git

# install archetype to local
cd halo-starter/archetypes/spring-boot-maven && mvn install

# generate new project from archetype
cd ~/your-awesome-projext-dir
mvn archetype:generate -DarchetypeCatalog=local
```


## 特性
### [1] 符合DDD设计的多模块工程架子
```html
-- api           # 对外接口模块
   |-- rest         # restful接口层
   |-- grpc         # grpc接口层
   |-- dubbo        # dubbo接口层
-- api-adapter   # 接口实现模块
   |-- rest         # restful接口实现层
   |-- grpc         # grpc接口实现层
   |-- dubbo        # dubbo接口实现层
-- common        # 工具类模块
-- core          # 核心模块
   |-- model        # 核心实体定义层
   |-- service      # 核心服务层
   |-- gateway      # 核心依赖接口层
-- infra         # 基础设施模块
   |-- persistent   # 数据存储层
   |-- message      # 消息处理层
-- external      # 外部防腐模块
   |-- xxxA         # 防腐层A
   |-- xxxB         # 防腐层B
-- starter       # 启动模块
```
[模块结构说明](.docs/3__structure.md)

### [2] 默认集成开发提效工具
1. lombok帮助简化冗余模版代码
2. mapstruct帮助简化类型转化代码  
[代码增强说明](.docs/1__source_enhance.md)

### [3] 强制代码风格
使用maven-java-formatter-plugin执行代码格式化。  
可添加自定义格式化规则，规则目录在  
[.halo/formatter/format.xml](examples/spring-boot-maven/.halo/formatter/format.xml)

### [4] PMD强制校验低级错误
使用maven-pmd-plugin配合上百条校验规则进行PMD强制校验。  
规则目录在(可添加自定义规则):  
[.halo/pmd-check-rules](examples/spring-boot-maven/.halo/pmd-check-rules/main/resources/pmd-ruleset.xml)  

使用PMD检查工具，并使用git hook强制提交前进行检查，这能大量避免低级错误  
**规则正在逐步添加中**


### [5] 精挑细选的依赖
选取正确的版本，通常是一件蛮复杂的事情，通常有一下一些问题需要考虑：
1. 新鲜：尽量选择JDK兼容下最新的版本，如最新的Spring Boot
2. 兼容：不同库和包之间需要兼容，有时候直接更新到最新版本，会发现几个库之间不兼容
3. 正确：一些包中有内存泄漏，有一些不知名的坑
4. 最佳：选择一些久经考验的库
5. 验证：被大量项目使用，有实时可访问的项目作为在线验证

   | 功能        | 当前选择      | 其他候选                |
   |-----------|-----------|---------------------|
   | 日志        | log4j2    | logback             |
   | jakarta注解 | resteasy  | -                   |
   | 工具类       | hutool    | apache-common/guava |
   | 校验库| hibernate | fluent              |
   |ORM| jimmer    | JPA MyBatis|

### [6] 符合最佳实践的默认配置
1. Spring Boot使用undertow作为内置容器
2. 使用log4j2作为默认日志库，并配置默认log4j2.xml
3. 默认启动优雅停机graceful shutdown  
[最佳实践配置说明](.docs/2__spring_optimize.md)

### [7] 云原声友好(正在建设中)
1. 默认支持k8s下的startup,readiness,liveness探针
2. 提供默认的docker配置
3. 部分框架提供graalvm的native image生成  

### [8] 前端友好(正在建设中)
1. 支持类似swagger的在线文档
2. 自动生成前端直接可用的typescript的接口文件

### [9] 生产就绪的(正在建设中)
1. 默认支持限流
2. 默认支持熔断

### [10] 可追踪(正在建设中)
默认设计好的一套调用追踪日志策略
默认记录出入参数  

## 一个架子能够节省多少时间
1. 搭建一个优秀的架子，一个工作多年的程序员可能也至少需要1-day
2. 久经考验的模块和分包设计，能够节省大量code review的时间和理解成本
3. 工程化地强制代码风格和避免低级错误，能够避免大量低级错误，保证项目质量底线，节省纠正低级错时间
4. 自动生成前端接口，可节省大量接口联调对齐参数的时间

## 打包大小和启动性能
| 模板           | 打包大小    | 启动时间     |
|--------------|---------|----------|
| spring-boot  | 47M     | 2.041s   |
* 较为大的依赖是几大部分：spring本身，mysql driver, jimmer, jackson, log4j2, hutool, h2
* jimmer占用10M左右，有很多不合理的依赖，随着后续的成熟应该会减少
* h2是一个非必要依赖，可以在生产包去掉，只是示例项目依赖h2作为数据库，所以强依赖
* jackson如果替换为其他实现，可能会减少很多体积
* hutool功能是非常强大的，所以也比较大，但其实是值得的
* spring, mysql driver, log4j2 是不容易减少的部分

## 这个项目模板\[template\] \[boilerplate\]的核心设计理念是什么？
这个项目的核心设计理念是：追求软件工程的「外延灵活性」和「内核确定性」
1. 「外延灵活性」是指软件可能适应不同的外在环境，例如允许项目在spring boot/quarkus \
之间灵活切换，在MySql和PostgreSQL之间切换，在RockerMQ和Kafka之间灵活切换。这种隔离性 \
不仅仅是为了应对潜在的变化，更加会促使开发者把真正的业务逻辑沉淀到核心层。
2. 「内核确定性」是指我们希望软件最内核的逻辑是相对稳定的，只有这部分的相对稳定，可测，才能\
保证项目的持续稳定性。我们希望通过DDD把原来隐性的概念，全部转化为领域建模，沉淀在内核之中。

## 为什么强制使用DDD风格，这个风格对于小型项目是否过重？
我们坚定地认可以下3条价值观：
1. 多几个层次划分，让文件和class的位置清晰固定，比节省一个包/目录层次重要
2. 多几行代码把「变量」「函数」「对象」定义出来，让逻辑变得明确，比节省几行代码重要  
3. module之间的强制隔离，能减少很多逻辑层次的划分不明确导致的代码混乱  
如果我们认可以上价值，我们不会认为多分了几个层，多分了几个包就是重。
我们认为有序的层次，远远好于无序的平铺。


## 选择&思考
### 关于maven和gradle
* 后续maven和gradle都会支持。  
* 公司级项目推荐maven，因为简单，因为没有那么多高级特性，所以不用担心某些同事玩出花活儿，下限有保证。  
* 个人级项目推荐gradle，因为行数少，修改依赖简单一些，能节省不少代码，同时也能玩出高级花活儿，上限有保证。  

### 关于Spring boot/quarkus/micronaut/helidon
* 绝大多数情况推荐Spring boot，因为资料多，时髦的graalvm native也能做。  
* 如果实在希望内存占用少，轻量化且现代化，推荐quarkus，热更新做得特别好，DI是一个build-time的实现。
* micronaut的显著特点是编译期DI和编译期AOP，考虑极致性能可以考虑。
* helidon现在没有特别优势，暂不建议投入学习过多。  

### 关于IoC/DI注入注解
* 推荐使用jakarta标准注解，而不用spring的@Autowire

### 关于restful接口的注解
* 建议用jakarta标准注解，就算在spring环境中也建议用标准注解。
* 你会发现万一有一天需要迁移到其他框架的时候，能节省大量工作量。
* 最主要的是jakarta标准注解比起spring注解也没有太多不方便的地方。

### 关于文档
#### REST接口
* 通过interface直接生成OpenApi文档是较好的工程实践
* 开发环境支持swagger-ui和直接下载openapi.yaml，生产环境关闭
* 前端可以通过类似orval的工具，根据下载的openapi.yaml自动生成client
* REST是多数情况下的默认最优解
**当前resteasy-spring-boot-starter和spring-doc还无法兼容**

#### GRPC接口
* 后端直接定义.proto文件，在API层生成需要实现的接口
* 前端通过工具从.proto文件直接生成client文件
* GRPC直接做前后端交互现在还有少量缺陷，例如文件上传麻烦
* 网关想做细粒度的权限控制复杂，因为不好在网关层感知payload内容

### 关于bean校验
* hibernate validator注解校验是现在体验最好的标准化方案

### 关于JPA，MyBatis和Jimmer
* 如果是国外项目，推荐JPA，国际友人对JPA标准还是很有执念的。
* 如果是国内项目，推荐MyBatis，毕竟后续能够开发维护的人是最多的。
* 如果是全新项目，推荐尝试Jimmer，很多开发体验可能超出你的想象，但不成熟。

### 关于Jackson/Fastjson/Gson
* 国外项目，不用犹豫，直接Jackson。   
* 国内项目，可以考虑fastjson2，确实快很多，就是偶尔有问题或者漏洞。  
* Gson尽量不用，范型API上相对简洁，但为此引入一套库并不值得。  

### 关于logback和log4j2
* log4j2性能好，不担心兼容性的情况默认选这个吧。  
* logback兼容性好

### 关于Hutool
* Hutool很好，比大多数的程序员能够写出的代码都好，尽量采用Hutool工具API可以保证很多质量下限。  

### 关于BeanSearcher
* 能够极大减少查询类工作量，建议尝试。


## TODO list
- [x] 添加DAL层示例 
- [x] 添加PMD代码检查 
- [x] 添加git提交钩子，强制PMD检查
- [x] 添加格式化工具，提交前自动格式化
- [x] 添加slf4j + log4j2的全套配置
- [x] 添加基础工具类
- [ ] 添加每个层的最佳实践markdown文档
- [ ] 添加docker配置
- [ ] 添加graalvm配置
- [ ] 添加grpc/dubbo模块
- [ ] 添加统一拦截器
- [ ] 添加spring doc实现
- [ ] 自动生成typescript代码

## LICENSE
Apache OR MIT

