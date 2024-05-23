package com.example.bones;

import android.annotation.SuppressLint;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bones.databinding.ActivityMainBinding;
import com.example.bones.databinding.FragmentHomeBinding;
public class Home extends Fragment {

    private FragmentHomeBinding binding;
    ActivityMainBinding mainBinding;
    NavController navController;
    private DrawerLayout drawerLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler refreshHandler = new Handler();
        final Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                Calendar rightNow = Calendar.getInstance(TimeZone.getDefault());
                int hora = rightNow.get(Calendar.HOUR_OF_DAY);
                int min = rightNow.get(Calendar.MINUTE);
                int sec = rightNow.get(Calendar.SECOND);
                int dia = rightNow.get(Calendar.DATE);
                int mes = rightNow.get(Calendar.MONTH) + 1;
                int ano = rightNow.get(Calendar.YEAR);
                binding.tiempo.setText(hora + " : " + min + " : " + sec);
                binding.dia.setText(dia + "/" + mes + "/" + ano);
                refreshHandler.postDelayed(this, 1000);
            }
        };
        refreshHandler.postDelayed(runnable, 1000);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.notif);
            }
        });
        binding.perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainBinding.navigationView.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container , false);
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainBinding = mainActivity.binding;
        return binding.getRoot();
    }
}