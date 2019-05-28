package com.system.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CallDoctorCards {
    public Map<String, Integer> cardMap = new HashMap();

    public Integer getCardMap(String name) {
        return cardMap.get(name);
    }

    public void setCardMap(String a, int b) {
        cardMap.put(a, b);
    }
}
