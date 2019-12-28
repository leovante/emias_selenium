package com.commons;

import java.util.HashMap;
import java.util.Map;

public class CallDoctorCards {
    private static Map<String, Integer> cardMap = new HashMap();

    public static Integer getCardMap(String name) {
        return cardMap.get(name);
    }

    public static void setCardMap(String a, int b) {
        cardMap.put(a, b);
    }
}