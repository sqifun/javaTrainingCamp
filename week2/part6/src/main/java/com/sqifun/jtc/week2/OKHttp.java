package com.sqifun.jtc.week2;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

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
        String url = "http://www.baidu.com";
//        String url = "http://localhost:8801";
//        doGet(url);
        doGetAsync(url);
    }

    /**
     * 同步调用
     * @param url 路径
     */
    public static void doGet(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url(url)
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
        } finally {
            call.cancel();
        }
    }


    /**
     * 异步调用
     * @param url 路径
     */
    public static void doGetAsync(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }
                    if (responseBody != null) {
                        System.out.println(responseBody.string());
                    }
                }
            }
        });

    }


}