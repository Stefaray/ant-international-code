package com.ant.international.remote.impl;

import com.ant.international.domain.ConsultResult;
import com.ant.international.remote.PaymentRemoteService;
import com.ant.international.remote.common.PaymentTypeEnum;

/**
 * 远程接口调用统一入口实现类，加强封装性
 */
public class PaymentRemoteServiceImpl implements PaymentRemoteService {

    public ConsultResult isEnabled(String paymentType) {
        return PaymentTypeEnum.valueOf(paymentType).getPaymentRemoteServiceStub().isEnabled();
    }

}
