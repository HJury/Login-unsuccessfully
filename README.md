# PracticaTecnica 

This project uses TestNG as a testing framework, applying cross-browsing(Chrome and Firefox) as we can see on the file located on: 

	../testng.xml


This project has 4 abstraction layers called: 
*	Features
*	StepDefinitions
*	Tasks
*	Page Object

Each layer has a higher detail level than the former to make it easier to give maintain to the code.

# You need
In order to run your tests, you will need:
*	Java 1.8 (Don't forget to add java to environment variables)
*	Chrome 84.0.4148.xx
*	Firefox 78.0.2
*   	Maven

# Feature 
The feature is located on: 

	../src/test/resource/funtionalTestFeatures/Login.feature

# Running the tests
For the tests to be executed all the new scenarios within the features should have the tag "@EXECUTE".
You should navigate towards the root project directory and run the following command:

	mvn clean test

that will make the scenarios within the features to run.

#Reports
The former command will run the tests and generates a report using the ExtentReports library, this report will keep the gherkin syntax of the scenarios as well as the respective result of each one. The report will be generated on the directory:

	../test-output/HtmlReport/AutomationExtentHtml.html

The name of the scenarios will be duplicated due to the cross-browsing, so, each scenario runs twice, once for each scenario.
