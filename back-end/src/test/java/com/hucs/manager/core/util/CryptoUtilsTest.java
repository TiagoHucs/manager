package com.hucs.manager.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CryptoUtilsTest {

    @Test
    public void encryptDefaultAplicationTest() throws Exception {
            // Exemplo de uso
            String originalText = "Texto secreto!";

            // Criptografia
            String encryptedText = CryptoUtils.encrypt(originalText);
            Assertions.assertNotEquals(originalText,encryptedText);
            Assertions.assertTrue(!encryptedText.contains(originalText));

            // Descriptografia
            String decryptedText = CryptoUtils.decrypt(encryptedText);
            assertEquals(originalText,decryptedText);
    }

    @Test
    public void encryptByUserOrAnotherTest() throws Exception {
        // Exemplo de uso
        String originalText = "Texto secreto!";

        // Criptografia
        String encryptedText = CryptoUtils.encrypt(originalText,"myuserpass");
        Assertions.assertNotEquals(originalText,encryptedText);
        Assertions.assertTrue(!encryptedText.contains(originalText));

        // Descriptografia
        String decryptedText = CryptoUtils.decrypt(encryptedText,"myuserpass");
        assertEquals(originalText,decryptedText);
    }

}