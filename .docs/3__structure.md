## 整体的模块结构如下：
![alt text](examples/spring-boot-maven/.docs/halo-design.png)
### api: 接口层
纯定义interface和object，无逻辑。  
定位是打包给其他接入项目使用，所以追求极致的干净，rest注解使用jakarta也就做到了极致干净。


### api-adapter: 适配层
接口适配实现模块，包含简单实现，核心逻辑转发到core service layer。 
本框架主张连最基本的参数校验都不做，纯转发到core层。
如果这只是一个空的层次，为什么还要存在？ 
因为我们希望同时提供rest/grpc/dubbo等服务，但是核心层core层完全不变。

### core: 核心逻辑实现层， 
纯代码逻辑，整个工程的核心。
包含三个部分：
model: POJO定义  
service：对外服务接口  
gateway：依赖的底层服务接口  

### infra: 基础设置层
### external: 防腐层
外部调用必须经过防腐层才内被内部调用  

### common: 工具层
纯函数的工具类，可以一些外部工具库 
### starter: 启动模块
配置文件集中在这里

