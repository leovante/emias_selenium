package pages.utilities;

public class StringGenerator {
//    public static void main(String[] args) {
//        StringGenerator nameGen = new StringGenerator();
//        StringBuilder name = nameGen.generator();
//        System.out.println(name);
//
//    }

    //Ну да StringBuilder не потокобезопасный, по сравнению с StringBuffered. Ну и что?
    //Коммент на слуйчай если вдруг кто-то сюда посмотрит и заумничает

    public String generator() {
        String symbols = "йцукенгшщзхъфывапролджэячсмить";
        String name;
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 30);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * (symbols.length() - 1))));
        name = stringUpper(randString);
        return name;
    }

    private String stringUpper(StringBuilder randString) {
        String name = String.valueOf(randString);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}