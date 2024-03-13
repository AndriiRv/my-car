# 'My car'

> Contents
> - [About](#about)
>   - [Business-microservices](#business-microservices)
>     - [Cars](#cars)
>     - [Customers](#customers)
>     - [ServicePartners](#servicepartners)
>   - [Maintenance-microservices](#maintenance-microservices)
>     - [ConfigServer](#configserver)
>     - [EurekaServer](#eurekaserver)
>     - [GatewayServer](#gatewayserver)
> - [Setup](#setup)
> - [Using](#using)

## About

###### UPDATED March 13, 2024

`My car` is a project which play a role as a system maintenance of the cars. Customers buys a cars and auto-attach to
some of the service station.
Built based on the microservice approach which to distribute logic on a small modules / microservices, namely:

* Business-microservices: `cars`, `customers`, `servicepartners`.
* Maintenance-microservices: `configserver`, `eurekaserver`, `gatewayserver`.

- This project is for education purpose, and it's a cause why all microservices lies on the one repository.
- On working environment we need to use all of these microservices on separate repositories which handle different
  development teams.

### Business microservices

#### Cars

###### UPDATED March 13, 2024

- This microservice intend to reveal business logic about the customer cars.
- Has three entities: `Car`, `Car details` and `Car statistics`. All of three entities have ONE-TO-ONE relationship.
- Use a `PostgreSQL` as RDBMS.

#### Customers

###### UPDATED March 13, 2024

- 'Customers' microservice has on a goal to handle customer / owner entities, like: `Owner`, `Owner credentials`
  and `Owner notifications`.
- `Owner` and `Owner credentials` have ONE-TO-ONE relationship.
- `Owner` and `Owner notifications` have ONE-TO-MANY relationship.
- Use an `Oracle` as RDBMS.

#### ServicePartners

###### UPDATED March 13, 2024

- This microservice described service station behavior, which include: `Service partner` / service station, `Worker`
  and `Car maintenance` entities.
- `Service partner` and `Worker` have ONE-TO-MANY relationship.
- `Service partner` and `Car maintenance` have ONE-TO-MANY relationship.
- Use a `MongoDB` as NoSQL DBMS.

### Maintenance microservices

#### Config server

###### UPDATED March 13, 2024

It's a microservice which based on Spring Cloud Config.
Provides support for externalized configuration in a distributed systems.

#### Eureka server

###### UPDATED March 13, 2024

Plays a role of discovery service within microservice approach.

#### Gateway server

###### UPDATED March 13, 2024

Intended to a general start point or gateway to our microservice network.

## Setup

###### UPDATED March 13, 2024

Before to run of `My car` microservice infrastructure you have to make sure that your host can connect to the repository
which intend to use by Spring Cloud Config server.

- If you have simple username & password approach to your repository then you need to add `username` and `password`
  parameters under `spring.cloud.config.server.git`.
- Otherwise, you will need to setup ssh between host and repository and manually put ssh keys as files from your OS
  directory to the root of this project: `root/ssh_keys`.

Also make sure that your Docker and Kubernetes is enabled.

## Using

###### UPDATED March 13, 2024

You may to use Docker or Kubernetes 'launchers' to start `My car` microservice infrastructure. Please be aware for three
profiles for it: `default`, `prod` and `qa`.

After proceed to one of these profiles you can find one bat file and this file will deploy all docker containers.

Deploying process may take a few minutes so please wait before all containers is started.
