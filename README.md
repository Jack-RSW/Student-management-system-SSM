# 学员管理系统后台（crud）

该项目需要有Linux、Mysql、Git、Maven、Java、Spring、SpringMVC、Mybatis，jsp等基本概念

**如果觉得不错就点击右上角star鼓励一下作者吧！**

# 关于项目

## 测试环境

```
后端：spring+mybatis+springmvc 
测试环境：IDEA + tomcat8 + mysql5.1.6 + jdk8 + maven
```

## 技术栈

- 项目环境采用`IDEA` + `MAVEN` + `Tomcat` + `MySQL`，数据库连接池采用Druid

## 具体的实现功能
- restful风格的crud操作

- 后台效验

- 登陆拦截

- 全局异常处理

- @Response和@Taglib json数据测试

- string和long类型转换

- log4j2新的日志配置

- 使用pagehelper进行分页

- 引入事务管理

## 项目功能

- 前台：学员功能注册和效验
- 后台：学员功能的CRUD


## 项目结构

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/6dd7540b-9f70-4bb7-8391-25263bb0a83a.png)

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/478e7348-e9a2-4a29-85d8-0d2a3836e4d9.png)

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/4efcd006-a88e-41af-a14d-167a71e8444e.png)



先配置pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
 <modelVersion>4.0.0</modelVersion>

 <groupId>com.jnshu</groupId>
 <artifactId>mySpringMVC</artifactId>
 <version>1.0-SNAPSHOT</version>
 <packaging>war</packaging>

 <name>mySpringMVC Maven Webapp</name>
 <!-- FIXME change it to the project's website -->
 <url>http://www.example.com</url>

 <properties>
   <!--设置编码-->
   <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   <maven.compiler.source>1.7</maven.compiler.source>
   <maven.compiler.target>1.7</maven.compiler.target>
   <!-- spring统一版本号-->
   <spring.version>4.3.17.RELEASE</spring.version>
   <slf4j.version>1.7.25</slf4j.version>
   <log4j.version>2.8.2</log4j.version>
 </properties>

 <repositories>
   <repository>
     <id>java.net</id>
     <url>http://maven.jahia.org/maven2</url>
   </repository>
 </repositories>

 <dependencies>
 <!--AOP jar,spring-aop包含aopallicance-->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-aop</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <!--面向切面的接口-->
<!--   <dependency>
     <groupId>aopalliance</groupId>
     <artifactId>aopalliance</artifactId>
     <version>1.0</version>
   </dependency>-->
<!--    <dependency>
     <groupId>aspectj</groupId>
     <artifactId>aspectjrt</artifactId>
     <version>1.5.4</version>
   </dependency>
   <dependency>
     <groupId>org.aspectj</groupId>
     <artifactId>aspectjweaver</artifactId>
     <version>1.9.2</version>
   </dependency>-->
   <!--AOP jar end-->

   <!--cglib动态代理,spring3.2以后集成了cglib,所以不需要-->
<!--    <dependency>
     <groupId>cglib</groupId>
     <artifactId>cglib-nodep</artifactId>
     <version>3.2.8</version>
   </dependency>
   <dependency>
     <groupId>asm</groupId>
     <artifactId>asm</artifactId>
     <version>3.3.1</version>
   </dependency>
   <dependency>
     <groupId>asm</groupId>
     <artifactId>asm-commons</artifactId>
     <version>3.3.1</version>
   </dependency>
   <dependency>
     <groupId>asm</groupId>
     <artifactId>asm-util</artifactId>
     <version>3.3.1</version>
   </dependency>
   &lt;!&ndash;cglib动态代理&ndash;&gt;-->

   <!--java字节码的动态处理-->
   <dependency>
     <groupId>javassist</groupId>
     <artifactId>javassist</artifactId>
     <version>3.12.1.GA</version>
   </dependency>
   <!--java字节码的动态处理 end-->

   <!--JPA-->
   <dependency>
     <groupId>org.springframework.data</groupId>
     <artifactId>spring-data-commons</artifactId>
     <version>1.13.9.RELEASE</version>
   </dependency>

   <!--使用dbcp作为连接池，需导入dbcp、pool依赖jar包（1.3 + 1.5.4）-->
   <dependency>
     <groupId>commons-dbcp</groupId>
     <artifactId>commons-dbcp</artifactId>
     <version>1.4</version>
   </dependency>
   <dependency>
     <groupId>commons-pool</groupId>
     <artifactId>commons-pool</artifactId>
     <version>1.5.4</version>
   </dependency>
   <!--使用dbcp作为连接池，需导入dbcp、pool依赖jar包（1.3 + 1.5.4）end-->

   <!--导入spring依赖包（5.1.0.RELEASE）-->
   <!--spring-->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-core</artifactId>
     <version>${spring.version}</version>
     <exclusions>
       <exclusion>
         <groupId>org.springframework</groupId>
         <artifactId>spring-jcl</artifactId>
       </exclusion>
     </exclusions>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-beans</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-context</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-tx</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-web</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-webmvc</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-aop</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-expression</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-jdbc</artifactId>
     <version>${spring.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-test</artifactId>
     <version>${spring.version}</version>
     <scope>test</scope>
   </dependency>
   <!--spring end-->

   <!--mysql驱动-->
   <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>8.0.16</version>
   </dependency>

   <!--mybatis jar包-->
   <dependency>
     <groupId>org.mybatis</groupId>
     <artifactId>mybatis</artifactId>
     <version>3.4.5</version>
   </dependency>

   <!--mybatis-spring组合包-->
   <dependency>
     <groupId>org.mybatis</groupId>
     <artifactId>mybatis-spring</artifactId>
     <version>1.3.1</version>
   </dependency>

   <!--junit测试包-->
   <dependency>
     <groupId>junit</groupId>
     <artifactId>junit</artifactId>
     <version>4.11</version>
     <scope>test</scope>
   </dependency>

   <!--文件上传jar-->
   <dependency>
     <groupId>commons-fileupload</groupId>
     <artifactId>commons-fileupload</artifactId>
     <version>1.3.1</version>
   </dependency>
   <dependency>
     <groupId>commons-io</groupId>
     <artifactId>commons-io</artifactId>
     <version>2.5</version>
   </dependency>
   <!--文件上传jar end-->

   <!--pagehelper分页jar包-->
   <dependency>
     <groupId>com.github.pagehelper</groupId>
     <artifactId>pagehelper</artifactId>
     <version>5.1.0</version>
   </dependency>
   <!--pagehelper分页jar包 end-->

   <!--json 相关jar包-->
   <!--fastjson alibaba处理json的jar-->
   <dependency>
     <groupId>com.alibaba</groupId>
     <artifactId>fastjson</artifactId>
     <version>1.2.36</version>
   </dependency>
   <!--加载json 所需的jar-->
   <!--<dependency>
     <groupId>commons-lang</groupId>
     <artifactId>commons-lang</artifactId>
     <version>2.1</version>
   </dependency>
   <dependency>
     <groupId>commons-collections</groupId>
     <artifactId>commons-collections</artifactId>
     <version>3.2.2</version>
   </dependency>
   <dependency>
     <groupId>commons-beanutils</groupId>
     <artifactId>commons-beanutils</artifactId>
     <version>1.9.3</version>
   </dependency>
   <dependency>
     <groupId>net.sf.json-lib</groupId>
     <artifactId>json-lib</artifactId>
     <version>2.4</version>
     <classifier>jdk15</classifier>
   </dependency>-->
   <dependency>
     <groupId>net.sf.ezmorph</groupId>
     <artifactId>ezmorph</artifactId>
     <version>1.0.6</version>
   </dependency>
   <!--json 相关jar包 end-->

   <dependency>
     <groupId>org.json</groupId>
     <artifactId>json</artifactId>
     <version>20140107</version>
   </dependency>

   <!-- 加载json -->
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-core</artifactId>
     <version>2.8.0</version>
   </dependency>
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-annotations</artifactId>
     <version>2.8.0</version>
   </dependency>
   <dependency>
     <groupId>org.codehaus.jackson</groupId>
     <artifactId>jackson-core-asl</artifactId>
     <version>1.9.13</version>
   </dependency>
   <dependency>
     <groupId>org.codehaus.jackson</groupId>
     <artifactId>jackson-mapper-lgpl</artifactId>
     <version>1.9.13</version>
   </dependency>
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-databind</artifactId>
     <version>2.8.0</version>
   </dependency>
   <!-- 加载json end -->

   <!-- validator 数据验证-->
   <!--jsr 303-->
   <dependency>
     <groupId>javax.validation</groupId>
     <artifactId>validation-api</artifactId>
     <version>1.1.0.Final</version>
   </dependency>
   <!-- hibernate validator-->
   <dependency>
     <groupId>org.hibernate</groupId>
     <artifactId>hibernate-validator</artifactId>
     <version>5.2.0.Final</version>
   </dependency>
   <!-- validator 数据验证 end-->

   <!-- jstl jsp解析相关 -->
   <!--servlet-api.jar和jsp-api.jar,开发jsp所需的jar。会与服务器的jar冲突，需改为provided-->
   <!--  HttpServletRequest http请求依赖 -->
   <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>javax.servlet-api</artifactId>
     <version>3.1.0</version>
     <!--  只在编译和测试阶段运行,因为容器中自带了这个jar包 jetty中自带  -->
     <scope>provided</scope>
   </dependency>
   <dependency>
     <groupId>javax.servlet.jsp</groupId>
     <artifactId>jsp-api</artifactId>
     <version>2.1</version>
     <scope>provided</scope>
   </dependency>
   <!--  el表达式，servlet 2.5以后的版本都是默认支持el，可去除 -->
   <!--<dependency>
     <groupId>taglibs</groupId>
     <artifactId>standard</artifactId>
     <version>1.1.2</version>
   </dependency>
   <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>jstl</artifactId>
     <version>1.2</version>
   </dependency>-->
   <!--taglib标签包-->
   <dependency>
     <groupId>atg.taglib.json</groupId>
     <artifactId>json-taglib</artifactId>
     <version>0.4.1</version>
   </dependency>
   <!-- jstl jsp解析相关 end-->

   <!--resin头文件所需的包-->
   <dependency>
     <groupId>joda-time</groupId>
     <artifactId>joda-time</artifactId>
     <version>2.9.4</version>
   </dependency>

   <!--日志log4j2相关jar包-->
   <!--log4j2-->
   <dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>slf4j-api</artifactId>
     <version>1.7.2</version>
   </dependency>
   <dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>jcl-over-slf4j</artifactId>
     <version>${slf4j.version}</version>
     <scope>runtime</scope>
   </dependency>
   <!--核心log4j2jar包-->
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-api</artifactId>
     <version>${log4j.version}</version>
   </dependency>
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-core</artifactId>
     <version>${log4j.version}</version>
   </dependency>
   <!--用于与slf4j保持桥接-->
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-slf4j-impl</artifactId>
     <version>${log4j.version}</version>
   </dependency>
   <!--web工程需要包含log4j-web，非web工程不需要-->
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-web</artifactId>
     <version>${log4j.version}</version>
     <scope>runtime</scope>
   </dependency>
   <!--需要使用log4j2的AsyncLogger需要包含disruptor-->
<!--    <dependency>
     <groupId>com.lmax</groupId>
     <artifactId>disruptor</artifactId>
     <version>3.3.7</version>
   </dependency>-->
   <!--log4j2 end-->
 </dependencies>


 <build>
   <finalName>mySpringMVC</finalName>
   <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
     <plugins>
       <plugin>
         <artifactId>maven-clean-plugin</artifactId>
         <version>3.1.0</version>
       </plugin>
       <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
       <plugin>
         <artifactId>maven-resources-plugin</artifactId>
         <version>3.0.2</version>
       </plugin>
       <plugin>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.8.0</version>
       </plugin>
       <plugin>
         <artifactId>maven-surefire-plugin</artifactId>
         <version>2.22.1</version>
       </plugin>
       <plugin>
         <artifactId>maven-war-plugin</artifactId>
         <version>3.2.2</version>
       </plugin>
       <plugin>
         <artifactId>maven-install-plugin</artifactId>
         <version>2.5.2</version>
       </plugin>
       <plugin>
         <artifactId>maven-deploy-plugin</artifactId>
         <version>2.8.2</version>
       </plugin>
     </plugins>
   </pluginManagement>
   <plugins>
     <plugin>
       <groupId>org.eclipse.jetty</groupId>
       <artifactId>jetty-maven-plugin</artifactId>
       <version>9.4.9.v20180320</version>
     </plugin>
   </plugins>
 </build>
</project>
```



## 1. 先说明配置文件

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/a9d13b4e-801d-44d4-aa6d-32278fbf630c.png)

Auth.xml是做用户实体对象的映射（登陆）

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
       PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "http://www.mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--使用Mybatis的配置文件的方式来配置数据库-->
<mapper namespace="com.jnshu.mapper.IAuthMapper">
   <!-- 通过返回的行数来判断是否成功 大于一为true -->
   <select id="findAuth" parameterType="Auth" resultType="java.lang.Boolean">
       select count(*) from auth where username=#{username} and password=#{password}
</select>
</mapper>
```

Student.xml是学生实体对象的映射（做restful风格的crud操作）

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
       PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "http://www.mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--使用Mybatis的配置文件的方式来配置数据库-->
<mapper namespace="com.jnshu.mapper.IStudentMapper">
   <select id="findById" parameterType="int" resultType="Student">
      select * from student where s_id = #{id};
</select>

   <insert id="addStudent" parameterType="Student">
     <selectKey keyProperty="s_id" resultType="int" order="AFTER">
         SELECT LAST_INSERT_ID() AS id;
</selectKey>
      insert into student value (#{s_id},#{s_name},#{s_qq},#{s_course},#{update_at},#{s_school},#{s_link},#{s_flag},#{s_brother},#{s_source},#{create_at});
</insert>

   <update id="updateStudent" parameterType="Student">
     update student set s_name=#{s_name},s_qq=#{s_qq},s_course=#{s_course},update_at=#{update_at}, s_school=#{s_school},s_link=#{s_link},s_flag=#{s_flag},s_brother=#{s_brother},s_source=#{s_source},create_at=#{create_at} where s_id =#{s_id};
</update>

   <delete id="deleteById" parameterType="int">
      delete from student where s_id = #{id};
</delete>

   <select id="findAll"  resultType="Student">
       <!--select s.s_id,s.s_name,s.s_qq,c.c_course,s.update_at,s.s_school,s.s_link,s.s_flag,b.b_name,s.s_source,s.create_at from student as s,courses as c,brothers as b;-->
       select * from student;
</select>

</mapper>
```



__log4j.properties 旧的log日志处理，加__就不能被识别，不做说明



log4j2.xml未最新推荐的log日志配置

```
<?xml version="1.0" encoding="UTF-8"?>
<!--日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL -->
<!--Configuration后面的status，这个用于设置log4j2自身内部的信息输出，可以不设置，当设置成trace时，你会看到log4j2内部各种详细输出-->
<!--monitorInterval：Log4j能够自动检测修改配置 文件和重新配置本身，设置间隔秒数-->
<configuration status="WARN" monitorInterval="30">
   <!--先定义所有的appender-->
   <appenders>
       <!--这个输出控制台的配置-->
       <console name="Console" target="SYSTEM_OUT">
           <!--输出日志的格式-->
           <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
       </console>
       <!--文件会打印出所有信息，这个log每次运行程序会自动清空，由append属性决定，这个也挺有用的，适合临时测试用-->
       <File name="log" fileName="log/test.log" append="false">
           <PatternLayout pattern="%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n"/>
       </File>
       <!-- 这个会打印出所有的info及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档-->
       <RollingFile name="RollingFileInfo" fileName="${sys:user.home}/logs/info.log"
                    filePattern="${sys:user.home}/logs/$${date:yyyy-MM}/info-%d{yyyy-MM-dd}-%i.log">
           <!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
           <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
           <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
           <Policies>
               <TimeBasedTriggeringPolicy/>
               <SizeBasedTriggeringPolicy size="100 MB"/>
           </Policies>
       </RollingFile>
       <RollingFile name="RollingFileWarn" fileName="${sys:user.home}/logs/warn.log"
                    filePattern="${sys:user.home}/logs/$${date:yyyy-MM}/warn-%d{yyyy-MM-dd}-%i.log">
           <ThresholdFilter level="warn" onMatch="ACCEPT" onMismatch="DENY"/>
           <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
           <Policies>
               <TimeBasedTriggeringPolicy/>
               <SizeBasedTriggeringPolicy size="100 MB"/>
           </Policies>
           <!-- DefaultRolloverStrategy属性如不设置，则默认为最多同一文件夹下7个文件，这里设置了20 -->
           <DefaultRolloverStrategy max="20"/>
       </RollingFile>
       <RollingFile name="RollingFileError" fileName="${sys:user.home}/logs/error.log"
                    filePattern="${sys:user.home}/logs/$${date:yyyy-MM}/error-%d{yyyy-MM-dd}-%i.log">
           <ThresholdFilter level="error" onMatch="ACCEPT" onMismatch="DENY"/>
           <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
           <Policies>
               <TimeBasedTriggeringPolicy/>
               <SizeBasedTriggeringPolicy size="100 MB"/>
           </Policies>
       </RollingFile>
   </appenders>
   <!--然后定义logger，只有定义了logger并引入的appender，appender才会生效-->
   <loggers>
       <!--过滤掉spring和mybatis的一些无用的DEBUG信息-->
       <logger name="org.springframework" level="INFO"></logger>
       <logger name="org.mybatis" level="INFO"></logger>
       <root level="all">
           <appender-ref ref="Console"/>
           <appender-ref ref="RollingFileInfo"/>
           <appender-ref ref="RollingFileWarn"/>
           <appender-ref ref="RollingFileError"/>
       </root>
   </loggers>
</configuration>
```



springmvc-servlet.xml 配置文件

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">

   <!--扫描controller包下所有的文件-->
   <context:component-scan base-package="com.jnshu.controller" use-default-filters="false">
       <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:include-filter>
   </context:component-scan>

   <!--设置全局异常处理器-->
   <bean id="studentExceptionResolver" class="com.jnshu.exception.StudentExceptionResolver"></bean>


   <!--开启SpringMVC注解模式-->
   <!-- 添加效验器和转换器-->
   <mvc:annotation-driven conversion-service="FormattingConversionService" validator="validator"></mvc:annotation-driven>

   <!--配置转换器-->
   <bean id="FormattingConversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
       <!--转换器-->
       <property name="converters">
           <list>
               <!--日期转换器-->
               <bean class="com.jnshu.utils.TimeConvert"></bean>
           </list>
       </property>
   </bean>

   <!--配置效验器-->
   <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
       <property name="providerClass" value="org.hibernate.validator.HibernateValidator"/>
       <property name="validationMessageSource" ref="messageSource"/>
   </bean>

   <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
       <property name="basenames">
           <list>
               <!--一定要加classpath:，不然不能获取，尽管报错-->
               <value>classpath:ValidationMessages</value>
           </list>
       </property>
       <property name="useCodeAsDefaultMessage" value="false"/>
       <property name="defaultEncoding" value="UTF-8"/>
       <property name="cacheSeconds" value="60"/>
   </bean>

   <!--静态资源访问-->
   <mvc:default-servlet-handler></mvc:default-servlet-handler>

   <!--静态资源访问。注意：jetty需要关闭锁定静态资源，才能使用-->
   <!--<mvc:resources location="/static/" mapping="/static/**"/>-->

   <!--自定义视图解析器-->
   <bean id="simpleUrlHandlerMapping" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
       <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>

       <property name="prefix" value="/WEB-INF/jsp/"></property>
       <!--<property name="prefix" value="/WEB-INF/pages/"></property>-->
       <property name="suffix" value=".jsp"></property>
   </bean>

   <!-- 对上传文件的解析-->
   <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>

   <!--启动拦截器-->
   <mvc:interceptors>
       <mvc:interceptor>
           <mvc:mapping path="/**"/>
           <bean class="com.jnshu.interceptor.LoginInterceptor"></bean>
       </mvc:interceptor>
   </mvc:interceptors>

   <!-- json注解适配器 -->
   <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
       <property name="messageConverters">
           <list>
               <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"></bean>
           </list>
       </property>
   </bean>

   <!--全局异常处理器-->
   <bean class="com.jnshu.exception.StudentExceptionResolver"></bean>

</beans>
```



applicationContext.xml 配置文件

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
      xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
      xmlns:context="http://www.springframework.org/schema/context"
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xsi:schemaLocation="
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">



   <!--1. 开启注解-->
   <context:annotation-config />

   <!--组件扫描-->
   <context:component-scan base-package="com.jnshu.service"></context:component-scan>

   <!--2. 引入属性文件，在配置中占位使用 -->
   <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>

   <!--3. 配置数据源-->
   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource" >
       <property name="driverClassName">
           <value>${jdbc_driverClass}</value>
       </property>
       <property name="url">
           <value>${jdbc_url}</value>

       </property>
       <property name="username">
           <value>${jdbc_user}</value>
       </property>
       <property name="password">
           <value>${jdbc_password}</value>
       </property>
   </bean>

   <!--4. 配置会话工厂sqlSessionFactory-->
   <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
       <!--设置别名包-->
       <property name="typeAliasesPackage" value="com.jnshu.pojo" />
       <!--配置数据源-->
       <property name="dataSource" ref="dataSource"/>
       <!--sql映射接口文件路径-->
       <property name="mapperLocations" value="classpath:mapper/*.xml"/>
       <!--配置pagehelper,实现分页-->
       <property name="plugins">
           <array>
               <bean class="com.github.pagehelper.PageInterceptor">
                   <property name="properties">
                       <value>
                       </value>
                   </property>
               </bean>
           </array>
       </property>
   </bean>

   <!--5.扫描对象关系映射-->
   <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
       <!-- 指定要自动扫描接口的基础包，实现接口 -->
       <property name="basePackage" value="com.jnshu.mapper"/>
   </bean>

   <!--配置事务-->
   <tx:annotation-driven transaction-manager="transactionManager"/>
   <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
       <property name="dataSource" ref="dataSource" />
   </bean>

</beans>
```



db.properties 数据库配置文件

```
jdbc_user=root
jdbc_password=admin
jdbc_driverClass=com.mysql.cj.jdbc.Driver
jdbc_url=jdbc:mysql://127.0.0.1:3306/enroll?characterEncoding=UTF-8
```



ValidationMessages.properties 效验器错误提示

```
#添加校验错误提示信息
student.name.length.error=名称至少一位
student.updatetime.isNull=入学日期不能为空
student.course.isNull=所选课程不能为空
student.brother.isNull=辅导师兄不能为空
student.qq.isNull=QQ最小值是10010
```



## 2. 工具类

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/c0511237-d47c-41ed-b1b2-58abcb3ab38a.png)

DateTag 用于页面 jstl时间格式化的工具

```
package com.jnshu.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
* 用于页面 jstl时间格式化s
*/
public class DateTag extends TagSupport {

private String value;

   @Override
   public int doStartTag() throws JspException {
String vv = "" + value;
       try {
long time = Long.valueOf(vv.trim());
           Calendar c = Calendar.getInstance();
           c.setTimeInMillis(time*1000);
           SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
           String s = dateformat.format(c.getTime());
           pageContext.getOut().write(s);
       } catch (Exception e) {
e.printStackTrace();
       }
return super.doStartTag();
   }

public void setValue(String value) {
this.value = value;
   }

}
```

Page 是做分页的工具

```
package com.jnshu.utils;

public class Page {
int start = 0;
   int count = 5;
   int last = 0;

   public int getStart() {
return start;
   }

public void setStart(int start) {
this.start = start;
   }

public int getCount() {
return count;
   }

public void setCount(int count) {
this.count = count;
   }

public int getLast() {
return last;
   }

public void setLast(int last) {
this.last = last;
   }

public void caculateLast(int total){
// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
   if(0 == total % count)
last = total-count;
   else
       // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
       last = total-total%count;
   }
}
```

TimeConvert 时间转换工具，用于将前台输入的String类型时间转为long类型

```
package com.jnshu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//时间转换器，将前台输入的String类型时间转换为long类型
public class TimeConvert implements Converter<String, Long> {
//日志对象
   private static Logger logger = LoggerFactory.getLogger(TimeConvert.class);

   @Override
   public Long convert(String s) {

//设置时间模式
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Long l;

       //将String类型时间转换为long
       try {
if (!s.equals("")) {
l = simpleDateFormat.parse(s).getTime() / 1000;
               return l;
           }else {
logger.error("当前时间为null");
           }
} catch (ParseException e) {
e.printStackTrace();
           logger.error("当前时间格式转换失败");
//            l=null;
       }
//参数绑定失败
       return null;
   }
}
```



## 3. 服务层

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/4cc674c5-9eb9-4a0f-b81d-4e28ccf09145.png)

AuthServiceImpl 用户服务实现类

```
package com.jnshu.service.impl;

import com.jnshu.mapper.IAuthMapper;
import com.jnshu.pojo.Auth;
import com.jnshu.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements IAuthService {

@Autowired
       @Qualifier("IAuthMapper")
IAuthMapper iAuthMapper;

   @Override
   public boolean findAuth(Auth auth) {
return iAuthMapper.findAuth(auth);
   }
}
```

StudentServiceImpl 学生服务实现类

```
package com.jnshu.service.impl;

import com.jnshu.mapper.IStudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

@Autowired
   @Qualifier("IStudentMapper")
IStudentMapper iStudentMapper;

   @Override
   @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public Student findById(int id) {
return iStudentMapper.findById(id);
   }

@Override
   @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public int addStudent(Student student) {
return iStudentMapper.addStudent(student);
   }

@Override
   @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public boolean updateStudent(Student student) {
return iStudentMapper.updateStudent(student);
   }

@Override
   @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public boolean deleteById(int id) {
return iStudentMapper.deleteById(id);
   }

@Override
   @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public List<Student> findAll() {
return iStudentMapper.findAll();
   }
}
```

IAuthService 用户服务层接口

```
package com.jnshu.service;

import com.jnshu.pojo.Auth;

public interface IAuthService {
public boolean findAuth(Auth auth);
}
```

IStudentService 学生服务层接口

```
package com.jnshu.service;

import com.jnshu.mapper.IStudentMapper;
import com.jnshu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IStudentService {

public Student findById(int id);

   public int addStudent(Student student);

   public boolean updateStudent(Student student);

   public boolean deleteById(int id);

   public List<Student> findAll();

}
```



## 4. 实体层



![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/c452f4ac-6a05-4992-9633-8b98aa8f5fb3.png)

Auth 用户实体类

```
package com.jnshu.pojo;

public class Auth {
private String username;
   private String password;

   public String getUsername() {
return username;
   }

public void setUsername(String username) {
this.username = username;
   }

public String getPassword() {
return password;
   }

public void setPassword(String password) {
this.password = password;
   }
}
```

Student 学生实体类

```
package com.jnshu.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
private long s_id;
   //校验名称需大于1
   //message是提示效验出错显示的信息
   @Length(min = 1,message = "{student.name.length.error}")
private String s_name;
   @Range(min = 10010,message = "{student.qq.isNull}")
private long s_qq;
   @Range(min = 1,message = "最小值是1")
private long s_course;
   //非空效验
   @NotNull(message = "不能为null")
private long update_at;
   private String s_school;
   private String s_link;
   private String s_flag;
   @Range(min = 1,message = "最小值是1")
private long s_brother;
   private String s_source;
   @NotNull(message = "不能为null")
private long create_at;

   public long getS_id() {
return s_id;
   }

public void setS_id(long s_id) {
this.s_id = s_id;
   }

public String getS_name() {
return s_name;
   }

public void setS_name(String s_name) {
this.s_name = s_name;
   }

public long getS_qq() {
return s_qq;
   }

public void setS_qq(long s_qq) {
this.s_qq = s_qq;
   }

public long getS_course() {
return s_course;
   }

public void setS_course(long s_course) {
this.s_course = s_course;
   }

public long getUpdate_at() {
return update_at;
   }

public void setUpdate_at(long update_at) {
this.update_at = update_at;
   }

public String getS_school() {
return s_school;
   }

public void setS_school(String s_school) {
this.s_school = s_school;
   }

public String getS_link() {
return s_link;
   }

public void setS_link(String s_link) {
this.s_link = s_link;
   }

public String getS_flag() {
return s_flag;
   }

public void setS_flag(String s_flag) {
this.s_flag = s_flag;
   }

public long getS_brother() {
return s_brother;
   }

public void setS_brother(long s_brother) {
this.s_brother = s_brother;
   }

public String getS_source() {
return s_source;
   }

public void setS_source(String s_source) {
this.s_source = s_source;
   }

public long getCreate_at() {
return create_at;
   }

public void setCreate_at(long create_at) {
this.create_at = create_at;
   }

@Override
   public String toString() {
return "Student{" +
"s_id=" + s_id +
", s_name='" + s_name + '\'' +
", s_qq=" + s_qq +
", s_course=" + s_course +
", update='" + update_at + '\'' +
", s_school=" + s_school +
", s_link='" + s_link + '\'' +
", s_flag='" + s_flag + '\'' +
", s_brother=" + s_brother +
", s_source='" + s_source + '\'' +
", create_at='" + create_at + '\'' +
'}';
   }
}
```



## 5. mapper 映射接口文件

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/d3b8d9a2-c7a5-41b6-937c-3ff0a02cdf4b.png)

IAuthMapper 

```
package com.jnshu.mapper;

import com.jnshu.pojo.Auth;

public interface IAuthMapper {
public boolean findAuth(Auth auth);
}
```

IStudentMapper

```
package com.jnshu.mapper;

import com.github.pagehelper.Page;
import com.jnshu.pojo.Student;

import java.util.List;

public interface IStudentMapper {

public Student findById(int id);

   public int addStudent(Student student);

   public boolean updateStudent(Student student);

   public boolean deleteById(int id);

   public List<Student> findAll();

}
```



## 6. 拦截器（登陆拦截实现）

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/97fe7f01-a705-4764-a9b5-60a7a33eb517.png)



LoginInterceptor 登陆拦截器

```
package com.jnshu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登陆拦截器
public class LoginInterceptor implements HandlerInterceptor {
private static Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

   //执行Handler方法之前执行
   //用于身份认证、身份授权
   //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//获取请求的url
       String url = request.getRequestURI();

       //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)
       //可以导入一个配置文件,匹配其中的请求
       System.out.println("login索引是："+url.indexOf("login"));
       if (url.indexOf("login")>0){
return true;
       }

//判断session
       HttpSession session = request.getSession();
       //从session中取出用户信息
       String username = (String) session.getAttribute("username");
       if (username!=null){
//用户存在放行
           System.out.println("用户放行————————————————————————————————————");
           return true;
       }
String test = "密码错误";
       //执行到这里标识用户身份需要认证,跳转到登陆界面
       //跳转网址需要绝对路径,将当前请求重新映射到/WEB-INF/jsp/login.jsp,
       request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
       logger.info("用户身份需要认证,跳转至登陆页面,执行Handler方法之前执行");

       return false;
   }

//进入Handler方法之后，返回modelAndView之前执行
   //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
   //传到视图，也可以在这里统一指定视图
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
   }

//执行Handler完成执行此方法
   //应用场景：统一异常处理，统一日志处理
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
logger.info("afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
   }
}
```



## 7. 全局异常处理器

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/34174943-60eb-44f1-8b15-9fafb5ac9ef0.png)

StudentException 学生异常信息类

```
package com.jnshu.exception;
//学生异常信息类
public class StudentException extends Exception {

private String message;

   public StudentException(String message) {
super(message);
       this.message = message;
   }

@Override
   public String getMessage() {
return message;
   }

public void setMessage(String message) {
this.message = message;
   }
}
```

StudentExceptionResolver 全局异常处理器

```
package com.jnshu.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*全局异常处理器*/
/*
* 只要实现了HandlerExceptionResolver
* */
public class StudentExceptionResolver implements HandlerExceptionResolver, Ordered {

//    private static final Logger Log = Logger.getLogger(StudentExceptionResolver.class);

   @Override
   public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
StudentException studentException = null;
       if(e instanceof StudentException){
studentException = (StudentException) e;
       }else if (e instanceof HttpMessageNotReadableException){
studentException = new StudentException("参数异常");
       }else {
studentException = new StudentException("未知错误");
       }
ModelAndView mv = new ModelAndView();
       /* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
       FastJsonJsonView view = new FastJsonJsonView();
       Map<String, Object> attributes = new HashMap<>();
       attributes.put("code","1000001");
       attributes.put("msg",studentException.getMessage());

       view.setAttributesMap(attributes);
       mv.setView(view);


       return mv;
   }

/**
    * 异常处理先后顺序.
    *
    * @see org.springframework.core.Ordered#getOrder()
    * 由于SpringMVC默认异常处理机制，如不配置自定义全局异常处理器，则会依次执行如下异常处理器
    *
    * 0 org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver,
    * 1 org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver,
    * 2 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
    */

   @Override
   public int getOrder() {
return 2;
   }
}
```



## 8. 控制层

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/224cb2cd-5223-4345-8639-d7e8f4792fc4.png)

StudentsValidationController 学生效验控制器

```
package com.jnshu.controller.validation;

import com.jnshu.exception.StudentException;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import com.jnshu.utils.TimeConvert;
import javafx.beans.binding.LongBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsValidationController {

@Autowired
   IStudentService iStudentService;

//    局部时间转换
/*    @InitBinder
   protected void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Long.class, new CustomDateEditor(dateFormat, true));
   }*/

   @RequestMapping(value = "/editStudentsSubmit",method = RequestMethod.POST)
public String editStudentsSubmit(Model model, HttpServletRequest request, Integer id, @Validated Student student, BindingResult bindingResult)throws Exception {

List<ObjectError> allErrors = null;
       if (bindingResult.hasErrors()) {

allErrors = bindingResult.getAllErrors();
           for (ObjectError objectError : allErrors) {
System.out.println(objectError.getDefaultMessage());
           }
model.addAttribute("allErrors", allErrors);
           model.addAttribute("stu",student);
           System.out.println("--------进入allErrors----------");
           return "/addStudent";

       }

System.out.println("无错误---------------------");

       iStudentService.addStudent(student);

       return "redirect:/students";
   }
}
```

JsonTestController Json测试控制器

```
package com.jnshu.controller;

import com.jnshu.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {

@RequestMapping(value = "/requestJsonTest",method = RequestMethod.POST)
public @ResponseBody Student requestJsonTest(@RequestBody Student student){
System.out.println("requestJson的student是："+student.toString());
       System.out.println("requestJson 前台传过来的student的名称是："+student.getS_name());
       //@ResponseBody将student转成json格式输出
       return student;
   }

/*跳转到测试页面*/
   @RequestMapping("/jumpJsonTest")
public String jumpJsonTest(){
return "requestJsonTest";
   }

}
```



LoginController 用户登陆控制器

```
package com.jnshu.controller;

import com.jnshu.pojo.Auth;
import com.jnshu.service.IAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class LoginController {

//    日志
   private static Logger logger = LoggerFactory.getLogger(LoginController.class);

   @Autowired
   IAuthService iAuthService;

   @RequestMapping("/login")
public String findAuth(HttpSession session, Auth auth){
if (iAuthService.findAuth(auth)){
session.setAttribute("username",auth.getUsername());
       }
return "redirect:/students";
   }

@RequestMapping("logout")
public String logout(HttpSession session){
session.invalidate();
       return "redirect:/students/login";
   }
}
```



StudentController 学生crud控制器

```
package com.jnshu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.pojo.Student;
import com.jnshu.service.IStudentService;
import com.jnshu.utils.Page;
import com.jnshu.utils.TimeConvert;
import org.apache.ibatis.javassist.runtime.Desc;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

@Autowired
   IStudentService iStudentService;

   //restful风格的增加，并对String格式的时间转为long类型
   @RequestMapping(value = "/students",method = RequestMethod.POST)
public ModelAndView addStudent(Student s,HttpServletRequest request){
/*        String update_at = request.getParameter("update_at");
       TimeConvert timeConvert = new TimeConvert();
       Long u = timeConvert.convert(update_at);
       s.setUpdate_at(u);

       String create_at = request.getParameter("create_at");
       Long c = timeConvert.convert(create_at);
       s.setCreate_at(c);*/

       System.out.println("增加："+s.getS_name());
       iStudentService.addStudent(s);
       ModelAndView mav = new ModelAndView("redirect:/students");
       return mav;
   }

//restful风格的删除
   @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
public ModelAndView deleteStudent(@PathVariable("id") int id){
iStudentService.deleteById(id);
       ModelAndView mav = new ModelAndView("redirect:/students");
       return mav;
   }

//restful风格的获取全部数据并做分页
   @RequestMapping(value = "/students",method = RequestMethod.GET)
public ModelAndView findAll(Page page,@RequestParam(value = "start", defaultValue = "0") int start){
ModelAndView mav = new ModelAndView();
       Sort sort = new Sort(Sort.Direction.DESC, "s_id");
       page.setStart(start=start<0?0:start);
       PageHelper.offsetPage(page.getStart(),5);
       PageHelper.orderBy("s_id DESC");
       List<Student> stus = iStudentService.findAll();
       int total = (int) new PageInfo(stus).getTotal();
       page.caculateLast(total);
       mav.addObject("stus",stus);
       mav.setViewName("listStudents");
       return mav;
   }

//restful风格的更新
   @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
public ModelAndView updateStudent(Student s, HttpServletRequest request){
/*        String update_at = request.getParameter("update_at");
       TimeConvert timeConvert = new TimeConvert();
       Long u = timeConvert.convert(update_at);
       s.setUpdate_at(u);

       String create_at = request.getParameter("create_at");
       Long c = timeConvert.convert(create_at);
       s.setCreate_at(c);*/
       iStudentService.updateStudent(s);
       System.out.println(s.getS_name());
       ModelAndView mav = new ModelAndView("redirect:/students");
       return mav;
   }

//restful风格的编辑，需要先获取，然后编辑
   @RequestMapping(value = "/students/{id}",method = RequestMethod.GET)
public ModelAndView editStudent(@PathVariable("id") int id, HttpServletRequest request){
Student s = iStudentService.findById(id);
       ModelAndView mav = new ModelAndView("editStudent");
       mav.addObject("s",s);
       return mav;
   }

//测试jsp页面的json数据方法
   @RequestMapping("/testJson")
public ModelAndView tJson(Student student){
student.setS_id(123);
       student.setCreate_at(20190506);
       student.setS_source("知乎");
       student.setS_flag("try hard");
       student.setS_school("家里蹲大学");
       student.setS_course(1);
       student.setS_qq(12345);
       student.setS_name("王二");
       student.setS_brother(1);
       student.setUpdate_at(20190506);
       student.setS_link("www.jnshu.com");
       List<Student> students = new ArrayList<>();
       students.add(student);
       ModelAndView mav = new ModelAndView("testJson","stu",students);

//      测试jsp页面的json数据方法二
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("1",student);
//        ModelAndView mav = new ModelAndView("testJson","stu",student);

//      测试jsp页面的json数据方法三
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(student);
//        ModelAndView mav = new ModelAndView("testJson","stu",jsonArray);
       return mav;
   }

//测试返回页面
   @RequestMapping("/test")
public String test2(){
return "index2";
   }

//增加学生
   @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
public String addStudent2(){
return "addStudent";
   }

}
```

## 9. 前台页面

![img](http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/daily/8a5d229a-8799-40bd-b157-90c109452496.png)

addStudent 学生增加页面，不过不是标准的restful风格

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
   <title>addStudent</title>
</head>
<body>

<c:if test="${allErrors!=null}">
<c:forEach items="${allErrors}" var="error">
${error.defaultMessage}
   </c:forEach>
</c:if>

<div style="align-content: center; margin-top: 40px">
   <form method="post" action="${pageContext.request.contextPath}/students/editStudentsSubmit">
       学员名称：<input name="s_name" value="" type="text"><br>
       QQ：<input name="s_qq" value="" type="text"><br>
       修真类型：<input name="s_course" value="" type="text"><br>
       入学时间：<input name="update_at" value="" type="text"><br>
       毕业院校：<input name="s_school" value="" type="text"><br>
       日报链接：<input name="s_link" value="" type="text"><br>
       flag：<input name="s_flag" value="" type="text"><br>
       辅导师兄：<input name="s_brother" value="" type="text"><br>
       了解来源：<input name="s_source" value="" type="text"><br>
       创建时间：<input name="create_at" value="" type="text"><br>

       <input type="submit" value="增加学员">
   </form>
</div>

</body>
</html>
```

editStudent 学生编辑页面

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<html>
<head>
   <title>editStudent</title>
</head>
<body>

<c:if test="${allErrors!=null}">
<c:forEach items="${allErrors}" var="error">
${error.defaultMessage}
       <br>
   </c:forEach>
</c:if>

<div style="width: 500px;margin: 0px auto;text-align: center">
   <div style="text-align: center;margin-top:40px">
       <%--注意：form 下增加 filed, 虽然这个form的method是post, 但是springmvc看到这个_method的值是put后，会把其修改为put.--%>
       <form method="post" action="${pageContext.request.contextPath}/students/${s.s_id}">
           <input type="hidden" name="_method" value="PUT">
           学号：<input name="s_id" value="${s.s_id}" type="text"><br><br>
           学员名称：<input name="s_name" value="${s.s_name}" type="text"><br><br>
           QQ：<input name="s_qq" value="${s.s_qq}" type="text"><br><br>
           修真类型：<input name="s_course" value="${s.s_course}" type="text"><br><br>
           <%--入学时间：<input name="update_at" value="${s.update_at}" type="text">--%>
           入学时间：<input name="update_at" value="<date:date value="${s.update_at}"></date:date>"  type="text">
           <%--<br><br>--%>
           <%--<jsp:useBean id="dateValue"            <%--<jsp:setProperty name="dateValue" property="time" value="${s.update_at}"/>--%>
           <%--入学时间：<input name="update_at" value=<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss"/> type="text">--%>
           <br><br>

           毕业院校：<input name="s_school" value="${s.s_school}" type="text"><br><br>
           日报链接：<input name="s_link" value="${s.s_link}" type="text"><br><br>
           flag：<input name="s_flag" value="${s.s_flag}" type="text"><br><br>
           辅导师兄：<input name="s_brother" value="${s.s_brother}" type="text"><br><br>
           了解来源：<input name="s_source" value="${s.s_source}" type="text"><br><br>

           <%--创建时间：<input name="create_at" value="${s.create_at}" type="text">--%>
           创建时间：<input name="create_at" value="<date:date value="${s.create_at}"></date:date>" type="text">

           <%--<br><br>--%>
           <%--<jsp:useBean id="dateValue1"            <%--<jsp:setProperty name="dateValue1" property="time" value="${s.create_at}"/>--%>
           <%--创建时间：<input name="create_at" value=<fmt:formatDate value="${dateValue1}" pattern="yyyy-MM-dd hh:mm:ss"/> type="text">--%>
           <br><br>
           <input type="submit" value="修改学员">
       </form>
   </div>
</div>

</body>
</html>
```

listStudents 学生清单页面

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<html>
<head>
   <title>students</title>
</head>
<body>

<script type="text/javascript" src="/js/jquery.min.js"></script>

<script type="text/javascript">
   /*将post method 改变为delete*/
   $(function(){
$(".delete").click(function () {
var href =$(this).attr("href");
       $("#formdelete").attr("action",href).submit();
       return false;
   })
})

</script>

<%-- 登陆模块 --%>
当前用户:${username }|
<c:if test="${username!=null }">
<a href="${pageContext.request.contextPath }/students/logout">退出</a>
   <hr>
</c:if>

<div style="margin:0px auto;text-align:center ">
   <table align="center" border="1" cellpadding="0" width="100%">
       <tr>
           <td>线上学号</td>
           <td>姓名</td>
           <td>QQ</td>
           <td>修真类型</td>
           <td>入学时间</td>
           <td>毕业院校</td>
           <td>日报链接</td>
           <td>flag</td>
           <td>辅导师兄</td>
           <td>了解来源</td>
           <td>创建时间</td>
           <td>编辑</td>
           <td>删除</td>
       </tr>
       <c:forEach items="${stus}" var="s" varStatus="st">
<tr>
               <td>${s.s_id}</td>
               <td>${s.s_name}</td>
               <td>${s.s_qq}</td>
               <td>${s.s_course}</td>
               <td><date:date value="${s.update_at}"></date:date></td>
               <%--<td>${s.update_at}</td>--%>
               <%--<td>--%>
                   <%--<jsp:useBean id="dateValue"                    <%--<jsp:setProperty name="dateValue" property="time" value="${s.update_at}"/>--%>
                   <%--<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss"/>--%>
               <%--</td>--%>
               <td>${s.s_school}</td>
               <td>${s.s_link}</td>
               <td>${s.s_flag}</td>
               <td>${s.s_brother}</td>
               <td>${s.s_source}</td>
               <%--第一种方式将long类型的时间转换为格式化时间--%>
               <td><date:date value="${s.create_at}"></date:date></td>
               <%--<td>${s.create_at}</td>--%>
               <%--<td>--%>
               <%--第二种方式将long类型的时间转换为格式化时间--%>
                   <%--<jsp:useBean id="dateValue1"                    <%--<jsp:setProperty name="dateValue1" property="time" value="${s.create_at}"/>--%>
                   <%--<fmt:formatDate value="${dateValue1}" pattern="yyyy-MM-dd hh:mm:ss"/>--%>
               <%--</td>--%>
               <td><a href="students/${s.s_id}">编辑</a></td>
               <td><a "delete" href="students/${s.s_id}">删除</a></td>

           </tr>
       </c:forEach>

</table>
   <div style="align-content: center">
       <a href="?start=0">首 页</a>
       <a href="?start=${page.start-page.count}">上一页</a>
       <a href="?start=${page.start+page.count}">下一页</a>
       <a href="?start=${page.last}">末 页</a>
   </div>
   <br>
   <div style="text-align: left">
       <form method="post" action="addStudent">
           第一种方式跳转增加+后台验证：<input type="submit" value="增加学员">
       </form>
   </div>

   <br>

   <div style="align-content: center; margin-top: 40px;text-align: left">
       <form method="post" action="students" >
           学员名称：<input name="s_name" value="" type="text"><br>
           QQ：<input name="s_qq" value="" type="text"><br>
           修真类型：<input name="s_course" value="" type="text"><br>
           入学时间：<input name="update_at" value="" type="text"><br>
           毕业院校：<input name="s_school" value="" type="text"><br>
           日报链接：<input name="s_link" value="" type="text"><br>
           flag：<input name="s_flag" value="" type="text"><br>
           辅导师兄：<input name="s_brother" value="" type="text"><br>
           了解来源：<input name="s_source" value="" type="text"><br>
           创建时间：<input name="create_at" value="" type="text"><br>

           第二种方式增加标准的restful：<input type="submit" value="增加学员">
       </form>
   </div>
   <br>

</div>

<%--这个form的method是post, 但是springmvc看到这个_method的值是DELETE后，会把其修改为DELETE.--%>
<form id="formdelete" action="" method="post">
   <input type="hidden" name="_method" value="DELETE">
</form>
</body>
</html>
```

login.jsp 登陆页面

```
<%@ page  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>系统登陆</title>
</head>
<body>
${test}
<form style="text-align: center" action="${pageContext.request.contextPath }/students/login" method="post">
   用户账号:<input type="text" name="username"/><br/>
   用户密码:<input type="password" name="password"/><br/>
   <input type="submit" value="登录"/>
</form>
</body>
</html>
```

requestJsonTest.jsp 测试json的页面

```
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
   <title>json测试</title>

   <script type="text/javascript" src="/js/jquery.min.js"></script>
   <script type="text/javascript">
       function requestJson() {
$.ajax({
type:"post",
               url:"${pageContext.request.contextPath}/requestJsonTest",
               contentType:"application/json;charset=utf-8",
               // dataType:"json",
               data:'{"s_id":"2005000","s_name":"jack","s_qq":"10010","s_course":"1","update_at":"123154563", "s_school":"大学","s_link":"www.w3cshool.com","s_flag":"努力","s_brother":"1","s_source":"百度","create_at":"11231212"}',
               success:function (data) {
alert(data);
               }
});
       }

</script>
</head>
<body>

<input type="button" onclick="requestJson()" value="requestJsonTest请求json,输出json">
</body>
</html>
```



testJson.jsp 测试使用taglib假数据伪造json数据

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<body>
<json:array var="s" items="${stu}">
<json:object>
<json:property name="s_id" value="${s.s_id}"></json:property>
<json:property name="s_name" value="${s.s_name}"></json:property>
<json:property name="s_qq" value="${s.s_qq}"></json:property>
<json:property name="s_course" value="${s.s_course}"></json:property>
<json:property name="update_at" value="${s.update_at}"></json:property>
<json:property name="s_school" value="${s.s_school}"></json:property>
<json:property name="s_link" value="${s.s_link}"></json:property>
<json:property name="s_flag" value="${s.s_flag}"></json:property>
<json:property name="s_brother" value="${s.s_brother}"></json:property>
<json:property name="s_source" value="${s.s_source}"></json:property>
<json:property name="create_at" value="${s.create_at}"></json:property>
</json:object>
</json:array>

</body>
```

userList.jsp 用户登陆模块

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false" %>

<%-- 登陆模块 --%>
当前用户:${username }|
<c:if test="${username!=null }">
<a href="${pageContext.request.contextPath }/logout">退出</a>
   <hr>
</c:if>
```

datetag.tld 格式转换标签库

```
<?xml version="1.0" encoding= "UTF-8"?>
<taglib>
   <tlib-version>1.0</tlib-version>
   <jsp-version>1.2</jsp-version>

   <short-name>date</short-name>

   <tag>
       <name>date</name>
       <tag-class>com.jnshu.utils.DateTag</tag-class>
       <body-content>JSP</body-content>
       <attribute>
           <name>value</name>
           <required>true</required>
           <rtexprvalue>true</rtexprvalue>
       </attribute>
   </tag>
</taglib>
```



## 10. web.xml 配置

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
       version="2.5"
       metadata-complete="true">

<!--<!DOCTYPE web-app
       PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
       "http://java.sun.com/dtd/web-app_2_3.dtd">-->
       <!--resin需要使用上面的头-->

<!--<web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">-->


 <display-name>Archetype Created Web Application</display-name>

   <!--中文问题处理，需放在顶部-->
   <filter>
       <filter-name>encodingFilter</filter-name>
       <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
       <init-param>
           <param-name>encoding</param-name>
           <param-value>utf-8</param-value>
       </init-param>
       <init-param>
           <param-name>forceEncoding</param-name>
           <param-value>true</param-value>
       </init-param>
   </filter>
   <filter-mapping>
       <filter-name>encodingFilter</filter-name>
       <url-pattern>/*</url-pattern>
   </filter-mapping>

   <!--log4j2的配置文件-->
   <!-- log4j2-begin -->
   <listener>
       <listener-class>org.apache.logging.log4j.web.Log4jServletContextListener</listener-class>
   </listener>
   <filter>
       <filter-name>log4jServletFilter</filter-name>
       <filter-class>org.apache.logging.log4j.web.Log4jServletFilter</filter-class>
   </filter>
   <filter-mapping>
       <filter-name>log4jServletFilter</filter-name>
       <url-pattern>/*</url-pattern>
       <dispatcher>REQUEST</dispatcher>
       <dispatcher>FORWARD</dispatcher>
       <dispatcher>INCLUDE</dispatcher>
       <dispatcher>ERROR</dispatcher>
   </filter-mapping>
   <!-- log4j2-end -->

<!--    <context-param>
       <param-name>log4jConfigLocation</param-name>
       <param-value>classpath:/log4j2.xml</param-value>
   </context-param>-->

 <!-- 加载spring容器-->
 <context-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>classpath:applicationContext.xml</param-value>
 </context-param>
 <listener>
   <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 </listener>

 <!--加载springMVC前端控制器-->
 <servlet>
   <servlet-name>springmvc</servlet-name>
   <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   <init-param>
     <param-name>contextConfigLocation</param-name>
     <param-value>classpath:springmvc-servlet.xml</param-value>
   </init-param>
   <load-on-startup>1</load-on-startup>
 </servlet>
 <servlet-mapping>
   <servlet-name>springmvc</servlet-name>
   <url-pattern>/</url-pattern>
 </servlet-mapping>

 <!--springMVC还原对put和delete的处理,原SpringMVC 只能处理post和get-->
   <filter>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
   </filter>
   <filter-mapping>
       <filter-name>HiddenHttpMethodFilter</filter-name>
       <url-pattern>/*</url-pattern>
   </filter-mapping>

   <!--配置默认页面-->
 <welcome-file-list>
   <welcome-file>/WEB-INF/jsp/login.jsp</welcome-file>
 </welcome-file-list>

   <!--jsp自定义tags，前端时间格式转换-->
 <jsp-config>
   <taglib>
     <taglib-uri>/tags</taglib-uri>
     <taglib-location>/WEB-INF/tld/datetag.tld</taglib-location>
   </taglib>

   <!--EL表达式支持默认设置-->
   <jsp-property-group>
     <url-pattern>*.jsp</url-pattern>
     <el-ignored>false</el-ignored>
   </jsp-property-group>
 </jsp-config>

</web-app>
```
