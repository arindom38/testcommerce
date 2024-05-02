# Spring Boot "E-commerce" Example Project

This is a sample Java (version 17) / Maven / Spring Boot (version 3.2.5) application with built-in health check, log
visualization and much more.

## How to Run

This application is packaged as a war which has Tomcat 10 embedded. No Tomcat or JBoss installation is necessary. You
run it using the ```java -jar``` command.

* Clone this repository
* Make a directory **data** inside the project directory [Optional]
* Make sure you have the docker installed and have the `docker compose version v2.27.0`
* Run the docker command ```docker compose -f docker-compose.yml up -d```
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:

```
        java -jar -Dspring.profiles.active=dev target/testcommerce.war
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```

Once the application runs you should see something like this

```
2024-05-02 | 14:47:33.486 | main                 |  INFO | o.s.b.w.embedded.tomcat.TomcatWebServer  |                   |  Tomcat started on port 8089 (http) with context path '/testcommerce'
2024-05-02 | 14:47:33.508 | main                 |  INFO | o.t.w.t.TestcommerceApplication          |                   |  Started TestcommerceApplication in 9.618 seconds
```

## About the Service

The service is just a simple e-commerce REST service. It uses an open source database (postgresql) to store the data.
The database can be run inside a container using docker-compose.yml with port 5033. Please check the yml file for more
details.If your database connection properties work, you can call some REST endpoints defined
in ```org.test.wsd.testcommerce.controller.CustomerController```
and ```org.test.wsd.testcommerce.controller.SaleController``` on **port 8089**. (see below)

More interestingly, you can start calling some of the operational endpoints (see full list below) like ```/actuator```
and ```actuator/health``` (these are available on **port 8089**)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed
RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the
same patterns as the sample service.

Here is what this little application demonstrates:

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 10): No need to install a container separately on the host
  just run using the ``java -jar`` command
* Demonstrates how to set up healthcheck. endpoints automatically on a configured port.
* Writing a RESTful service using annotation: supports JSON request / response;
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* Uses JUnit with Mockito demonstrates TDD approach with associated libraries
* All APIs are "self-documented" by Swagger2 using annotations
* Flyway is used for db migration automatic with an initial dump data for testing.

Here are some Key API you can call:

### Get information about system health

```
http://localhost:8089/testcommerce/actuator/health
```

### To view Swagger  API docs

```
http://localhost:8089/testcommerce/v3/swagger-ui
http://localhost:8089/testcommerce/v3/api-docs
```

### E-commerce API resource

#### 1. API to return the wish list of a customer

```
CURL Request:
curl --location 'http://localhost:8089/testcommerce/api/customers/wish-list?customerId=1' \
--header 'Content-Type: application/json'

Response: HTTP 200
Body:
[
    {
        "itemId": 1,
        "itemName": "product A",
        "itemDescription": "product A",
        "itemPrice": "100"
    },
    {
        "itemId": 2,
        "itemName": "product B",
        "itemDescription": "product B",
        "itemPrice": "200"
    }
]
```

#### 2. API to return the total sale amount of the current day

```
curl --location 'http://localhost:8089/testcommerce/api/sales/total-amount?date=2024-04-01' \
--header 'Content-Type: application/json'

Response: HTTP 200
Body: 300
```

#### 3. API to return the max sale day of a certain time range

```
curl --location 'http://localhost:8089/testcommerce/api/sales/max-sale-date?startDate=2024-04-01&endDate=2024-04-06' \
--header 'Content-Type: application/json'

{
"name" : "Beds R Us",
"description" : "Very basic, small rooms but clean",
"city" : "Santa Ana",
"rating" : 3
}

RESPONSE: HTTP 200 
Body: "2024-04-02"
```

#### 4. API to return top 5 selling items of all time (based on total sale amount)

```
curl --location 'http://localhost:8089/testcommerce/api/sales/top-items?limit=5&criteria=total-sale-amount' \
--header 'Content-Type: application/json'

RESPONSE: HTTP 200 
Body:
[
    {
        "itemId": 4,
        "itemName": "product D",
        "itemDescription": "product D",
        "itemPrice": "400",
        "totalSaleAmount": "380"
    },
    {
        "itemId": 1,
        "itemName": "product A",
        "itemDescription": "product A",
        "itemPrice": "100",
        "totalSaleAmount": "310"
    },
    {
        "itemId": 3,
        "itemName": "product C",
        "itemDescription": "product C",
        "itemPrice": "300",
        "totalSaleAmount": "200"
    },
    {
        "itemId": 2,
        "itemName": "product B",
        "itemDescription": "product B",
        "itemPrice": "200",
        "totalSaleAmount": "100"
    }
]
```

#### 5. API to return top 5 selling items of the last month (based on number of sales)

```
curl --location 'http://localhost:8089/testcommerce/api/sales/top-items?limit=5&criteria=total-number-sales&month=last' \
--header 'Content-Type: application/json'

RESPONSE: HTTP 200 
Body:
[
    {
        "itemId": 1,
        "itemName": "product A",
        "itemDescription": "product A",
        "itemPrice": "100",
        "totalNumberOfSale": "3"
    },
    {
        "itemId": 4,
        "itemName": "product D",
        "itemDescription": "product D",
        "itemPrice": "400",
        "totalNumberOfSale": "3"
    },
    {
        "itemId": 3,
        "itemName": "product C",
        "itemDescription": "product C",
        "itemPrice": "300",
        "totalNumberOfSale": "2"
    },
    {
        "itemId": 2,
        "itemName": "product B",
        "itemDescription": "product B",
        "itemPrice": "200",
        "totalNumberOfSale": "1"
    }
]
```

### Questions and Comments: ruet.ujjal38@gmail.com


