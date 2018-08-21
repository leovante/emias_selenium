@acceptanceTest

Feature: acceptanceTest #1, search in Yandex

Scenario: enter in row search data and recive result

    #actions at first page
When  open site "http://yandex.ru"
And enter "работай сука"
Then shows "Britney Spears – Work Bitch"
