## SSM-SpringMVC+Spring+Mybatis整合开发步骤

### 1.引入依赖

* spring	 springmvc	 mybatis 	mybatis-spring 	mysql 	druid	 log4j 	servlet-api 	jstl 	fastjson

  * ```xml
    <!--spring核心及相关依赖-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
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
      <artifactId>spring-context</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
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
    <!--jstl-->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!--Mybatis依赖-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.4</version>
    </dependency>
    <!--mybatis-spring依赖-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>2.0.4</version>
    </dependency>
    <!--mysql依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
    </dependency>
    <!--druid数据源依赖-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.19</version>
    </dependency>
    ```

### SM整合

#### 1.建表

#### 2.实体类

#### 3.DAO接口

#### 4.Mapper配置文件

#### 5.Service接口

#### 6.Service实现类 @Service @Transactional 注入DAO对象

#### 7.引入spring.xml编写spring整合mybatis配置

* 开启注解扫描

  * ```xml
    <context:component-scan base-package="com.yuanfang"/>
    ```

* 创建数据源对象

  * ```xml
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3333/mybatis?serverTimezone=Asia/Shanghai"/>
        <property name="username" value="root" />
        <property name="password" value="root" />
    </bean>
    ```

* 创建sqlSessionFactory

  * ```xml
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:com/yuanfang/mapper/*.xml"/>
        <property name="typeAliasesPackage" value="com.yuanfang.entity"/>
    </bean>
    ```

* 创建DAO

  * ```xml
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <property name="basePackage" value="com.yuanfang.dao"/>
    </bean>
    ```

* 创建事务管理器

  * ```xml
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    ```

* 开启注解式事务生效

  * ```xml
    <tx:annotation-driven/>
    ```

#### 8.测试Service方法调用

### 3.SS整合

### 1.配置web.xml

* 启动工厂监听器

  * ```xml
    <listener>
      <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    ```

* 配置工厂配置文件 spring.xml

  * ```xml
    <context-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring.xml</param-value>
    </context-param>
    ```

* 配置springmc核心的servlet  DispatcherServlet url-pattern /

  * ```xml
    <servlet>
      <servlet-name>springmvc</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springmvc.xml</param-value>
      </init-param>
    </servlet>
    <servlet-mapping>
      <servlet-name>springmvc</servlet-name>
      <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```

* 配置springmvc接收post请求中文乱码

  * ```xml
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

### 2.引入springmvc.xml配置

* 开启注解扫描

  * ```xml
    <context:component-scan base-package="com.yuanfang.controller"/>
    ```

* 配置处理器映射器和处理器适配器

  * ```xml
    <mvc:annotation-driven/>
    ```

* 配置视图解析器

  * ```xml
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    ```

### 3.开发controller

### 4.服务器部署进行访问



