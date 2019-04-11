# SDB - BACKEND SYSTEM BASED ON KAT TASK

This is a readme for task [I](#Author) created for SBD class in 2019

## Getting Started

These instructions will get you the project up and running on your local machine for development and testing purposes. See deployment notes for [*how to deploy the app*](#Deployment-and-Using).

### Prerequisites

Things you will need to build, run and test this application

```
Gradle, Java, cURL
```

## Deployment and Using

### Building and Running
Step by step series of examples that tell you how to get a development env running

First navigate to directory of downloaded repository.
Next run gradle tasks

**For Windows**
```bash
gradlew.bat clean bootJar
```
**For Linux**
```bash
gradlew clean bootJar
```

After that navigate to *build/libs/* and run

```
java -jar {createdfilename}.jar
```

## Run without building jar

Using Gradlew you can also run application without building jar

**For Windows**
```bash
gradlew.bat clean bootRun
```
**For Linux**
```bash
gradlew clean bootRun
```

## Example usage of using cURL

All application functionality can be tested using cURL. In this example I will show you how to add conference room to database.

**Windows - Invoke-RestMethod**
```bash
$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Authorization", 'Basic dGVzdDpub3R0ZXN0')

Invoke-RestMethod -Uri http://localhost:8080/user -Method POST -Body '{"personelNumber": 1172456, "login": "wadamczyk", "password": "haslo2018", "workerName": "Wojciech", "workerSurname": "Adamczyk", "department": "Community"}' -ContentType "application/json" -Headers $headers
```

**Linux - cURL method**
```bash
curl -d '{"personelNumber": 1172456, "login": "wadamczyk", "password": "haslo2018", "workerName": "Wojciech", "workerSurname": "Adamczyk", "department": "Community"}' -H "Content-Type: application/json" --header "Authorization: Basic dGVzdDpub3R0ZXN0" -X POST http://localhost:8080/user
```

Both commands will return us the same, but with different formatting:

**Invoke-RestMethod**
```text
id             : 6
personelNumber : 1172456
login          : wadamczyk
password       : $2a$10$DdTgxcPZ3Eo9fxJTrulQ9eA4GzsTceQM8QZt.ARd0d6uODZHzxJRG
workerName     : Wojciech
workerSurname  : Adamczyk
department     : Community
```


**cURL**
```json
{"id":6,"personelNumber":1172456,"login":"wadamczyk","password":"$2a$10$na/Tx6VPeB/Kx/367VxH2OVHZEuHIEZBogKxkIOYNCaBMvRemWO2G","workerName":"Wojciech","workerSurname":"Adamczyk","department":"Community"}
```

*Note:* Password is automaticaly encrypted by backend using BCrypt

## Author

* **Dominik Kostecki** - *Creator of Project* - [dominikoso](https://github.com/dominikoso)



