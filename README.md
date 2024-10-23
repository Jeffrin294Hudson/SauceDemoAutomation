Sauce Demo Cucumber Project

Git Repo link: https://git.epam.com/jeffrin_hudson/saucedemo.git

Overview
This project implements automated testing for the Sauce Demo web application using the Cucumber framework. It leverages behavior-driven development (BDD) practices to ensure consistent and comprehensive testing of user interfaces and functionalities.

Technologies Used


Cucumber: BDD framework for writing clear and concise test specifications.

Selenium: Tool for automating web browsers.

Java: Programming language used to implement test logic.

Maven: Dependency management and project build tool.


Getting Started

Prerequisites
Before you can run this project, you need to have the following software installed:

Java JDK 11 or higher
Maven 3.6 or higher
Git


Installation
Clone the repository to your local machine:

git clone https://github.com/your-username/SauceDemoCucumber.git
cd SauceDemoCucumber

**Install the necessary dependencies:**
mvn install

**Running Tests
Execute the Cucumber tests through Maven by running:**

mvn test

**Features**
This testing suite covers the following functionalities of the Sauce Demo web application:

**Login Process: **Tests the login mechanism, including input validation and error handling.
**Product Selection: **Ensures that users can browse, select, and manage products in their cart.
**Checkout Process: **Verifies that the checkout process works seamlessly from cart to order confirmation.

**Configuration**
No additional configuration is required to run the tests in a standard setup. However, you can modify the src/test/resources/config.properties to adjust browser settings or test behaviors.
