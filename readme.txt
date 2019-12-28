1. установить на win pc allure [https://github.com/allure-framework/allure2].
2. установить хром версии 76.
3. установить java jdk 10.
4. загрузить проект тестов из последней ветки[http://bitbucket.softrust.ru/projects/WHC/repos/whc-emias-selenium-tests/browse].
5. для папки main->java сделать тип source. Для папки test->java сделать тип test source.
6. запустить сервер виртуализации браузеров из папки src->main->resources->driver->run_grid.bat. Убедиться что появилось две запущенные консоли.
7. запустить регрессионные тесты с помощью файла src->test->resources->regress.xml нажатием правой кнопки мыши, пункт run.
8. дождаться выполнения тестов.
9. сформировать отчет через командную строку. Внизу intellijIdea вкладка Terminal->allure serve target/allure-results.