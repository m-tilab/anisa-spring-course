package com.example.springbootrest.controller;

import com.example.springbootrest.security.SecurityConstants;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller("/client")
@Slf4j
public class UserRestClientController {

    @ResponseBody
    @GetMapping("/demo")
    public String demo() {
        log.info("demo method called");
        return "Hello Spring Boot";
    }

    @ResponseBody
    @GetMapping("/getUsers")
    public String getUsers() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/user?page=2&limit=5")
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @ResponseBody
    @GetMapping("/token")
    public String getToken() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"username\" : \"m.tilab\",\r\n    \"password\" : \"1234567\"\r\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/user/login")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        return response.header(SecurityConstants.HEADER_STRING);
    }
}
