package com.thentrees.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultOperations;

@Component
@RequiredArgsConstructor
@Slf4j
public class VaultTransitService {

    @Value("${transit.path}")
    private String path;

    @Value("${transit.key}")
    private String key;

    private final VaultOperations vaultOperations;

    public String decrypt(String plaintext) {
        return vaultOperations.opsForTransit(path).decrypt(key, plaintext);
    }

    public String encrypt(String plaintext) {
        log.info("Encrypting plaintext - tran: {}", plaintext);
        return vaultOperations.opsForTransit(path).encrypt(key, plaintext);
    }
}
