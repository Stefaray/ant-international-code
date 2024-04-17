package com.ant.international;

import com.ant.international.remote.common.PaymentTypeEnum;
import com.ant.international.rpc.BalancePay;
import org.junit.Test;

@Test
public class Test01 {
    public static void main(String[] args) {
        PaymentTypeEnum.BALANCE_PAY.setPaymentRemoteServiceStub(new BalancePay());
    }
}
