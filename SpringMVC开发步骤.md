# SpringMVC开发步骤

## 1.引入相关依赖

* ```xml
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <!--springmvc核心依赖-->
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.2.RELEASE</version>
  </dependency>
  <!--servlet-api-->
  <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
  </dependency>
  ```

## 2.配置web.xml

* DispatcherServlet   使用servlet标签  url-pattern：/

  * ```xml
    <!--配置springmvc核心servlet-->
    <servlet>
      <servlet-name>springmvc</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <!--配置springmvc配置文件的位置-->
      <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springmvc.xml</param-value>
      </init-param>
    </servlet>
    <!--其中'/'表示拦截所有请求-->
    <servlet-mapping>
      <servlet-name>springmvc</servlet-name>
      <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```

## 3.配置springmvc.xml

* ```xml
  <!--开启注解扫描-->
  <context:component-scan base-package="com.yuanfang.controller"/><!--这里只解析控制器包-->
  <!--配置处理器映射器-->
  <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
  <!--配置处理器适配器-->
  <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
  <!--配置视图解析器-->
   <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <!--注入前缀和后缀-->
          <property name="prefix" value="/"/>
          <property name="suffix" value=".jsp"/>
      </bean>
  ```

  **其中处理器映射器和处理器适配器SpringMVC中不推荐以上写法**

* ```xml
  <!--推荐写法-->
  <mvc:annotation-driven/>
  ```

## 4.编写Controller层

