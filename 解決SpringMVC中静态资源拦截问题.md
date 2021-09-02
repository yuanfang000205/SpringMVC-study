## 解決SpringMVC中静态资源拦截问题

### 出现原因：

**由于在web.xml中配置springmvc的核心servlet DispatherServlet 时将pattern配置为 “/”,因此会导致项目中所有 / 开头请求，均被作为控制器请求处理，导致项目中的静态资源被拦截 **

#### 解决方案

* url-pattern 配置为*.action *.do

  使用这种方式日后访问路径结尾必须加入指定后缀

* url-pattern仍旧为/

  在springmvc.xml中加入以下配置

  * <mvc:default-servlet-handler/>



