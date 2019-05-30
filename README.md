# micro-shop
微商城后台工程
springcloud + thymleaf+ zuul + eureka + redis + beetl + jquery


HTTP Method
  GET：查询
  POST：新增
  PUT：修改
  DELETE：删除

URL命名
  所有与后台交互的api均以/api开头
  第二级url与对应数据库表名称对应
  不允许大写，允许下划线，例如/sipPhone应该定义为/sip_phone
状态码
  200：所有的成功请求全部返回200；
  400：所有的客户端错误，如参数类型错误、缺少参数、HTTP Method错误等；
  401：用户身份未认证，即没有登录；
  403：用户进行未授权操作，包括功能性权限限制和数据级权限限制；
  404：资源没找到，例如根据ID查找某个对象，数据库里没记录；
  500：所有的服务端错误全部返回500；
