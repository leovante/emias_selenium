1. установить на win pc allure [https://github.com/allure-framework/allure2]
2. установить хром версии 76
3. установить java jdk 10.
4. загрузить проект тестов из последней ветки[http://bitbucket.softrust.ru/projects/WHC/repos/whc-emias-selenium-tests/browse]
5. для папки main->java сделать тип source. Для папки test->java сделать тип test source
6. запустить регрессионные тесты с помощью файла src->test->resources->regress.xml нажатием правой кнопки мыши, пункт run
7. дождаться выполнения тестов
8. сформировать отчет через командную строку. Внизу intellijIdea вкладка Terminal->allure serve target/allure-results