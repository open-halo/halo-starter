## TODO list
1. 添加DAL层示例
2. 添加PMD代码检查
3. 添加git提交钩子，强制PMD检查
4. 添加格式化工具，提交前自动格式化
5. 添加slf4j + logback的全套配置
6. 添加基础工具类
7. 添加统一拦截器
8. 添加spring doc实现


## 整体的模块如下：
1. api-rest: 接口定义module，纯interface，无逻辑，因为需要注解，弱依赖于spring boot
2. biz-rest: 接口实现module，包含简单实现，核心逻辑转发到core service layer
3. csl: 核心逻辑实现层\[core service layer\]， 纯代码逻辑
4. dal: 数据访问层，包含所有数据库的访问操作
5. ext: 防腐层，外部调用必须经过防腐层才内被内部调用
6. fun: 工具层，纯函数的工具类，可以一些外部工具库
7. starter: 启动module，配置文件集中在这里

## 整体的modules依赖关系强制如下
1. api-rest: 基本纯无依赖，因为其他方可能导入
2. biz-rest: 依赖于api-rest, csl, ext, fun
3. csl: 依赖于fun + ext，其余无依赖，这里依赖倒置
4. dal: 依赖于csl，引入csl的interface，然后实现
5. ext: 只依赖于fun，以及一些外部sdk或者三方jar
6. fun: 纯工具，不依赖其他任何module
7. starter: 依赖所有module