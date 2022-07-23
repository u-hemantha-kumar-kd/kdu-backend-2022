package com.homework14part1.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class ObjectUtility {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> String convertToJson(T t) {
        return gson.toJson(t);
    }
}

