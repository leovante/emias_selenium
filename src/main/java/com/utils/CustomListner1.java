package com.utils;

import com.api.TestStend;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.io.IOException;

public class CustomListner1 implements IInvokedMethodListener {
    TestStend testStend = new TestStend();
    boolean checkCreateCall;
    boolean checkKladrFind;

    public CustomListner1() throws IOException {
        checkCreateCall = testStend.checkCreateCall();
        checkKladrFind = testStend.checkKladrFind();
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        // TODO: 5/16/2019 проверить что вызов можно создать по api
        // TODO: 5/16/2019 проверить валидность тестовых данных
        // TODO: 5/22/2019 проверки на ссылки сервисов из конфига (отображение какого-нибудь элемента)
        if (!checkCreateCall | !checkKladrFind) {
            throw new SkipException(
                    "\nпроверка api диспетчера: " + checkCreateCall +
                            "\nпроверка api КЛАДР: " + checkKladrFind
            );
        }

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
