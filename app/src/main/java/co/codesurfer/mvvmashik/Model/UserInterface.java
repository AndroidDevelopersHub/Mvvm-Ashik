package co.codesurfer.mvvmashik.Model;

import java.util.ArrayList;

public class UserInterface {

    public interface userApiResult{
        void onSuccess(ArrayList<User> userArrayList);
        void onFailed(String error);

    }



}
