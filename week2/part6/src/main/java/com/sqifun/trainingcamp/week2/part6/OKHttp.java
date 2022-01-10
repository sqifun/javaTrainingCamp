package com.sqifun.trainingcamp.week2.part6;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * @program: tragro
 * @className: OKHttpTest
 * @description:
 * @author: sqi
 * @date: 2022-01-09 23:07
 * @version: 1.0
 **/
public class OKHttp {

    public static void main(String[] args) {
//        String uri = "http://www.baidu.com";
        String uri = "http://localhost:8801";
        doGet(uri);
    }

    public static void doGet(String uri) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url(uri)
                .build();

        Call call = client.newCall(request);

        try (Response response = call.execute()) {
            if (response.code() == 200) {
                ResponseBody body = response.body();
                if (body != null) {
                    System.out.println(body.string());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}