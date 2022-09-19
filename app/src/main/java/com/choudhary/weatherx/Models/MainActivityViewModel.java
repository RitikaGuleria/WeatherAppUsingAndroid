package com.choudhary.weatherx.Models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel
{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int humidity;

        MutableLiveData<Double> mutableLiveData_temp=new MutableLiveData<Double>();
        MutableLiveData<Double> mutableLiveData_feels_like=new MutableLiveData<Double>();
        MutableLiveData<Double> mutableLiveData_mintemp=new MutableLiveData<Double>();
        MutableLiveData<Double> mutableLiveData_maxtemp=new MutableLiveData<Double>();
        MutableLiveData<Integer> mutableLiveData_pressure=new MutableLiveData<Integer>();
        MutableLiveData<Integer> mutableLiveData_humidity=new MutableLiveData<Integer>();

        public MutableLiveData<Double> getTemp()
        {
            mutableLiveData_temp.setValue(temp);
            return mutableLiveData_temp;
        }
        public void setTemp(Double temp)
        {
            mutableLiveData_temp.setValue(temp);
        }

        public MutableLiveData<Double> getFeels_like()
        {
            mutableLiveData_feels_like.setValue(feels_like);
            return mutableLiveData_feels_like;
        }
        public void setFeels_like(Double feels_like)
        {
            mutableLiveData_feels_like.setValue(feels_like);
        }

        public  MutableLiveData<Double> getMinTemp()
        {
            mutableLiveData_mintemp.setValue(temp_min);
            return mutableLiveData_mintemp;
        }
        public void setTemp_min(Double temp_min)
        {
            mutableLiveData_mintemp.setValue(temp_min);
        }

        public  MutableLiveData<Double> getMaxTemp()
        {
            mutableLiveData_maxtemp.setValue(temp_min);
            return mutableLiveData_maxtemp;
        }
        public void setTemp_max(Double temp_max)
        {
            mutableLiveData_mintemp.setValue(temp_max);
        }

        public  MutableLiveData<Integer> getHumidity()
        {
            mutableLiveData_humidity.setValue(humidity);
            return mutableLiveData_humidity;
        }
        public void setHumidity(Integer humidity)
        {
            mutableLiveData_humidity.setValue(humidity);
        }

        public  MutableLiveData<Integer> getPressure()
        {
            mutableLiveData_pressure.setValue(pressure);
            return mutableLiveData_pressure;
        }
        public void setPressure(Integer pressure)
        {
            mutableLiveData_pressure.setValue(pressure);
        }
}

