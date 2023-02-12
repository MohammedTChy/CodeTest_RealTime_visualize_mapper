# CodeTest_RealTime_visualize_mapper - Januray 2023
Java (Swing) application that in real-time visualize objects on a map. The included ServerStarter.jar is a server application that provides the objects using a TCP/IP connection.


Compiling without an IDE and doing it directly on a terminal (done on Windows 10 cmd)

NOTE: Make sure all files are located in the same folder, otherwise it may complain:
map.gif, server.properties, all four java files (MapApplication.java, Object.java, MapImageHolder.java and ParserObject.java) and ServerStart.jar


To start it up (Need to use two different command window):
1. javac *.java
2. java -jar ServerStart.jar (Do this in a seperate command window)
3. java MapApplication 

Explination for the above instruction: 
1. Compile all java file located in the directory folder. Four new files may be created with *.class at the end.

2. Start up the server connection first so it's ready to connect with the Application. 
This is due to it may complain that it didn't find a map.gif image to reference with a server application. 
It's a bit of hit and miss, at least for my system, may affect you as well. 
And it migt not be able to parse in objects, if MapApplication is running before ServerStart.jar, again, hit and miss, sometimes it does/doesn't, at least for my system. 

3. Start up the MapApplication


With an IDE:
 
Note: Map.gif has to be in the root folder, not in the src folder for this to work (At least had to be done for me). 
ServerStart.jar can be anywhere, however, make sure server.properties is located same classpath as ServerStart.jar. 
 
1.java -jar ServerStart.jar (do this either seperate terminal window or the in-built IDE terminal)

2. Compile and run the code


(Tested and works this way for me on Windows 10).
