package com.kent0k.customers.helper;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EncryptDecryptHelper {

    private final PBEStringEncryptor pbeStringEncryptor;

    public String encrypt(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }

        return pbeStringEncryptor.encrypt(value);
    }

    public String decrypt(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }

        return pbeStringEncryptor.decrypt(value);
    }
}
