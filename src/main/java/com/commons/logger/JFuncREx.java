package com.commons.logger;

@FunctionalInterface
public interface JFuncREx<TResult>  {
    TResult invoke() throws Exception;

}
