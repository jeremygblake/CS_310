package com.company;

public class Key {
    private String key;

    public Key(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hCode = 0;

        for (int i = 0; i < key.length(); i++) {
            hCode += key.charAt(i) * 51;
        }

        return hCode;
    }
}