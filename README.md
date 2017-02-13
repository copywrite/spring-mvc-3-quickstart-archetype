Spring MVC 3 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 3 web application.

Forked and modified from https://github.com/kolorobot/spring-mvc-quickstart-archetype.

Generated project characteristics
-------------------------
* JPA (iBatis)
* Redis

Prerequisites
-------------

- JDK 7
- Maven 3

Install archetype locally
-------------------------

To install the archetype in your local repository execute the following commands:

```bash
    git clone git@github.com:copywrite/spring-mvc-3-quickstart-archetype.git
    cd spring-mvc-3-quickstart-archetype
    mvn clean install
```

Create a project
----------------

```bash
    mvn archetype:generate -DarchetypeGroupId=com.copywrite
                           -DarchetypeArtifactId=spring-mvc-3-quickstart
                           -DarchetypeVersion=1.0.0
                           -DgroupId=m1
                           -DartifactId=m1
                           -Dversion=1.0.0
                           -DarchetypeRepository=https://github.com/copywrite/spring-mvc-3-quickstart-archetype
```

Note: The above command will bootstrap a project using the archetype published here: https://github.com/copywrite/spring-mvc-3-quickstart-archetype

Setup prerequisites
----------------
1. mysql

    1.1 brew install mysql

    1.2 mysql.server start

    1.3 create a new database named hello

    1.4 create a new table by the following sql:

        CREATE TABLE `user` (
          `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
          `name` varchar(32) NOT NULL DEFAULT '' COMMENT 'name',
          `password` varchar(32) DEFAULT '' COMMENT 'password',
          `salt` varchar(32) DEFAULT NULL COMMENT 'salt',
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    1.5 add a test data row

        INSERT INTO `user` (`id`, `name`, `password`, `salt`)
        VALUES
        	(0, 'homer', '6960aa7549c3f508dbbae1c405a0a14c', 'fj76scZ%jAd.3AscJDJCDW.wUb/dx6Qq');
2. Redis

    1.1 brew install redis

    1.2 start the service: redis-server /usr/local/etc/redis.conf&

Run the project in Intellij
----------------
1. Run -> Edit Configurations
2. Add new Configuration
3. Add a local Tomcat Server
4. Start run or debug

Test in the browser
-------------------

	http://localhost:8080/

	or

	http://localhost:8080/?username=homer&password=strong

Note: Should not use this authentication mechanism in production, Plaintext password in queryString is not secure.
