## SpringMVC中实现拦截器功能

### 1.定义拦截器并实现

* ```java
  @Override
  //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      System.out.println(((HandlerMethod)handler).getMethod().getName());
      System.out.println("===========1=============");
      //强制用户登录
      /*Object user = request.getSession().getAttribute("user");
      if(user==null){
          //重定向到登录页面
          response.sendRedirect(request.getContextPath()+"/login.jsp");
          return false;
      }*/
      return true;
  }
  
  @Override
  //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象 参数4: 当前请求控制器方法返回值 = 当前请求控制器方法返回的modelandview对象 modelandview 模型和试图
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      System.out.println(modelAndView);
      System.out.println("===========3=============");
  }
  
  
  @Override
  //注意: 无论正确还是失败都会执行
  //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象  参数4: 请求过程中出现异常时异常对象
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      if(ex!=null){
          System.out.println(ex.getMessage());
      }
      System.out.println("===========4=============");
  }
  ```

* 注册拦截器并且使用

  * ```xml
    <!--注册拦截器-->
    <bean id="myInterceptor" class="com.yuanfang.interceptors.MyInterceptor"/>
    
    <!--配置拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--配置拦截的请求路径-->
            <mvc:mapping path="/json/*"/>
            <!--配置不被拦截的请求路径-->
            <mvc:exclude-mapping path="/"/>
            <!--使用的拦截器-->
            <ref bean="myInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
    ```