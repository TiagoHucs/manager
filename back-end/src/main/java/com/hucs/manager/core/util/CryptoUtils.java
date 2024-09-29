package com.hucs.manager.core.util;

import com.hucs.manager.core.config.NegocioException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String MY_KEY = "mysecretpasswordkey";


    public static String encrypt(String plainText) {
        try {
            return encrypt(plainText,MY_KEY);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encriptar");
        }
    }

    public static String decrypt(String encryptedText) {
        try {
            return decrypt(encryptedText,MY_KEY);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao decriptar");
        }
    }

    // Criptografa o texto com base em uma senha
    public static String encrypt(String plainText, String password) throws Exception {
        SecretKeySpec key = getKey(password); // Gera a chave baseada na senha
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes); // Retorna o texto criptografado em Base64
    }

    // Descriptografa o texto com base na mesma senha usada na criptografia
    public static String decrypt(String encryptedText, String password) throws Exception {
        SecretKeySpec key = getKey(password); // Gera a chave baseada na senha
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText); // Decodifica o texto de Base64
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8"); // Retorna o texto descriptografado
    }

    // Método para gerar uma chave a partir de uma senha (string)
    public static SecretKeySpec getKey(String password) throws Exception {
        // Converte a senha em um array de 16 bytes (128 bits) para AES
        byte[] keyBytes = password.getBytes("UTF-8");
        // Ajusta o tamanho do array para 16 bytes (caso a senha seja menor ou maior)
        byte[] key = new byte[16];
        System.arraycopy(keyBytes, 0, key, 0, Math.min(keyBytes.length, key.length));
        return new SecretKeySpec(key, ALGORITHM);
    }

}
