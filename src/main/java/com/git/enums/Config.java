package com.git.enums;

public enum Config {
    URL("URL"),
    ACCESS_TOKEN("ACCESS_TOKEN"),
    GIST_ID("GIST_ID");

    private String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
