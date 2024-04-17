package com.ant.international.domain;

/**
 * 结果实体类
 */
public class ConsultResult {

    public ConsultResult (boolean isEnable,String  errorCode){
        this.isEnable = isEnable;
        this.errorCode= errorCode;
    }

    /** 咨询结果是否可用*/
    private boolean isEnable;

    /** 错误码 */
    private String errorCode;

    public boolean getIsEnable(){
        return isEnable;
    }

    public String getErrorCode(){
        return errorCode;
    }

}
