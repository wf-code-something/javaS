package com.day.day.up.main.service.impl;

import com.day.day.up.main.service.FruitService;
import com.day.day.up.main.service.dto.Apple;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class AppleServiceImpl implements FruitService<Apple> {
    @Override
    public void eat() {
        System.out.println("Apple is eaten");
    }

    @Override
    @CachePut(cacheNames = "apple", key = "#apple.id")
    public void put(Apple apple) {
        // 模拟数据库保存
        System.out.println("saving db and id is " + apple.getId());
        System.out.println("saving now");
        String str = "[{\"payProduct\":\"协议代收\",\"cardType\":\"1\",\"bankCode\":[\"兴业银行\"],\"isSupportShare\":1,\"isSupportRefund\":1}]";
    }

    @Override
    @Cacheable(cacheNames = "apple", key = "#id")
    public Apple get(long id) {
        System.out.println("querying db and id is " + id);
        //模拟从数据库查询数据
        System.out.println("query now ");

        return new Apple(id,1, "2");
    }

    @Override
    @CacheEvict(cacheNames = "apple")
    public void del(long id) {
        System.out.println("del db and id is " + id);
        //模拟从数据库删除数据
        System.out.println("del is now");
    }

}
