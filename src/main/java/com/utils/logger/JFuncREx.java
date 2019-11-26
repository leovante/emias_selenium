package com.utils.logger;

@FunctionalInterface
public interface JFuncREx<TResult>  {
    TResult invoke() throws Exception;

}
