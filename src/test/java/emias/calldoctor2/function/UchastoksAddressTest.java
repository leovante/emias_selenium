/**
 * проверяем участки и адреса
 */

package emias.calldoctor2.function;

import emias.TestBase;

public class UchastoksAddressTest extends TestBase {

//    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastokBezDomov() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile15");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient)
//                .createCall()
//                .selectUchastokFromNeUdalosOpredelit();
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastok_unikDom_3() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile16");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.createCallPage(pacient).selectUchastokFromNeUdalosOpredelit();
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile17");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        page.createCallPage(pacient).selectUchastokFromNeUdalosOpredelit();
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адреса нет ни в одном из участков")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException, ParseException, JSONException {
//        Pacient pacient = new Pacient("Profile18");
//        enter.calldoctorFromMis();
//        page.createCallPage(pacient).createCall();
//        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
//            "что участок определился по адресу вызова, а не мкаб")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastokPoAdresuANeMkab() throws IOException, InterruptedException, JSONException {
//        Pacient pacient = new Pacient("ProfileAdressNeIzMkab");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//        page.createCallPage(pacient).createCall_Api();
//        enter.calldoctorFromMis();
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .openNewCallDash(pacient);
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
//    }
//
//    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
//            "что участок не проставляется, если адрес неформализованный")
//    @Epic("Участки")
//    @RetryCountIfFailed(2)
//    public void testUchastokNotSet() throws IOException, InterruptedException, JSONException {
//        Pacient pacient = new Pacient("ProfileAdressNeIzMkab_neformal");
//        SQLDemonstration.finalizeCall_NPol(mkab.getnPol());
//
//        page.createCallPage(pacient).createCall_Api();
//        enter.calldoctorFromMis();
//        page.dashboardPage()
//                .searchFilterFio_Fam(pacient)
//                .openNewCallDash(pacient);
//        $(By.xpath("//*[contains(text(),'Участок')]")).shouldNotBe(Condition.visible);
//    }
    // TODO: 12/3/2018 сделать тест проверки списка участков при привязке адреса к участку на педиатр/взрослый
}