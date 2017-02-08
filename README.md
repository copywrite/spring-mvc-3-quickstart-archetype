Spring MVC 3 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 3 web application.

Forked and modified from https://github.com/kolorobot/spring-mvc-quickstart-archetype.

Generated project characteristics
-------------------------
* JPA (iBatis)
* JUnit/Mockito

Prerequisites
-------------

- JDK 7
- Maven 3

Install archetype locally
-------------------------

To install the archetype in your local repository execute the following commands:

```bash
    git clone https://github.com/kolorobot/spring-mvc-quickstart-archetype.git
    cd spring-mvc-quickstart-archetype
    mvn clean install
```

Create a project
----------------

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=pl.codeleak \
        -DarchetypeArtifactId=spring-mvc-quickstart \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version \
        -DarchetypeRepository=http://kolorobot.github.io/spring-mvc-quickstart-archetype
```

Note: The above command will bootstrap a project using the archetype published here: http://kolorobot.github.io/spring-mvc-quickstart-archetype

Run the project
----------------

Navigate to newly created project directory (`my-artifactId`) and then run:

```bash
	mvn test tomcat7:run
```

Test in the browser
-------------------

	http://localhost:8080/

Note: No additional services are required in order to start the application. Mongo DB configuration is in place but it is not used in the code.

Create a new project in IntelliJ
--------------------------------

* Create new project `File > New > Project`
* Click Maven on the left hand side of the new project dialog
* Check `Create from archetype`
* Click the `Add Archetype` button
* Set `Group Id` to `pl.codeleak`
* Set `Artifact Id` to `spring-mvc-quickstart`
* Set `Version` to `1.0.0`
* Set `Repository` to `http://kolorobot.github.io/spring-mvc-quickstart-archetype`
* Click next and create the project
