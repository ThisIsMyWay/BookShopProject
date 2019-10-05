# BookShopProject
The purpose of this project is to play with jee and surrounding technologies.

# Used technologies/more important libraries

- Docker
- Rest-assured
- Spock
- HATEOAS

TODO:
- React.js ( JS and react learning in progress :D) 

# How to run an application

## Requirments (on which it was tested)
- Apache Maven 3.5.0 
- JDK 12
- Docker Toolbox 

## Launching the application

To launch the application, you need to run ```build_and_run.sh``` script. It will start the application in a default (dev) mode. 
In general, the script offers two ways of launching the application, the dev mode and the test one. 

The dev mode is usefull for a regular development, because it:
- builds the application,
- starts a docker container with DB (PostgreSQL) and populates it with sample data,
- starts a docker contianer with an application server (wildfly) in a debug mode, 
- deploys the application. 

The docker containers are set up in such a way, that every time the application is rebuilted, it is automatically deployed on the application server.

The test mode is used to check application, after a bigger refactoring or implementing a functionality. In details, it makes the same steps as in the dev mode. And additionally it:
- runs integration tests, 
- tears down the containers.

To run the application in the dev mode, you just need:
1. to run script without parameters, like this:
```
sh build_and_run.sh
```

2. or to declare the dev mode explicitly, by passing it as a parameter, as follows: 
```
sh build_and_run.sh -mode dev
```

Analogically, to run it in the test mode, you need to pass the ```test``` parameter, as it is shown below:
```
sh build_and_run.sh -mode test
```

# Monitoring 

To look inside jvm, on which server-side application runs, I used Java Mission Control from jdk 1.8.0_121. 

To setup this on your comuputer, you need to: 

1) download [jdk in version 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

2) download [jboss-client.jar](https://mvnrepository.com/artifact/jboss/jboss-client/4.0.2)

3) copy ```jboss-client.jar``` into ```jdk1.8.0/bin``` folder 

4) run jmc from command line, with additional parameters, as it was shown below:
```
jmc.exe -vmargs -Xbootclasspath/a:"jboss-client.jar"
```

These additional parameters are used to load ```jboss-client.jar```. This client is needed for establishing connection with wildfly.

5) add new connection - to do so, follow these steps:
    
    a) open the window with properties of new connection, by clicking File -> connection -> create a new connection -> Next 
    
    b) change to ```Custom JMX service URL``` 
    
    c) paste url to service in the following pattern 
    
    ```
    service:jmx:remote+http://[host]:[port] 
    ```
         
         
    If you are using docker toolbox, the url would be as follows: 
    ```
    service:jmx:remote+http://192.168.99.100:9990
    ```
    
    For the native docker the url would looks like this: 
    ```
    service:jmx:remote+http://localhost:9990
    ```
       
    d) fill user textbox with ```admin``` and password one with ```admin123```
    
    e) click finish
    
    
Afrer these steps, jmc is ready to monitor application :) 
