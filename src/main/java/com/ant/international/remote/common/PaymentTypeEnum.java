package com.ant.international.remote.common;

import com.ant.international.remote.PaymentRemoteServiceStub;

/**
 * 支付方式枚举类，提高代码可读性，提高代码扩展性
 */
public enum PaymentTypeEnum {

    BALANCE_PAY("余额"),    // 余额
    RED_ENVELOPE_PAY("红包"),     // 红包
    COUPON_PAY("优惠券"),    // 优惠券
    VOUCHER_PAY("代金券");     // 代金券

    private PaymentRemoteServiceStub remotePaymentService;

    private final String name;

    PaymentTypeEnum(String name){
        this.name = name;
    }

    public void setPaymentRemoteServiceStub(PaymentRemoteServiceStub remotePaymentService) {
        this.remotePaymentService = remotePaymentService;
    }

    public PaymentRemoteServiceStub getPaymentRemoteServiceStub() {
        return remotePaymentService;
    }

    public String getName(){
        return name;
    }
}
