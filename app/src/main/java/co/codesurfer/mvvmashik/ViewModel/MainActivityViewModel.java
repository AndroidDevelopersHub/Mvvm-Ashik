package co.codesurfer.mvvmashik.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Collection;

import co.codesurfer.mvvmashik.Model.User;
import co.codesurfer.mvvmashik.Model.UserApiCall;

public class MainActivityViewModel extends AndroidViewModel {

    UserApiCall userApiCall;
    Application application;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userApiCall = new UserApiCall(application);

    }

    public LiveData<User[]> getAllData(){
        return userApiCall.getUsersData();
    }




}
