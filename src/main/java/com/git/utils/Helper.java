package com.git.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Helper {

    public static <T> T convertResponseBodyToClass(Response response, Class<T> tClass) {
        return response.getBody().as(tClass);
    }

    public static <T> T convertJsonFromFileToClass(String fileName, Class<T> tClass) {
        FileReader file = null;
        Gson gson = new Gson();
        try {
            file = new FileReader("RestAssured/src/test/resources/json/" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(new JsonReader(file), tClass);
    }
}
