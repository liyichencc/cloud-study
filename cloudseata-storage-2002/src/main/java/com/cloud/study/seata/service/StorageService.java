package com.cloud.study.seata.service;

public interface StorageService {

    void decrease(Long productId, Integer count);

}