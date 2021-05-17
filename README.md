![](https://scontent.flim18-2.fna.fbcdn.net/v/t1.6435-9/186528686_10222580482355299_394961392705780329_n.jpg?_nc_cat=111&ccb=1-3&_nc_sid=730e14&_nc_eui2=AeHZ73aBlQYCqX6T-dpWpUjNay9pIDRrwdNrL2kgNGvB0ywgKFR3ynt63T8OwoXBVo8&_nc_ohc=Lj-RJPHrM48AX9ReOvK&_nc_ht=scontent.flim18-2.fna&oh=0cb5dd15617ed6c748d369f04e064576&oe=60C61438)

![](https://img.shields.io/github/release/pandao/editor.md.svg)  ![](https://github.com/webdriverio/cucumber-boilerplate/actions/workflows/test.yaml/badge.svg)

##Login challenge for SwagLabs
This repository contains a sample selenium-based project that demonstrate how to use the tool and develop automation script using the Cucumber BDD framework. This project uses ChromeDriver, GeckoDriver or MSEdgeDriver to communicate with the browser directly.

It supports Java 8 and generate json or html reports as well.

###Installation

Node.JS: Install from the site - https://nodejs.org/en/ take the LTS version based on your Operating system. Please make sure you install NodeJS globally.

JDK 1.8: It's mandatory, install JDK 1.8+ and make sure class path is set properly. JAVA is require to start Selenium Server on your local environment nothing else.

###Selenium

To run your test you must have some dependencies in the pom.xml file, or it will fail fast with an error. This file has JUnit, Cucumber Junit, Cucumber Java and Selenium Java dependencies.

###Run Some Sample Tests

To execute the entire test suite in local development, you only need to use IntelliJ IDEA and execute "Run Test". This executes all features in the `src/test/resources/feature/*.feature` directory.

###The Hook

This project uses hooks to setup and execute tests in specific ways. The configuration is fully customizable, and different functions can be invoked before, during and after each test or test suite. Hooks file can be found in the `src/test/java/definitions/hooks` directory.

###Reporters

This project uses one test reporter to communicate pass/failure.

#####Multiple Cucumber HTML Reporter

This reporter creates a test reports which is an HTML generated website with all necessary information to debug your test results and take a look on error screenshots. Install Cucumber HTML Reporter running in the console `npm install multiple-cucumber-html-reporter --save-dev`

To generate and view a report locally, run `npm run report`. A typical report will look like this
[![asd](asd "asd")](https://scontent.flim18-3.fna.fbcdn.net/v/t1.6435-9/186511826_10222581267894937_7497532566323454025_n.jpg?_nc_cat=110&ccb=1-3&_nc_sid=730e14&_nc_eui2=AeF5UUnwocEx5cEPQ8uxPJ0d11k7GqVDxyPXWTsapUPHI6zI0J6sqVavXoTZZR_Mzy0&_nc_ohc=IjVj6BOn0e0AX9wrmjs&_nc_ht=scontent.flim18-3.fna&oh=6e1a17597990c4bdb56f3df17dc161be&oe=60C8C343 "asd")

You can view the documentation [here](https://www.npmjs.com/package/multiple-cucumber-html-reporter "here").

###Develop automation scripts
You can write test by using Cucumber BDD framework.

Tests are written in the Cucumber framework using the Gherkin Syntax. More about Gherkin & Cucumber can be found at https://cucumber.io/docs/reference

Tests are place in `*.feature`  files in the `src/test/resources/feature`directory. A typical test will look similar to this:


    Feature: Performing a Yahoo Search

    As a user on the Yahoo search page
    I want to search for Selenium-Webdriver
    Because I want to learn more about it

    Background:

        Given I am on the search page

    Scenario: Performing a search operation
        When I enter "Selenium Webdriver" into the search box
        And  I click the search button
        Then I should see a list of search results

    Scenario Outline: Performing a search operation with passing test data as data table
        When I enter <searchItem> into the search box
        And  I click the search button
        Then I should see a list of search results

        Examples:
        |searchItem|
        |"Selenium Webdriver"|

###The Page Object Design Pattern
Within your web app's UI there are areas that your tests interact with. A Page Object simply models these as objects within the test code. This reduces the amount of duplicated code and means that if the UI changes, the fix need only be applied in one place. In other wards one of the challenges of writing test automation is keeping your [selectors] (classes, id's, or xpath' etc.) up to date with the latest version of your code. The next challenge is to keep the code you write nice and DRY (Don't Repeat Yourself). The page object pattern helps us accomplish this in one solution. Instead of including our selectors in our step definitions in cucumber, we instead place them in a `<pagename>.java`  file where we can manage all these selectors and methods together. Your test file should only call the test methods.

You can also place reusable functions or logic inside of these pages and call them from your step files. The page object serves as a layer of abstraction between tests and code. When a test fails, it fails on a individual step. That step may call a selector that is no longer valid, but that selector may be used by many other steps. By having a single source of truth of what the selector is supposed to be, fixing one selector on the page object could repair a number of failing tests that were affected by the same selector.

An object called `Page` will be created with the prototype model. This ensures that every instance of a page object is exported as a stateless construct. Any any changes to that state are handled in the browser, rather than on the server.

It is preferable to separate page objects into individual files that end with `Page.java`. These will require the basic page.js prototype construct / abstract class and create new objects for each individual page.

For more information on the implementation of `Page Object Design Pattern`, refer to the `src/test/java/pageobjects` directory. 