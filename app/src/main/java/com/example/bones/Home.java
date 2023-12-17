package com.example.bones;

import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bones.databinding.FragmentHomeBinding;
public class Home extends Fragment {

    private FragmentHomeBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler refreshHandler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Calendar rightNow = Calendar.getInstance(TimeZone.getDefault());
                int hora = rightNow.get(Calendar.HOUR_OF_DAY);
                int min = rightNow.get(Calendar.MINUTE);
                int sec = rightNow.get(Calendar.SECOND);
                binding.tiempo.setText(hora + ":" + min + ":" + sec);
                refreshHandler.postDelayed(this, 1000);
            }
        };
        refreshHandler.postDelayed(runnable, 1000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container , false);
        return binding.getRoot();
    }
}