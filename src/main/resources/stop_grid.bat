@echo off
start/MIN java -jar selenium-server-standalone-3.14.0.jar -role hub -hubConfig hubconfig.json
start/MIN java -jar selenium-server-standalone-3.14.0.jar -role node -nodeConfig nodeconfig.json
exit