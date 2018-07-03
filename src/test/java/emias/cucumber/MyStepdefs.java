package emias.cucumber;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MyStepdefs
{

    LoginPage loginPage = page(LoginPage.class);
//    FirstPage firstPage = page(FirstPage.class);
//    SecondPage secondPage = page(SecondPage.class);
//    ThirdPage thirdPage = page(ThirdPage.class);

    //    @Given("^open emias.demonstration\\.ru$")
    public void openEmiasDemonstration()
    {
        open("http://emias.mosreg.ru/demonstration/");
        loginPage.get("Логин").sendKeys("temnikov");
        loginPage.get("Пароль").sendKeys("1212");
        loginPage.get("Войти").click();
        System.out.println();
    }

//    @And("^select countries: (.*)$")
//    public void selectCountries(List<String> countries)
//    {
//        for (String str : countries)
//        {
//            firstPage.get("Укажите страну").sendKeys(str);
//            firstPage.get("Укажите страну").pressEnter();
//        }
//    }
//
//    @And("^specify dates of journey, any available dates$")
//    public void specifyDatesOfJourneyDepartureDateTomorrowReturnDateOneWeek()
//    {
//        firstPage.get("Даты поездки").click();
//        firstPage.clickAnyAvailableDate();
//    }
//
//    @And("^specify birthday of tourists: (\\d+).(\\d+).(\\d+)$")
//    public void specifyBirthdayOfTourists(String day, String month, String year)
//    {
//        firstPage.get("Кто едет").click();
//        firstPage.get("дд.мм.гггг").sendKeys(day + month + year);
//    }
//
//
//    @And("^press button with text \"([^\"]*)\" on \"([^\"]*)\"$")
//    public void press(String button, String page)
//    {
//        if ("первая страница".equals(page)) firstPage.get(button).click();
//        else if ("вторая страница".equals(page)) secondPage.get(button).click();
//        else if ("третья страница".equals(page)) thirdPage.get(button).click();
//    }
//
//    @And("^make a pause$")
//    public void makeAPause()
//    {
//        sleep(3000);
//    }
//
//    @And("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\" on \"([^\"]*)\"$")
//    public void typeToInputWithNameText(String nameOfElement, String text, String page)
//    {
//        sleep(1000);
//        if ("первая страница".equals(page))
//        {
//            firstPage.get(nameOfElement).sendKeys(text);
//        } else if ("вторая страница".equals(page))
//        {
//            secondPage.get(nameOfElement).sendKeys(text);
//        } else if ("третья страница".equals(page))
//        {
//            thirdPage.get(nameOfElement).sendKeys(text);
//        }
//
//    }
//
//    @And("^wait until login frame disappears$")
//    public void waitUntilLoginFrameDisappears()
//    {
//        firstPage.get("Фрейм входа в кабинет").waitUntil(Condition.disappears, 7000);
//    }
//
//    @And("^wait until spinner disappears$")
//    public void waitUntilSpinnerDisappears()
//    {
//        secondPage.get("Spinner").waitUntil(Condition.disappears, 30000);
//    }
//
//    @Then("^collection of \"([^\"]*)\" should not be empty$")
//    public void collectionOfShouldNotBeEmpty(String collection)
//    {
//        ElementsCollection selenideElements = secondPage.getCollection(collection);
//        selenideElements.shouldHave(CollectionCondition.sizeGreaterThan(0));
//    }
//
//
//    @Then("^verify that page with url \"([^\"]*)\" is opened$")
//    public void verifyThatPageWithUrlIsOpened(String verifyUrl)
//    {
//        sleep(3000);
//        String currentUrl = url();
//        assertThat(currentUrl, containsString(verifyUrl));
//    }
//
//    @And("^press element with value \"([^\"]*)\" and it should be enabled")
//    public void pressElementWithTextAndItShouldBe(String value)
//    {
//        thirdPage.get(value).waitUntil(Condition.enabled, 2000).click();
//    }
//
//    @When("^press button with text \"([^\"]*)\" and it should be enabled$")
//    public void pressButtonWithTextAndItShouldBeEnabled(String button)
//    {
//        thirdPage.get(button).waitUntil(Condition.visible, 6000).click();
//    }
//
//    @And("^spinner should be displayed$")
//    public void spinnerShouldBeDisplayed()
//    {
//        secondPage.get("Spinner").should(CustomConditions.spinnerShouldBeVisible());
//    }
//
//    @And("^check that element with name \"([^\"]*)\" is displayed$")
//    public void checkThatElementWithNameIsDisplayed(String elementName)
//    {
//        firstPage.get(elementName).shouldBe(Condition.appears);
//    }
}