package co.codesurfer.mvvmashik.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;

import co.codesurfer.mvvmashik.Adapter.UserAdapter;
import co.codesurfer.mvvmashik.Model.User;
import co.codesurfer.mvvmashik.R;
import co.codesurfer.mvvmashik.ViewModel.MainActivityViewModel;
import co.codesurfer.mvvmashik.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //set up ViewModel
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


        recyclerview = binding.recyclerview;
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getAllData().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {
                recyclerview.setAdapter(new UserAdapter(users));

            }
        });


    }


}