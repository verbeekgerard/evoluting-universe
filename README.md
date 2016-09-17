# evoluting-universe
Universe for the 'evoluting-life-java' project

#### Deplyment diagram
![alt tag](https://cloud.githubusercontent.com/assets/14174841/18608370/afaa6800-7ce7-11e6-9e09-92b4073a51c8.png)

##Evoluting-Planet usage

Open a terminal and go to the root of the Evoluting-Planet project. Type the command: 
```
mvn package
```
This wil create a JAR file in the target directory.

Start the JAR file with the command:
```
java -jar /path/to/jar/evoluting-planet-<VERSION>.jar <NAME> <PORT>
```

Go to: 'http://localhost:<PORT>/swagger-ui.html' to interact with the planet. 


