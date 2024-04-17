package com.ant.international.service;

import com.ant.international.remote.common.PaymentTypeEnum;

import java.util.Collections;
import java.util.List;

/**
 * 缓存类，单例模式
 */
public class CacheService {

    // 单例实例
    private static final CacheService instance = new CacheService();
    // 全局缓存
    private static List<PaymentTypeEnum> cache;

    static  {
        cache = Collections.emptyList();
    }

    // 获取单例
    public static CacheService getInstance() {
        return instance;
    }

    // 更新缓存
    public void set(List<PaymentTypeEnum> list) {
        cache = list;
    }

    // 获取缓存
    public List<PaymentTypeEnum> get(List<PaymentTypeEnum> key) {
        return cache;
    }
}
