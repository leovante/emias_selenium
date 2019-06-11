package emias.medicalrecords;

import com.codeborne.selenide.Condition;
import com.utils.TestMethodCapture;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Listeners(TestMethodCapture.class)
public class CreateMRTest extends TestBase {

    @Test(groups = "MR", description = "проверка что подписывается старый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void testOldMRisSave() throws Exception {
        open("http://192.168.7.24/test/mr;master=true;doctorId=2129;doctorGuid=3e043c9f-57ea-4b3b-8aae-77df8162da41;doctorTypeGuid=81D86A3B-2C5A-44B0-8EF9-48E34FBCE21D;ticket=ayCJrojIslPZSaBFg5IKawQeSC9ms8gyGGHHLmNXWewhWHX95SRSMRbHRKCItDuk2iAxQ5b9mV1UvxY%2F8G%2FhNrO42bgRSwntHXNg75H%2FcM83%2F%2B0rwzCjpPDb%2B1dZX5xb9fSQ5Hne8mzmU6JMxTM5s3gAtqkiRzY3WcrDaQlgAvFM7YDVOiG0k0zLigAVdMH3jbf60QAhFwE34MuWRILcKsxvGWzYhJQ8kzY%2F75Y3uPThdn%2FVEQmwUBogdqauB%2B70N9H3PuykWpZG07h2z1fbZqlkSvPAv%2BN8fQFLwyzM8W92TliYHIXHzMypk%2BHgHmScSIfwaw%3D%3D/patient/2662111/59b63737-77c2-4dca-b4dd-b543d5db175d/E804E486-D7A8-47A1-870D-56BA14D67AB8/event/2662959/df93fb0f-68c6-4938-a7c3-46810a58f43b/523452F6-124E-4D63-94C4-012D71072FD3/medicalrecords");
        $x("//*[contains(text(),'Новая медицинская запись')]").click();
        $x("//*[contains(text(),'Все шаблоны')]").click();
        $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']").setValue("гастро");
        $x("//i[@class = 'zmdi zmdi-search']").click();
        $x("//span[@title = 'Осмотр гастроэнтеролога']").doubleClick();
        $x("//*[contains(text(),'Просмотреть')]").click();
        $x("//*[contains(text(),'Подписать')]").click();
        $x("//*[contains(text(),'Отменить')]").shouldBe(Condition.visible);
    }

    @Test(groups = "MR", description = "проверка что подписывается новый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void testMR2_0isSave() throws Exception {
        open("http://192.168.7.24/test/mr;master=true;doctorId=2129;doctorGuid=3e043c9f-57ea-4b3b-8aae-77df8162da41;doctorTypeGuid=81D86A3B-2C5A-44B0-8EF9-48E34FBCE21D;ticket=ayCJrojIslPZSaBFg5IKawQeSC9ms8gyGGHHLmNXWewhWHX95SRSMRbHRKCItDuk2iAxQ5b9mV1UvxY%2F8G%2FhNrO42bgRSwntHXNg75H%2FcM83%2F%2B0rwzCjpPDb%2B1dZX5xb9fSQ5Hne8mzmU6JMxTM5s3gAtqkiRzY3WcrDaQlgAvFM7YDVOiG0k0zLigAVdMH3jbf60QAhFwE34MuWRILcKsxvGWzYhJQ8kzY%2F75Y3uPThdn%2FVEQmwUBogdqauB%2B70N9H3PuykWpZG07h2z1fbZqlkSvPAv%2BN8fQFLwyzM8W92TliYHIXHzMypk%2BHgHmScSIfwaw%3D%3D/patient/2662111/59b63737-77c2-4dca-b4dd-b543d5db175d/E804E486-D7A8-47A1-870D-56BA14D67AB8/event/2662959/df93fb0f-68c6-4938-a7c3-46810a58f43b/523452F6-124E-4D63-94C4-012D71072FD3/medicalrecords");
        $x("//*[contains(text(),'Новая медицинская запись')]").click();
        $x("//*[contains(text(),'Все шаблоны')]").click();
        $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']").setValue("гастро");
        $x("//i[@class = 'zmdi zmdi-search']").click();
        $x("//span[@title = 'Консультация врача гастроэнтеролога 2']").doubleClick();
        $x("//*[contains(text(),'Просмотреть')]").click();
        $x("//*[contains(text(),'Подписать')]").click();
        $x("//*[contains(text(),'Медицинская запись успешно подписана')]").shouldBe(Condition.visible);
    }
}