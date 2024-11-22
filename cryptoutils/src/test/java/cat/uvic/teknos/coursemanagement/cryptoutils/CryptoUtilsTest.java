package cat.uvic.teknos.coursemanagement.cryptoutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoUtilsTest {

    @Test
    void getHash() {
        var text = "Some text...";
        var base64Text = "quonJ6BjRSC1DBOGuBWNdqixj8z20nuP+QH7cVvp7PI=";

        assertEquals(base64Text, CryptoUtils.getHash(text));
    }

    @Test
    void createSecretKey() {
        var secretKey = CryptoUtils.createSecretKey();

        assertNotNull(secretKey);

        var bytes = secretKey.getEncoded();
        System.out.println(CryptoUtils.toBase64(bytes));
    }

    @Test
    void decodeSecretKey() {
        var secretKeyBase84 = "jaruKzlE7xerbNSjxiVjZtuAeYWrcyMGsA8TaTqZ8AM=";

        var secretKey = CryptoUtils.decodeSecretKey(secretKeyBase84);

        assertNotNull(secretKey);
        assertEquals("AES", secretKey.getAlgorithm());
    }

    @Test
    void encrypt() {
    }

    @Test
    void decrypt() {
    }

    @Test
    void asymmetricEncrypt() {
    }

    @Test
    void asymmetricDecrypt() {
    }
}