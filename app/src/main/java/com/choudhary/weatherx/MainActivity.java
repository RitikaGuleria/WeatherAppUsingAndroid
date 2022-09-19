package com.choudhary.weatherx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.choudhary.weatherx.Models.MainActivityViewModel;
import com.choudhary.weatherx.Models.MausamData;
import com.choudhary.weatherx.Models.main;
import com.choudhary.weatherx.Models.weather;
import com.choudhary.weatherx.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    ConstraintLayout constraintLayout;

    MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        constraintLayout = findViewById(R.id.constraint_layout);

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String curretndate = format.format(new Date());
        binding.date.setText(curretndate);

        fetchWeather("Delhi");

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideKeyBoard();
                if (TextUtils.isEmpty(binding.searchCityEdittext.getText().toString())){

                    binding.searchCityEdittext.setError("please enter city");
                    return;
                }

                String CITY_NAME = binding.searchCityEdittext.getText().toString();

                fetchWeather(CITY_NAME );

            }
        });



    }

    void hideKeyBoard(){
       InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(constraintLayout.getApplicationWindowToken(),0);
    }


    void fetchWeather(String  cityname){

        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);

        Call<MausamData> call  = interfaceApi.getData(cityname,"80409e07282e463da7a67d85222710b6","metric");

        call.enqueue(new Callback<MausamData>() {
            @Override
            public void onResponse(Call<MausamData> call, Response<MausamData> response) {

                if (response.isSuccessful()){
                    MausamData mausamData = response.body();
                    main  to = mausamData.getMain();

                    binding.mainTempValue.setText(String.valueOf(to.getTemp())+"\u2103");
                    binding.maxTempValue.setText(String.valueOf(to.getTemp_max())+"\u2103");
                    binding.minTempValue.setText(String.valueOf(to.getTemp_min())+"\u2103");
                    binding.pressreValue.setText(String.valueOf(to.getPressure()));
                    binding.humidityValue.setText(String.valueOf(to.getHumidity()));
                    binding.cityName.setText(mausamData.getName());

                    List<weather> description = mausamData.getWeather();

                    for (weather data : description){

                        binding.description.setText(data.getDescription());
                    }
                }
            }

            @Override
            public void onFailure(Call<MausamData> call, Throwable t) {

            }
        });
    }
}