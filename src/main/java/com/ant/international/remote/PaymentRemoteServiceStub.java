package com.ant.international.remote;

import com.ant.international.domain.ConsultResult;

/**
 * 每一种支付方式的接口
 *
 */
public interface PaymentRemoteServiceStub {

    public ConsultResult isEnabled();

}
