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
import com.example.bones.databinding.FragmentIniciosesionBinding;
import com.example.bones.databinding.FragmentNotifBinding;
import com.example.bones.databinding.FragmentOperatorBinding;

public class operator extends Fragment {

    FragmentOperatorBinding binding;
    NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOperatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}