# Demo Application - GraphQL with Spring Boot

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [GraphQL - Getting started with Spring Boot](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)

### My personal notes

Demo application with H2 database to test some GraphQL features.

#### Notes

* GraphQL Query - GET data
* GraphQL Mutation - Create, Update, Delete data
* GraphQL Schema - Define which attributes are there in your class data type.
* GraphQL Vs REST API:
    - REST is having fixed response while GraphQL provides flexibility;
    - REST has different http methods and separate endpoints to each API, while in GraphQL whe have
        Query and Mutation and there is only one endpoint;
    - GraphQL needs Schema file while REST does not need that.

#### Examples

* Plugin for Google Chrome to run querys: Altair GraphQL Client

* Query's:
  ```
  query {
        fullName(sampleRequest: {
            firstName: "Tiago",
            lastName: "Jesus"
        })
  }
  ```
    Get Student By Id (dynamic fields, can add or remove fields):
    ```
  query {
        student(id: 1){
            id
            firstName
            lastName
            email
            street
            city
        }
    }
  ```

  Query with list:
    ```
      query{
            student(id: 2){
                id
                firstName
                lastName
                learningSubjects {
                    subjectName
                    marksObtained
                }
            }
      }
    ```
    ```
        query{
            student(id: 2){
                id
                firstName
                lastName
                learningSubjects {
                    subjectName
                    marksObtained
                }
                fullName
            }
        }
    ```
  