# News Browser

Application consuming REST API https://newsapi.org/ in order to display news from Poland.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

[Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) \
[Node.js](https://nodejs.org/en/)

### Installing

To install this example application, run the following commands:

```bash
git clone https://github.com/adrian216/news.git
cd news
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server, cd into the `application` folder and run:
 
```bash
mvn spring-boot:run
```

To run the client, cd into the `web` folder and run:
 
```bash
npm install && npm start
```


## Running the tests

```bash
mvn: test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **A.D.** - *Initial work* - [adrian216](https://github.com/adrian216)


