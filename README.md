# Quantified Self

[![Waffle.io](https://badge.waffle.io/anlewis/quantified-self-rails.svg?columns=all)](https://waffle.io/anlewis/quantified-self-rails)

### About

Quantified self is a simple calorie tracking application. It is used as a learning experience in using multiple languages and seperating backend and frontend services. This is the Rails backend API component.

### Getting Started

This project uses the [Spring Boot framework](https://projects.spring.io/spring-boot/), which can be easily initialized [here](https://start.spring.io/).
[Maven](https://maven.apache.org/what-is-maven.html) is used to build and manage the project.

In order to run this appication in the development environment, perform the following in the CLI:

```
mvn package
mvn flyway:migrate
```

In order to spin-up the server, run: `java -jar target/quantified-self-spring-0.0.1-SNAPSHOT.jar`

The frontend component can be found at: [quantified-self-fe](https://github.com/anlewis/quantified-self-fe). Follow the instructions in the Readme to spin up a server locally.

To view with the frontend component, visit the [Github Page](https://anlewis.github.io/quantified-self-fe/)

### Learning Goals
- Create a [Rails API](https://github.com/anlewis/quantified-self-rails) given specified endpoints and response formats.
- Create an [Express API](https://github.com/anlewis/quantified-self-express) given specified endpoints and response formats.
- Create an API in a new language of the students choice (Java/Spring) given specified endpoints and response formats.
- Review and refactor code (in each of the three languages) so that it:
  - is well organized
  - clearly communicates intent
  - utilizes abstraction to hide complexity
  - breaks problems down into small methods/functions with a single responsibility

### Database

[Flyway](https://flywaydb.org/) is used to manage database migrations.
The following schema was used to create a [PostgreSQL](https://www.postgresql.org/) database:

![schema](https://preview.ibb.co/e3J3ES/Screenshot_2018_05_01_17_12_51.png)

### Testing

At this time, no testing has been implemented; the primary goal was to setup CRUD functionality.

### API Endpoints

Quantified Self will have the following endpoints:

#### Food Endpoints
- `GET /api/v1/foods`: Returns all foods currently in the database

```
{
    "id": 1,
    "name": "Banana",
    "calories": 150
}
```

- `GET /api/v1/foods/:id` Returns the food object with the specific :id you’ve passed in or 404 if the food is not found.

- `POST /api/v1/foods` Allows creating a new food with the parameters:

```
{ "food": { "name": "Name of food here", "calories": "Calories here"} }
```

- `PATCH /api/v1/foods/:id` Allows one to update an existing food with the parameters:

```
{ "food": { "name": "Mint", "calories": "14"} }
```

- `DELETE /api/v1/foods/:id` Will delete the food with the id passed in and return a 204 status code. If the food can’t be found, a 404 will be returned.

#### Meal Endpoints

No meal endpoints have been implemented; future goals include setting up a many to many relationship between food and meals such that the following endpoints canbe created:

- `GET /api/v1/meals` Returns all the meals in the database along with their associated foods.

```
[
    {
        "id": 1,
        "name": "Breakfast",
        "foods": [
            {
                "id": 1,
                "name": "Banana",
                "calories": 150
            },
            {
                "id": 6,
                "name": "Yogurt",
                "calories": 550
            },
            {
                "id": 12,
                "name": "Apple",
                "calories": 220
            }
        ]
    },
    {
        "id": 4,
        "name": "Dinner",
        "foods": [
            {
                "id": 1,
                "name": "Banana",
                "calories": 150
            },
            {
                "id": 2,
                "name": "Bagel Bites - Four Cheese",
                "calories": 650
            }
        ]
    }
]
```

- `GET /api/v1/meals/:meal_id/foods` Returns all the foods associated with the meal with an id specified by :meal_id or a 404 if the meal is not found.

```
{
    "id": 1,
    "name": "Breakfast",
    "foods": [
        {
            "id": 1,
            "name": "Banana",
            "calories": 150
        },
        {
            "id": 6,
            "name": "Yogurt",
            "calories": 550
        }
    ]
}
```

- `POST /api/v1/meals/:meal_id/foods/:id` Adds the food with :id to the meal with :meal_id. This returns:

```
{
    "message": "Successfully added FOODNAME to MEALNAME"
}
```

- `DELETE /api/v1/meals/:meal_id/foods/:id` Removes the food with :id from the meal with :meal_id. This returns:

```
{
    "message": "Successfully removed FOODNAME to MEALNAME"
}
```
