RMI Calculator example

Files added:
- src/Calculator.java          (remote interface)
- src/CalculatorImpl.java      (remote implementation)
- src/RMIServer.java           (server that binds the service)
- src/RMIClient.java           (client that calls add(10,20))

How to compile and run (from repo root):

1) Compile:
   javac -d out src/*.java

2) Run server (in one terminal):
   cd out
   java RMIServer

   You should see: "RMI Server is running. CalculatorService bound." 

3) Run client (in another terminal, from the same out directory):
   java RMIClient

   Expected client output:
   Addition result: 30

Notes:
- This example starts an in-process RMI registry on port 1099; no separate rmiregistry process is needed.
- If you run into java.rmi.ConnectException, ensure the server is running and bound.
- Tested with Java 8+; for modular Java (9+) adjust module exports or run on classpath as shown.
