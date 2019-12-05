@echo on
start/MIN java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubconfig.json -servlet org.openqa.grid.web.servlet.LifecycleServlet
start/MIN java -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeconfig.json -servlet org.openqa.grid.web.servlet.LifecycleServlet
exit
@echo off