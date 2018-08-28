cmd /C start/MIN java -jar selenium-server-standalone-3.14.0.jar -role hub -port 4444 -timeout 300 -browserTimeout 360
cmd /C start/MIN java -jar selenium-server-standalone-3.14.0.jar -role node -port 5599 -hub http://localhost:4444/grid/register -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.firefox.driver=geckodriver.exe
