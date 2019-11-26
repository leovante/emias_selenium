package com.utils.interfaces;

import com.utils.logger.JActionEx;
import com.utils.logger.JFuncREx;

import java.util.function.BooleanSupplier;

public interface IAsserter {
    RuntimeException exception(String message, Object... args);
    <TResult> TResult silent(JFuncREx<TResult> func);
    void ignore(JActionEx action);
    void isTrue(Boolean actual);
    void isTrue(Boolean actual, String msg);
    void isTrue(BooleanSupplier actual);
    void isTrue(BooleanSupplier actual, String msg);
    void checkMessage(String checkMessage);
    void doScreenshot(String doScreenshot);

}
