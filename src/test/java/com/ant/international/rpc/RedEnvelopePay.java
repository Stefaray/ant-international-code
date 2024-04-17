package com.ant.international.rpc;

import com.ant.international.common.Constants;
import com.ant.international.domain.ConsultResult;
import com.ant.international.remote.PaymentRemoteServiceStub;

/**
 * 模拟 红包 支付方式的 RPC
 */
public class RedEnvelopePay implements PaymentRemoteServiceStub {

    private Boolean isEnabled = true;

    public RedEnvelopePay() {

    }

    @Override
    public ConsultResult isEnabled() {
        return new ConsultResult(isEnabled, isEnabled ? Constants.SUCCESS_STATUS_CODE : Constants.FAILURE_STATUS_CODE);
    }

    @Override
    public void enable() {
        isEnabled = true;
    }

    @Override
    public void disable() {
        isEnabled = false;
    }
}
