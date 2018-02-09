# codegen4odps
一款自定义模版的ODPS表转java pojo的ORM代码生成工具

# 快速入门

## clone代码

````
git clone git@github.com:YaoLin1/codegen4odps.git
````

## 编译

在codegen4odps目录下执行编译命令

````
mvn clean package -DskipTests=true
````

## 修改jdbc配置，目前仅支持mysql

````
修改配置文件 /codegen4odps/src/main/resources/codegen4odps.properties

内容

outputdir=./output/   #输出目录，必填

accessId=*****        #你的阿里云accessId，必填

accessKey=*****       #你的阿里云accessKey，必填

odpsUrl=http://service.odps.aliyun.com/api #你的阿里云url，必填

project=test_project  #odps工程名，对应数据库名

packname=             #应用包名，可不填

tableNamePrefix=s_   #表前缀，可不填

tablename=s_body,s_user_patient_info #待生成表名列表，以逗号分割

author=JianLin.Zhu    #作者名，可不填

````
## 运行codegen4odps/CodeGenMain.java 

日志


>start deal template:DomainTemplate.java
 finish DomainTemplate.java
 start deal template:SqlMapTemplate.xml
 finish SqlMapTemplate.xml
 start deal template:Domain2RecordTemplate.java
 finish Domain2RecordTemplate.java
 start deal template:Record2DomainTemplate.java
 finish Record2DomainTemplate.java

>Process finished with exit code 0

## 查看生成文件
默认在codegen4odps/output/odps目录下文件，多次生成会覆盖原有代码
