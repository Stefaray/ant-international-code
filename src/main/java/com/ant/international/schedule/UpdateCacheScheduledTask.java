package com.ant.international.schedule;

import com.ant.international.common.Constants;
import com.ant.international.service.CacheService;
import com.ant.international.service.PaymentService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 */
public class UpdateCacheScheduledTask {

    static {
        // 创建一个线程，用于执行定时任务
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        PaymentService paymentService = new PaymentService();

        // 执行定时任务
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 定时任务的具体逻辑，将调用所有支付方式的RPC方法
                CacheService.getInstance().set(paymentService.asyncQueryALLPaymentTypes());
            }
        }, Constants.DELAY_TIME_SCHEDULED_TASK, Constants.PERIOD_SCHEDULED_TASK, TimeUnit.SECONDS);
    }

}
