package com.ant.international;

import com.ant.international.remote.common.PaymentTypeEnum;
import com.ant.international.rpc.BalancePay;
import com.ant.international.rpc.CouponPay;
import com.ant.international.rpc.RedEnvelopePay;
import com.ant.international.rpc.VoucherPay;
import com.ant.international.service.CacheService;
import com.ant.international.service.PaymentService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类，对不同的支付方式分别启用or停用，观察输出的方式列表对不对
 */
public class TestTest {

    PaymentService paymentService = new PaymentService();

    BalancePay balancePay = new BalancePay();
    CouponPay couponPay  = new CouponPay();
    RedEnvelopePay redEnvelopePay = new RedEnvelopePay();
    VoucherPay voucherPay = new VoucherPay();

    /**
     * 红包、代金券停用
     */
    @Test
    public void test01() {

        balancePay.enable();
        couponPay.enable();
        redEnvelopePay.disable();
        voucherPay.disable();

        PaymentTypeEnum.BALANCE_PAY.setPaymentRemoteServiceStub(balancePay);
        PaymentTypeEnum.COUPON_PAY.setPaymentRemoteServiceStub(couponPay);
        PaymentTypeEnum.RED_ENVELOPE_PAY.setPaymentRemoteServiceStub(redEnvelopePay);
        PaymentTypeEnum.VOUCHER_PAY.setPaymentRemoteServiceStub(voucherPay);

        CacheService.getInstance().set(paymentService.asyncQueryALLPaymentTypes()); // 输出[BALANCE_PAY, COUPON_PAY]，正确
    }
}
