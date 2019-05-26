# BookShopProject
The purpose of this project is to play with jee and surrounding technologies.

# Used tools/more important libraries

TODO 

# How to run application

TODO


# Monitoring 

To look inside jvm, on which server-side application runs, I used Java Mission Control from jdk 1.8.0_121. 

To setup this on your comuputer, you need to: 

1) download [jdk in version 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

2) download [jboss-client.jar](https://mvnrepository.com/artifact/jboss/jboss-client/4.0.2)

3) copy ```jboss-client.jar``` into ```jdk1.8.0/bin``` folder 

4) run jmc from command line, with additional parameters, as it was shown below
```
jmc.exe -vmargs -Xbootclasspath/a:"jboss-client.jar" 
```

This additional parameters are used to load ```jboss-client.jar```. This client is needed for establishing connection with wildfly.

5) add new connection - to do so, follow these steps:
    
    a) open window with properties of new connection, by clicking File -> connection -> create a new connection -> Next. 
Change 
    
    b) change to ```Custom JMX service URL``` 
    
    c) paste url to service in the following pattern 
    
    ```
    service:jmx:remote+http://[host]:[port] 
    ```
         
         
    If you are using docker toolbox, the url would be as follows: ```service:jmx:remote+http://192.168.99.100:9990```
    For the native docker the url would looks like this: ```service:jmx:remote+http://localhost:9990```
       
    d) fill user textbox with ```admin``` and password one with ```admin123```
    
    e) click finish
    
    
Afrer these steps, jmc is ready to monitor application :) 
