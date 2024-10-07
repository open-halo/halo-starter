# Restful API设计指南：

## 方法选择 
GET: 读取  
POST：创建  
PATCH：更新  
DELETE：删除  

## URL设计  
1. 使用名词  
不使用/getBooks和/queryUsers  
使用/users  

2. 使用复数  
不使用/user/2  
使用/users/2  

3. 避免多级  
不使用 /users/12/categories/3  
使用 /users/12?categories=3

## 状态码设计
1. 1xx: 表示相关信息，一般很少用  

2. 2xx: 表示操作成功  
200 OK  
201 CREATED  
204 No Content  

3. 3xx: 表示重定向，一般API也不用
301 permanent redirect
302 temporary redirect

4. 4xx: 表示客户端错误，最常用  
400 Bad Request  
401 Unauthorized  
403 Forbidden  
404 Not Found  
415 Unsupported Media Type  
429 Too Many Requests  

5. 5xx：表示服务端错误，常用  
500 Internal Server Error，永久性错误，例如Null错误，需要程序修复  
503 Service Unavailable，暂时性错误，例如数据库宕机，不改程序能恢复

# 关于API的统一返回值

```json
{
  "success": true,
  "errCode": 20059,
  "errMsg": "",
  "data": {}
}
```

# 关于写入API的设计
1. 创建/新增实体使用POST，常用  
例如 POST /users
一般返回主键，因为主键在服务端生成  

2. 全实体替换更新使用PUT， 应该较少使用 
例如 PUT /users  
必须包含所有实体的必填字段，选填字段如果不存在，会被置空或者设定为默认值

3. 局部更新使用PATCH，常用  
例如 PATCH /users
默认必须包含主键，是主键更新，给出字段采用JSON Merge Patch (RFC 7396)
推荐写法是
```html
PATCH /users HTTP/1.1
Host: example.com
Content-Type: application/json
{
    "id": 123,
    "email": "johndoe@example.com"
}
```

标准写法是，但是这个标准写法在实现的时候比较别扭，
```html
PATCH /users/123 HTTP/1.1
Host: example.com
Content-Type: application/json
{
    "email": "johndoe@example.com"
}
```


可选择支持JSON Patch (RFC 6902)
```html
PATCH /users HTTP/1.1
Host: example.com
Content-Type: application/json
{   
    "id": 123,
    "op": "replace",
    "path": "email",
    "value": "johndoe@example.com"
}
```
可选择支持非主键更新


4. 删除使用DELETE，常用  
例如 DELETE /users/12，表示删除主键为12的用户  
例如 DELETE /users?name=lilei


# 关于查询API的设计
1. 主键查询使用URL  
例如GET /users/12，表示查询id为12的用户
2. 索引查询使用Query  

2.1 不用使用URL，使用query参数实现查询参数  
例如 GET /users?name=lilei，表示查询性名为lilei的用户   

2.3 如果索引是唯一索引，添加uk=true，至多返回一个实体
例如 GET /users?name=lilei&uk=true  

2.2 如果索引不是唯一索引，那么page,size两个字段必填  
例如 GET /users?name=lilei&page=1&size=10  

2.4 排序order字段可以多次成对出现  
例如order=name,asc&order=email,desc

2.5 字段筛选可以出现
例如 GET /users?name=lilei?page=1&size=10&fields=id,name,email





