# Selenium java test automation framework

Automation framework written in java with jUnit and Selenium Webdriver.
Easy to use through the reflection to initialize most important instances (like driver, pages and steps).

# Dependencies

- [Java 1.8+](https://openjdk.org/projects/jdk8/) - as a programming language
- [jUnit5](https://junit.org/junit5/) - as a testing framework and test runner for Java
- [Selenium Webdriver](https://www.selenium.dev) - as an automation tool with Java language bindings
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/) - as an open-source library that carries out the driver management
- [Hamcrest](https://hamcrest.org/JavaHamcrest/) - as a flexible assertion framework
- [Owner](http://owner.aeonbits.org/docs/usage/) - as a library for easy managing property files
- [Extent report](https://www.extentreports.com) - as a reporting tool
- [Maven](https://maven.apache.org) - as a Java build tool
- [Docker](https://www.docker.com) - as a platform to run tests in containers with various browsers 
- [Docker images](https://github.com/SeleniumHQ/docker-selenium) for Selenium grid
- [Faker](https://github.com/DiUS/java-faker) - as a testing data generator 

# Project structure

## infrastructure
The project offers to use docker platform for launching tests locally on various browsers. 
Infrastructure consist of docker-compose.yml file for managing and creating docker containers
both with browser-standalone instance and selenium hub. For more details please read on [Docker-selenium github](https://github.com/SeleniumHQ/docker-selenium), 
[yml and compose-file](https://docs.docker.com/compose/compose-file/) documentation.

## annotations
This is annotations for instances, that need to be initialized in project files. Basically implemented
for:
- driver
- page
- steps 

instances with injection mechanism. The realisation itself is in reflection directory.

## browsers
Factory for browser driver instance. Use singleton pattern for get only one driver instance.

## extensions
Part of JUnit5 feature to organize testing flow in a flexible way. Basically in project consist of:
- lifecycle extension to initialize and manage driver, page and steps instances
- extension for organize reporting with screenshoting on fail
- extension to make screenshots on fail and store them in folder (screenshot directory can be changed
in config.properties file)

## matchers
As a part of Hamcrest library, you can add your own custom matchers for more flexible, universal assertion mechanism.
As an example there is a matcher for checking is element is clickable implemented in the project. 

## page
Framework based on Page Object Model pattern. All the elements are stored in pages classes. The example
is shown with MainPage.class.

## report
Consist of a report configurator where you can set up such parameter like 
report theme, title etc.

## steps
Contains of steps file - methods which faced often in the tests and can be reused.

## util
Has two directories:
- props - interface of properties to easily interact with props with owner library help. You can also add some default values for them in this file.
- reflection - consist of Injector file, which implement reflection mechanism for all field in class
and SubjectProvider class, which help to get instance to inject for. For instance, if you have annotation @Driver - you need inject driver inctance,
if you have annotation @Page - you need inject instance of page on some Test or Steps class.

## resources
Has properties for the project. You can manage if start tests locally or in the docker containers (local.run), change directory for screenshots (screenshots.dir), url of sut (base.url), path for reporting (base.report.path).
You can also add more properties, but don't forget to add them in util/props/ConfigProp file.


