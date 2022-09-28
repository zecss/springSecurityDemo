# springSecurityDemo

### 1.实现从数据库查询用户信息
1. 自定义UserDetailsServiceImpl实现UserDetailsService
2. usermapper 查询用户
3. 返回一个loginUser(继承UserDetails)
### 2.自定义登录接口(jwt)
1. 使用AuthenticationManager的authenticate方法来进行用户认证
2. 认证获取用户信息-以id生成jwt返回,并且将用户信息存入redis
### 3.认证过滤器
1. 自定义接口继承OncePerRequestFilter
2. 读取token 解析token 取用户信息 封装成Authentication存入SecurityContextHolder
3. 认证通过放行
### 4.退出登录
1. 读取SecurityContextHolder中的用户信息
2. 删除redis中的用户
3. 返回结果
