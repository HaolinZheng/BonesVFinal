package com.example.bones;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bones.databinding.ActivityMainBinding;
import com.example.bones.databinding.FragmentRegistroBinding;

public class Registro extends Fragment {

    FragmentRegistroBinding binding;
    ActivityMainBinding mainBinding;
    NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        ViewGroup.LayoutParams params = mainBinding.navHostFragment.getLayoutParams();
        binding.boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.eleccion);
            }
        });
        binding.boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevoTamanoEnPx = 650;
                nuevoTamanoEnPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, nuevoTamanoEnPx, getResources().getDisplayMetrics());
                params.height = nuevoTamanoEnPx;
                mainBinding.navHostFragment.setLayoutParams(params);
                mainBinding.bottomNavView.setVisibility(View.VISIBLE);
                navController.navigate(R.id.home);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainBinding = mainActivity.binding;
        return binding.getRoot();
    }
}