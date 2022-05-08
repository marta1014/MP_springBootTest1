# MP_springBootTest1

## boot工程依赖该maven插件打包

### 对应路径下执行target下的jar即可

#### java -jar demoBatis-0.0.1-SNAPSHOT.jar

```xml

<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
</build>

```

### 补充附加属性

- 如果需要临时更改端口
- template
- java -jar demoBatis-0.0.1-SNAPSHOT.jar -- server.port=8090 ... --spring.datasource.druid.=....

#### 临时属性会覆盖原本的yml配置 需要注意


```java
// begin
public static void main(String[] args) {
        SpringApplication.run(DemoBatisApplication.class, args);
}
// after 不携带参数启动boot程序 为了安全性

public static void main(String[] args) {
        SpringApplication.run(DemoBatisApplication.class);
}

```

#### 关于配置文件分类

- 常用四级分类对应操作权限
- spring boot中的四级文件
- 1级 file config/applacation.yml
- 2级 file application.yml
- 3级 classpath config/application.yml
- 4级 classpath application.yml
- -
- 1级、2级留作系统打包设置通用属性 常用于运维经理进行线上项目部署调控
- 3级 项目经理使用调控
- 4级 开发阶段设置通用属性

## 多环境配置 详见application.yml
