# E-Cafe (Online Breverages ordering Application)
REST API developed for an Online beverages ordering Application.This API handles 2 different types of users(Admin and Customer) and performs all the fundamental CRUD operations of any Online food ordering Application platform with user validation at every step.

## Badges

![Badge](https://visitor-counter-badge.vercel.app/api/suranjanachary/ECP)

## Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Validation
- MySQL
- Lambok
- Swagger Ui

## Modules
- Login Module
- Admin Module
- Customer Module
- Product Category Management Module
- Product Management Module
- Cart Management Module


## E-Cafe

![CW_erd-Page-2](https://raw.githubusercontent.com/suranjanachary/ECP/main/e-cAFE%20(1).png)

## ER Diagram

![CW_erd-Page-1 drawio](https://github.com/suranjanachary/glad-creator-1065/blob/main/model%20class.png?raw=true)


## Service Interface

![CW_erd-Page-2](https://github.com/suranjanachary/glad-creator-1065/blob/main/service%20interface.png?raw=true)



## Features

- Customer and Admin authentication & validation with session UUID.
- Admin Features:
  - Admin can register, log in, log out and update account.
  - Admin have control over the entire application
  - Admin can add, view, update and delete Products, Categories.
  - Only logged-in Admin can access all features of Admin
- Customer Features:
  - Customers can register themselves with the application, logging in and logout into the application
  - Customers can view products according a specific category also in price sorted fashion(low to high/ high to low).
  - Customers can update, or delete their accounts
  - Only logged-in users can access all customer features

## Installation and Run

```
#changing the server port
server.port=8888
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecpdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
#No handler found
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false
#swagger-ui
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```

## API Root and Endpoint

```
https://localhost:8888/
```

```
http://localhost:8888/swagger-ui/
```

## Contributors

- [Suranjan Achary](https://github.com/suranjanachary)
