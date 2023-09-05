# m223_multiuserapp 
A m223 project.
## Co-Work API Description


A Rest API written in Java with the Quarkus Framework. An API for a Co-Working Space Application, which handles users, bookings, logins, roles and various QoL features.

> **_NOTE:_** A Co-Working Space is an arrangement in which workers for different companies share an office space

https://github.com/chris911e/m223-multiuserapp

## Running the application

1. First clone the repository on your local machine with:
```shell script
git clone https://github.com/chris911e/m223-multiuserapp.git
```

2. Open the project in VSCode and reopen with the given Container with `Ctrl + Shift + P` and press on the option for `Dev Containers` to build and reopen the Container.

3. Reload the window with `Ctrl + Shift + P` and press on the option `Reload Window` to install Maven dependencies after reload.

4. Start the application with
```shell script
./mvnw quarkus:dev
```

5. Access the API via `localhost:8080` and click on `Co-Work API` to open swagger and test out the endpoints the API offers.

## Login with example user

1. Under `/login` user this user to authorize yourself to all endpoints.
```json
  {
    "id": 2,
    "f_name": "Emily",
    "l_name": "Kol",
    "e_mail": "emily9898@exmaple.ch",
    "password": "password",
    "role": {
      "id": 2,
      "role": "Admin"
    },
    "createdAt": "2023-09-05T06:25:24.311242"
  }
```
  
## Automatic Test Data

Automatic test data is **automatically** injected whenever you start the application in development&test at `/service/TestDataService.java` for dev or at `/test/.../TestDataService.java`

## Disclaimer
You may most likely encounter bugs. 
