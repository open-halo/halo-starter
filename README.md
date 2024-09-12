## TODO list
- [] 添加DAL层示例 
- [] 添加PMD代码检查 
- [x] 添加git提交钩子，强制PMD检查
- [x] 添加格式化工具，提交前自动格式化
- [] 添加slf4j + logback的全套配置
- [] 添加基础工具类
- [] 添加统一拦截器
- [] 添加spring doc实现

## 整体的模块如下：
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
3. api-adapter: 依赖于api, core, external, common
4. external: 只依赖于common和一些外部sdk或者三方jar
5. infra: 依赖于core，引入csl的interface，然后实现
6. core: 依赖于fun + ext，其余无依赖，这里依赖倒置
7. starter: 依赖所有module