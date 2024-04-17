package com.ant.international.service;

import com.ant.international.common.Constants;
import com.ant.international.domain.ConsultResult;
import com.ant.international.remote.PaymentRemoteService;
import com.ant.international.remote.common.PaymentTypeEnum;
import com.ant.international.remote.impl.PaymentRemoteServiceImpl;

import java.util.Collections;
import java.util.List;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 支付实现
 */
public class PaymentService {

    public PaymentRemoteService paymentRemoteService = new PaymentRemoteServiceImpl();

    public List<PaymentTypeEnum> enabledPaymentTypes = Collections.emptyList();

    // 多线程异步执行所有远程调用方法
    public List<PaymentTypeEnum> asyncQueryALLPaymentTypes(){
        // 并行执行Enum类中存在的所有RPC方法
        enabledPaymentTypes = Stream.of(PaymentTypeEnum.values()).parallel().filter(this::isPaymentTypeEnabled)
                .collect(Collectors.toList());
        System.out.println(enabledPaymentTypes.toString());
        return enabledPaymentTypes;
    }

    // 判断单个RPC是否可用
    private boolean isPaymentTypeEnabled(PaymentTypeEnum paymentType) {
        CompletableFuture<ConsultResult> future = CompletableFuture.supplyAsync(() -> {
            return paymentRemoteService.isEnabled(paymentType.toString());
        });
        // 异常处理
        try {
            ConsultResult result = future.get(Constants.REMOTE_SERVICE_TIMEOUT, TimeUnit.SECONDS);
            return result.getIsEnable();
        } catch (TimeoutException e) {
            // 超时未获取到结果，抛出异常
            future.cancel(true); // 取消任务
            System.err.println(Constants.ERROR_MSG_REMOTE_SERVICE_TIMEOUT);
            return false;
        } catch (Exception e) {
            // 服务本身有问题
            System.err.println(Constants.ERROR_MSG_REMOTE_SERVICE_CALL_FAIL);
            return false;
        }
    }

}
