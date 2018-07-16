package pages.calldoctor.Profiles_interfaces;

import java.util.HashMap;
import java.util.Map;

public class User6 {
    Map<String, String> map = new HashMap<>();

    public User6() {
        map.put("adress_1", "Московская");
        map.put("adress_2", "Химки");
        map.put("adress_3", "Пролетарская");
        map.put("adress", "Московская обл.,Химки г.,Пролетарская ул.,987а стр. 321в кор. 654б,к.126");
        map.put("dom", "987а");
        map.put("korpus", "654б");
        map.put("stroenie", "321в");
        map.put("kvartira", "126");
        map.put("pd", "505");
        map.put("dfon", "606");
        map.put("etazh", "707");
        map.put("telephone", "9511582714");
        map.put("nPol", "7854215965847521");
        map.put("fam", "Афанасьева");
        map.put("name", "Софья");
        map.put("otchestvo", "Петровна");
        map.put("gender", "Ж");
        map.put("birthDay", "19.02.2016");
        map.put("goda", "2 года");
        map.put("vozKat", "Дети");
        map.put("famCall", "Автотемников");
        map.put("nameCall", "Автодмитрий");
        map.put("otCall", "Автоолегович");
        map.put("stationSMP", "Суперстанция");
        map.put("zhaloba", "автотест создание вызова по МКАБ через Портал");
        return;
    }

    public String getData(String key) {
        return map.get(key);
    }
}