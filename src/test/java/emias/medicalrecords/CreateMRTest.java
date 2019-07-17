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
        open("http://192.168.7.24/test/mr;master=true;doctorId=2135;doctorGuid=24688d3b-5db6-4ce7-823e-50c6ba025a8d;doctorTypeGuid=81D86A3B-2C5A-44B0-8EF9-48E34FBCE21D;ticket=7Hqk2aACn3jcvP8jXPJvIlv1dDL90dDfuOmd0IF1mjjd8m3VZvSw5nGbVLHMy1AYzmkOsPoeCNnk9S6ySFFn0O8nEKEMxUdBCDbkA%2Bxj2h4tnPGaO3V7huXbtXgBt04Ag2kilQSP71fHF0%2BFFQocSnXggq3yk%2B8bVXMSxdNelFvWLsVWLX%2B%2BDJpA7iGgNRrXSVz6erw%2Fex8w0zsm48FuIvobrIfmNpFJq4fvTBJOCyyERE%2F4UCMyxnJQOF3LjzShVEiZyeKLa7o1BPBgmUi%2BEv4JRJ8zW6fS9leKR%2Fj6nHg73FWgmRBzJ9jjWcmcVyAn4WjFmw%3D%3D/patient/2662111/59b63737-77c2-4dca-b4dd-b543d5db175d/E804E486-D7A8-47A1-870D-56BA14D67AB8/event/2664807/6ff738d2-f9d5-4423-bf58-d01c390d22d9/523452F6-124E-4D63-94C4-012D71072FD3/medicalrecords?ticket=7Hqk2aACn3jcvP8jXPJvIlv1dDL90dDfuOmd0IF1mjjd8m3VZvSw5nGbVLHMy1AYzmkOsPoeCNnk9S6ySFFn0O8nEKEMxUdBCDbkA%2Bxj2h4tnPGaO3V7huXbtXgBt04Ag2kilQSP71fHF0%2BFFQocSnXggq3yk%2B8bVXMSxdNelFvWLsVWLX%2B%2BDJpA7iGgNRrXSVz6erw%2Fex8w0zsm48FuIvobrIfmNpFJq4fvTBJOCyyERE%2F4UCMyxnJQOF3LjzShVEiZyeKLa7o1BPBgmUi%2BEv4JRJ8zW6fS9leKR%2Fj6nHg73FWgmRBzJ9jjWcmcVyAn4WjFmw%3D%3D&DocPrvdId=2135");
        $x("//*[contains(text(),'Новая медицинская запись')]").click();
        $x("//*[contains(text(),'Все шаблоны')]").click();
        $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']").setValue("гастро");
        $x("//i[@class = 'zmdi zmdi-search']").click();
        $x("//span[@title = 'Осмотр гастроэнтеролога']").doubleClick();
        $x("//*[contains(text(),'Просмотреть')]").click();
        $x("//*[contains(text(),'Подписать')]").click();
        $x("//*[contains(text(),'Медицинская запись успешно подписана')]").shouldBe(Condition.visible);
    }

    @Test(groups = "MR", description = "проверка что подписывается новый шаблон")
    @Epic("Создание медзаписи")
    @RetryCountIfFailed(2)
    public void testMR2_0isSave() throws Exception {
        open("http://192.168.7.24/test/mr;master=true;doctorId=2135;doctorGuid=24688d3b-5db6-4ce7-823e-50c6ba025a8d;doctorTypeGuid=81D86A3B-2C5A-44B0-8EF9-48E34FBCE21D;ticket=7Hqk2aACn3jcvP8jXPJvIlv1dDL90dDfuOmd0IF1mjjd8m3VZvSw5nGbVLHMy1AYzmkOsPoeCNnk9S6ySFFn0O8nEKEMxUdBCDbkA%2Bxj2h4tnPGaO3V7huXbtXgBt04Ag2kilQSP71fHF0%2BFFQocSnXggq3yk%2B8bVXMSxdNelFvWLsVWLX%2B%2BDJpA7iGgNRrXSVz6erw%2Fex8w0zsm48FuIvobrIfmNpFJq4fvTBJOCyyERE%2F4UCMyxnJQOF3LjzShVEiZyeKLa7o1BPBgmUi%2BEv4JRJ8zW6fS9leKR%2Fj6nHg73FWgmRBzJ9jjWcmcVyAn4WjFmw%3D%3D/patient/2662111/59b63737-77c2-4dca-b4dd-b543d5db175d/E804E486-D7A8-47A1-870D-56BA14D67AB8/event/2664807/6ff738d2-f9d5-4423-bf58-d01c390d22d9/523452F6-124E-4D63-94C4-012D71072FD3/medicalrecords?ticket=7Hqk2aACn3jcvP8jXPJvIlv1dDL90dDfuOmd0IF1mjjd8m3VZvSw5nGbVLHMy1AYzmkOsPoeCNnk9S6ySFFn0O8nEKEMxUdBCDbkA%2Bxj2h4tnPGaO3V7huXbtXgBt04Ag2kilQSP71fHF0%2BFFQocSnXggq3yk%2B8bVXMSxdNelFvWLsVWLX%2B%2BDJpA7iGgNRrXSVz6erw%2Fex8w0zsm48FuIvobrIfmNpFJq4fvTBJOCyyERE%2F4UCMyxnJQOF3LjzShVEiZyeKLa7o1BPBgmUi%2BEv4JRJ8zW6fS9leKR%2Fj6nHg73FWgmRBzJ9jjWcmcVyAn4WjFmw%3D%3D&DocPrvdId=2135");
        $x("//*[contains(text(),'Новая медицинская запись')]").click();
        $x("//*[contains(text(),'Все шаблоны')]").click();
        $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']").setValue("гастро");
        $x("//i[@class = 'zmdi zmdi-search']").click();
        $x("//span[@title = 'Консультация врача гастроэнтеролога 2']").doubleClick();
        $x("//*[contains(text(),'Просмотреть')]").hover().click();
        $x("//*[contains(text(),'Подписать')]").click();
        $x("//*[contains(text(),'Медицинская запись успешно подписана')]").shouldBe(Condition.visible);
    }
}