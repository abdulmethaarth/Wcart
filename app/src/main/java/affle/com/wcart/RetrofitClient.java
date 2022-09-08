package affle.com.wcart;

import affle.com.wcart.network.IApiClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://wcart.webnexs.org/";

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofitInstance() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // service = retrofit.create(Api.class);
        return retrofit;
    }
    public static IApiClient getApiService() {
        return getRetrofitInstance().create(IApiClient.class);
    }
}

