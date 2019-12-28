# CafeTownsend Automated Testing

This project is developed for automated testing of the web site - http://cafetownsend-angular-rails.herokuapp.com/

## Test Approach

The project is developed using Java and Selenium Automation Framework. TestNG is used as the testing framework.

Page Object Model (POM) design pattern is used to separate the WebElements, Page Methods and the Test execution.

For the test execution, tests are independent and can be run individually as well as all together.
This is done to make it simple to run individual tests.

Following test cases have been executed

| Sr No  | Test Case Description |Method|
| ------ | ------------- |--------------|
| 1| Invalid Login - Incorrect Username, Correct Password|invalidLogin()|
| 2| Invalid Login - Correct Username, Incorrect Password|invalidLogin()|
| 3| Invalid Login - Correct Username, Blank Password|invalidLogin()|
| 4| Invalid Login - Blank Username, Correct Password|invalidLogin()|
| 5| Valid Login|validLogin()|
| 6| Invalid Create Employee - Invalid Last Name|invalidCreateEmployee()|
| 7| Invalid Create Employee - Invalid First Name|invalidCreateEmployee()|
| 8| Invalid Create Employee - Invalid Start Date|invalidCreateEmployee()|
| 9| Invalid Create Employee - Invalid Email|invalidCreateEmployee()|
| 10| Create Employee|createEmployee()|
| 11| Update Employee|updateEmployee()|
| 12| Delete Employee|deleteEmployee()|
| 13| Logout|correctLogou()|


## Pre-requisites
### For Windows OS

__Step 1:Install JDK and set Java home__

Follow instructions [here](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/) 

__Step 2: Install Maven 3.0.3+__

[Download from here](http://maven.apache.org/download.html)

__Step 3: Ensure maven binaries are on your PATH (ie. you can run `mvn` from anywhere)__

Follow the installation instructions from [here](http://www.baeldung.com/install-maven-on-windows-linux-mac).

### For Mac OS
__Step 1:Install JDK__

Follow instructions [here](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-F575EB4A-70D3-4AB4-A20E-DBE95171AB5F) 

__Step 2: Install Maven with below command__

brew install maven

## Running Tests
1. Clone/Download the project from this repository

2. Navigate to the folder Cafetownsend using terminal

3. To execute the complete test suite, run the following command
```
mvn test
``` 
3. To execute individual tests eg Delete Employee, run the following command
```
mvn test -Dtest=TestExecution#deleteEmployee
``` 

## WebDriver Manager
The [Webdriver](https://github.com/bonigarcia/webdrivermanager) is used to remove the dependency of requiring browser binary
 files for test execution.