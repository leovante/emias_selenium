package com.utils.interfaces;

import io.qameta.allure.Step;

public interface IElement {

    /**
     * Get element attribute
     *
     * @param name Specify name for attribute
     * @return Returns chosen attribute
     */
    @Step
    String getAttribute(String name);

    /**
     * @param name  Specify attribute name
     * @param value Specify attribute value
     * Waits while attribute gets expected value. Return false if this not happens
     */
    @Step
    void waitAttribute(String name, String value);

    /**
     * @param attributeName Specify attribute name
     * @param value         Specify attribute value
     *                      Sets attribute value for Element
     */
    @Step
    void setAttribute(String attributeName, String value);

}
