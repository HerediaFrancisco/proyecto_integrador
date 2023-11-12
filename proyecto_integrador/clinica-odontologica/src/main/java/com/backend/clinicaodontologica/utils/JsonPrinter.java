package com.backend.clinicaodontologica.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class JsonPrinter {

    public static String toString(Object t) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        return gson.toJson(t).trim().replace("\n", "").replace("\t", "");

    }
}
