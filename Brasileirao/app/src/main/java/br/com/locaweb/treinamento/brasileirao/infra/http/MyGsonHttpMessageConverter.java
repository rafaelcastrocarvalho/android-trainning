package br.com.locaweb.treinamento.brasileirao.infra.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

public class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {

    public MyGsonHttpMessageConverter() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'")
                .create();
        setGson(gson);
    }
}
