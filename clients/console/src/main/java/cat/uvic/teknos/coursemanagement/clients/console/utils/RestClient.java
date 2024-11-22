package cat.uvic.teknos.coursemanagement.clients.console.utils;

import cat.uvic.teknos.coursemanagement.clients.console.exceptions.RequestException;

import java.util.Map;

public interface RestClient {
    class HeaderEntry {
        public String key;
        public String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public HeaderEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }


    }
    <T> T get(String path, Class<T> returnType, HeaderEntry... entries) throws RequestException;

    <T> T[] getAll(String path, Class<T[]> returnType, HeaderEntry... entries) throws RequestException;

    void post(String path, String body, HeaderEntry... entries) throws RequestException;

    void put(String path, String body, HeaderEntry... entries) throws RequestException;

    void delete(String path, String body, HeaderEntry... entries) throws RequestException;
}
