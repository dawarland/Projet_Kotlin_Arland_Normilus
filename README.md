# ShoesYouWant : to be in it!

## Description

Shoes management application that uses Kotlin and Spring Boot 2 framework.

## Run the app

Execute this command in a terminal:

```bash
./gradlew bootRun
```

Then, open `http://localhost:8080/shoes/` in your browser

## If it doesn't works 

- Clone this projet
- Open with IntelliJ
- Build projet
- Go to com/shoesyouwant/api/ShoesApplication.kt and Run the main function

## Test with POSTMAN

- Create :
![image](https://user-images.githubusercontent.com/27726821/122564025-324a8f00-d045-11eb-8928-a37384867e6c.png)
POST => http://localhost:8080/shoes
```JSON
{
    "name":"...",
    "releaseDate":"YYYY-MM-DD",
    "price":200,
    "brandId":1
}
```
- Update :
POST => http://localhost:8080/shoes/3
```JSON
{
    "name":"NewName",
    "releaseDate":"1990-10-10",
    "price":5000
}
```

- Delete :
DELETE => http://localhost:8080/shoes/4
