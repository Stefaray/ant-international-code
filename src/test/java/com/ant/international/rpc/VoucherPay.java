package com.ant.international.rpc;

import com.ant.international.common.Constants;
import com.ant.international.domain.ConsultResult;
import com.ant.international.remote.PaymentRemoteServiceStub;

/**
 * 模拟 代金券 支付方式的 RPC
 */
public class VoucherPay implements PaymentRemoteServiceStub {

    private Boolean isEnabled = true;

    public VoucherPay() {

    }

    @Override
    public ConsultResult isEnabled() {
        return new ConsultResult(isEnabled, isEnabled ? Constants.SUCCESS_STATUS_CODE : Constants.FAILURE_STATUS_CODE);
    }

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }
}
