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
    }

    @Test
    void decodeSecretKey() {
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