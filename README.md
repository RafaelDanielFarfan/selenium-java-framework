# Selenium Java Automation Framework

A Maven + Selenium + TestNG framework with:

- Page Object Model
- ThreadLocal WebDriver for parallel execution
- TestNG DataProvider
- Excel DDT with Apache POI
- application.properties configuration
- Allure reporting and failure screenshots
- Chrome, Edge and Firefox support

## Requirements

- JDK 25
- Maven 3.9+
- Chrome/Edge/Firefox installed as needed

Selenium Manager handles browser driver management.

## Run

Default:

    mvn clean test

Override properties without changing the file:

    mvn clean test -Dbrowser=chrome -Dheadless=true

Other examples:

    mvn clean test -Dbrowser=firefox
    mvn clean test -Dbrowser=edge

## Allure

Install the Allure CLI separately, then:

    allure serve target/allure-results

or:

    allure generate target/allure-results -o target/allure-report --clean
    allure open target/allure-report

## Parallelism

Parallelism is configured in `testng.xml`:

    parallel="methods" thread-count="3"

The framework creates one WebDriver per TestNG thread using `ThreadLocal`.

## DDT

`LoginTest` demonstrates an in-code DataProvider.
`ExcelLoginTest` demonstrates Excel-based DDT from:

    src/test/resources/testdata/testdata.xlsx

The sample Excel file is generated separately because binary files are not represented in this source listing.
