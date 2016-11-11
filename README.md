# evoluting-universe
Universe for the 'evoluting-life-java' project

#### Deplyment diagram
![alt tag](https://cloud.githubusercontent.com/assets/14174841/18608370/afaa6800-7ce7-11e6-9e09-92b4073a51c8.png)

### Evoluting-Planet usage

Open a terminal and go to the root of the Evoluting-Planet project. Type the command:
```
mvn package
```
This creates a JAR file in the target directory.

Start the JAR file with the command:
```
java -jar /path/to/jar/evoluting-planet-<VERSION>.jar <PORT> <NAME>
```

Go to: 'http://localhost:\<PORT\>/' to interact with the planet.

## Planet Manager & Discovery (Eureka)
To create an universe with multtple planets you'll need the Planet Manager. The Planet Manager can start and stop the planets automatically. The Discovery project can find all the planets in the universe.

#### Discovery
Go to the root of the Discovery project. Type in the command
```
mvn package
```
This will create a JAR file in the target directory.
Start the JAR file with the command:

```
java -jar /path/to/jar/discovery-<VERSION>.jar
```
This will start the discovery service (default on port 8761)

#### Planet Manager
Go to the root of the Planet Manager project. Type in the command
```
mvn package
```
This will create a JAR file in the target directory.
Start the JAR file with the command:

```
java -jar /path/to/jar/planet-manager-<VERSION>.jar
```
This will start the planet manager (default on port 9100). After the Planet Manager is started you can start as much planets as you want. The planets will be found by the Discovery and the Planet Manager will start the planets.

### Update Evoluting-Universe version
1. Create a [Github release](https://github.com/blog/1547-release-your-software) of the 'evoluting-life-java' project. 
2. Use the tag from the [release](https://github.com/verbeekgerard/evoluting-life-java/releases) and insert it in the 'evoluting-life-java' dependecy, from the Evoluting-Planet project. 

    <dependency>
			<groupId>com.github.verbeekgerard</groupId>
			<artifactId>evoluting-life-java</artifactId>
			<version>TAG</version>
		</dependency>
    
3. Check jitpack.io/com/github/verbeekgerard/evoluting-life-java/THE_NEW_VERSION/build.log if the build is been succesfull 
4. Start the Evoluting-Planet application

