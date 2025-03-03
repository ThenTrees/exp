package com.thentrees.orderservice.utils;

import com.thentrees.orderservice.service.VaultTransitService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//@Converter(autoApply = true)
@RequiredArgsConstructor
public class VaultEncryptConverter implements AttributeConverter<String, String> {
    private final VaultTransitService vaultTransitService;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return vaultTransitService.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return vaultTransitService.decrypt(dbData);
    }
}
