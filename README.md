# Swingy

### Score TBC/100
#### Mandatory
TBC/100

#### Bonus
TBC/25

#### Project Overview:
2nd Java project @ WeThinkCode_

Summary: A GUI RPG game created using the SWING framework.

### Installing & Running:
Ensure you have the latest JRE & JDK (14 at time of development), as well as Maven.

Build with Maven:
```
mvn clean package
```

Run with Java, specifying which interface you would like to use:
```
java -jar ./target/swingy-1.0.jar [console/gui]
```

The gui version requires a working X11 server if you are running a headless version of Unix.
Best bet is to get MobaXterm, ensure the X11 server is running, and then on the headless machine,
```
export DISPLAY=localhost:0.0
```
where `localhost` is the IPv4 address of the Unix machine.

Tested on Mac & WSL/Win10
