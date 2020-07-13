package co.codesurfer.mvvmashik.Model;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class UserApiCall {

    Application application;

    public UserApiCall(Application application) {
        application = application;
    }

    public MutableLiveData<User[]> getUsersData(){

        final MutableLiveData<User[]> mutableLiveData = new MutableLiveData<>();
        String url = "https://api.github.com/users";
        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .get()
                .header("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
            }
            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String mMessage = response.body().string();
                Log.e("Response", mMessage);
                if (mMessage.length() != 0) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();

//                    Type collectionType = new TypeToken<Collection<User>>(){}.getType();
//                    Collection<User> enums = gson.fromJson(mMessage, collectionType);

                    User[] enums2 = gson.fromJson(mMessage, User[].class);

                    mutableLiveData.postValue(enums2);

                }


            }
        });

        return mutableLiveData;

    }







}
