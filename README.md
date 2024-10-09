# Halo
![alt text](.docs/flagship.png)

## 这个项目模板\[template\] \[boilerplate\]提供什么能力？
1. 提供一个基础项目，快速开启一个spring-boot/helidon/quarkus/micronaut项目
2. 一个合理的久经考验的项目module和包接口，这个结构符合DDD最佳实践
3. 提供基础的命名约束规范要求，减少可能存在的沟通歧义
4. 提供大量提升开发体验的能力，如lombok，mapstruct，slf4j等
5. 提供强制的代码风格检查&PMD基础错误检查，并配合git hooks消除潜在基础错误
6. 许多符合现代最佳实践的工具类

## QUICK START
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

## 这个项目能为你做什么？
### [1] 符合DDD设计的多module架子
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

### [2] 恰当的依赖
选取正确的版本，通常是一件蛮复杂的事情，通常有一下一些问题需要考虑：
1. 新鲜：尽量选择JDK兼容下最新的版本，如最新的Spring Boot
2. 兼容：不同库和包之间需要兼容，有时候直接更新到最新版本，会发现几个库之间不兼容
3. 正确：一些包中有内存泄漏，有一些不知名的坑
4. 最佳：选择一些久经考验的库
例如使用hutools
例如使用jimmer作为数据库操作层
5. 验证：被大量项目使用，有实时可访问的项目作为在线验证

### [3] 工程化地保证代码风格
我们接手一个旧的项目的时候，通常最不愿意做的事情就是全局代码格式化，
因为这通常意味着大量的git变更，基本无法做code review。
作为一个技术管理人员，最希望的可能是所有提交的代码都是格式化好的。
这个格式化最好不是基于公司的管理手段的，而是基于工程的技术手段完成的。
代码风格比格式化更加重一些，例如不允许无用的import等

### [4] 工程化地避免低级错误
很多错误是天然的低级错误
1. Object使用==对比，java的==对比的是object id，绝大部分不是我们期望的
2. Catch NPE错误，
3. 空的try catch通常是危险的

### [5] 符合最佳实践的默认配置
1. 例如Spring Boot使用undertow提高性能
2. 例如使用log4j2提高日志性能，并做默认配置
3. 默认启动优雅停机graceful shutdown

### [6] 云原声友好
1. 默认支持k8s下的startup,readiness,liveness探针
2. 提供默认的docker配置
3. 部分框架提供graalvm的native image生成

### [7] 前端友好
1. 支持类似swagger的在线文档
2. 自动生成前端直接可用的typescript的接口文件

## 一个架子能够节省多少时间
1. 搭建一个优秀的架子，一个工作多年的程序员可能也至少需要6h
2. 久经考验的模块和分包设计，能够节省大量code review的时间和理解成本
3. 工程化地强制代码风格和避免低级错误，能够避免大量低级错误，保证项目质量底线，节省纠正低级错时间
4. 自动生成前端接口，可节省大量接口联调对齐参数的时间


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


## 整体的模块如下：
![alt text](examples/spring-boot-maven/.docs/halo-design.png)
1. api: 接口层，纯定义interface和object，无逻辑，因为需要注解，弱依赖于spring boot
2. api-adapter: 适配层，接口实现module，包含简单实现，核心逻辑转发到core service layer
3. core: 核心逻辑实现层， 纯代码逻辑，整个工程的核心
4. infra: 基础设置层
5. external: 防腐层，外部调用必须经过防腐层才内被内部调用
6. common: 工具层，纯函数的工具类，可以一些外部工具库
7. starter: 启动module，配置文件集中在这里

## 整体的modules依赖关系强制如下
1. api: 无依赖，因为其他方可能导入，依赖越少越好，避免库污染
2. common: 纯工具，不依赖其他任何module，可以二次封装一些库，可以被除api以外所有模块依赖
3. api-adapter: 依赖于api, core, common
4. external: 只依赖于common和一些外部sdk或者三方jar
5. infra: 依赖于common + core，引入core的gateway，然后实现gateway中的interface
6. core: 依赖于common，其余无依赖，这里依赖倒置
7. starter: 依赖所有module

## 工具类选择
1. Json工具选择了xjsonkit作为门面框架，隔离了底层实现，底层可以使用几大常用json库都以，默认是jackson
2. 日期等格式转换工具使用了Hutool
3. 日志使用slf4j配合lombok，底层使用log4j2
4. 内部ORM框架，默认使用Jimmer
5. 对于简单查询需求，默认引入了BeanSearcher


## TODO list
- [x] 添加DAL层示例 
- [x] 添加PMD代码检查 
- [x] 添加git提交钩子，强制PMD检查
- [x] 添加格式化工具，提交前自动格式化
- [x] 添加slf4j + log4j2的全套配置
- [x] 添加基础工具类
- [] 添加每个层的最佳实践markdown文档
- [] 添加docker配置
- [] 添加graalvm配置
- [] 添加grpc/dubbo模块
- [] 添加统一拦截器
- [] 添加spring doc实现
- [] 自动生成typescript代码

## LICENSE
Apache

