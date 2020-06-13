# Building a Rest API with Kotlin & Spring boot
This project is an example of how to create a Rest API using Spring boot and Kotlin applying layer division  
Tutorial URL: https://www.youtube.com/watch?v=GH4lDILOUvk&list=PLNnNHr-wCfobAxSkuxMqFGdpA8E5cLR6w  
# The Person API
* **GET** /api/v1/person: Get all the persons
* **GET** /api/v1/person/{ID}: Get person by person's ID
* **POST** /api/v1/person: Insert a new person
* **PUT** /api/v1/person: Update an existing person
* **DELETE** /api/v1/person/{ID}: Delete person by person's ID
# Project Structure  
* **Domain**: [Object models](https://martinfowler.com/eaaCatalog/domainModel.html) 
of the domain that incorporates both behavior and data.
* **DAO**: [Data Access Object](https://en.wikipedia.org/wiki/Data_access_object) 
is a structural pattern that allows us to isolate the application/business layer from the persistence layer using an abstract API.
* **DTO**: [Data Transfer Object](https://martinfowler.com/eaaCatalog/dataTransferObject.html)
 an object that carries data between processes in order to reduce the number of method.
* **Service**: The [Service Layer](https://martinfowler.com/eaaCatalog/serviceLayer.html) 
defines an application's boundary with a layer of services that establishes a set of available 
operations and coordinates the application's response in each operation.
* **Transformer**: [Transformer](https://dzone.com/articles/transformer-pattern) is a design pattern that helps objects 
to transform themselves into objects of any type.
* **Resource**: [RESTful Web services](https://en.wikipedia.org/wiki/Representational_state_transfer) allow the requesting systems to access and manipulate textual 
representations of Web resources by using a uniform and predefined set of stateless operations.
# Technology
* **Java**: 8
* **Kotlin**: 1.3
* **Spring boot**: 2.3.1
