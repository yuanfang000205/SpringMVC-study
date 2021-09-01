### 1）GET请求

a）tomcat8.x之前，默认server.xml中的URIEncoding="iso-8859-1"

b）tomcat8.x之后，默认server.xml中的URIEncoding="UTF-8"

### 2）POST请求

​	由于springmvc中没有对post请求进行编码处理，所以会出现中文乱码

**解决方案：**

* a）自定义filter，在设置request和response对象编码为utf-8
* b）使用springmvc中提供的编码filter->CharacterEncodingFilter	/* 

```xml
<filter>
  <filter-name>charset</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>charset</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
```