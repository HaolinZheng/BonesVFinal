package com.example.bones;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.bones.databinding.FragmentEleccionBinding;
import com.example.bones.databinding.FragmentEstrategiaBinding;
import com.example.bones.databinding.FragmentLogoBinding;
import com.example.bones.databinding.FragmentMapaEBinding;
import com.example.bones.databinding.FragmentMapaHBinding;
import com.example.bones.databinding.FragmentPostBinding;
import com.example.bones.databinding.FragmentPostDBinding;

public class PostD extends Fragment {

    FragmentPostDBinding binding;
    NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.postF);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostDBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}