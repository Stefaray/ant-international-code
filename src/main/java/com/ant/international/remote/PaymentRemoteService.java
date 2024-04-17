package com.ant.international.remote;

import com.ant.international.domain.ConsultResult;

/**
 * RPC调用接口
 */
public interface PaymentRemoteService {

    ConsultResult isEnabled(String paymentType);

}
