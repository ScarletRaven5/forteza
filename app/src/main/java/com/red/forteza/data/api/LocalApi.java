package com.red.forteza.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.red.forteza.App;
import com.red.forteza.data.model.Guard;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocalApi {
    private static final Object LOCK = new Object();
    private static LocalApi instance;
    private Gson gson;

    public static LocalApi get() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new LocalApi();
                instance.gson = new GsonBuilder()
                        .create();
            }
        }
        return instance;
    }

    private <T> T parseAsset(String fileName, Class<T> clazz) {
        try {
            InputStream inputStream = App.get().getAssets().open(fileName);

            return gson.fromJson(new InputStreamReader(inputStream), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Guards getGuards() {
        String fileName = "guards.json";
        return parseAsset(fileName, Guards.class);
    }

}
