@echo off
start/MIN java -jar selenium-server-standalone-3.14.0.jar -role hub -hubConfig hubconfig.json -servlet org.openqa.grid.web.servlet.LifecycleServlet
start/MIN java -jar selenium-server-standalone-3.14.0.jar -role node -nodeConfig nodeconfig.json -servlet org.openqa.grid.web.servlet.LifecycleServlet
exit