package com.example.bones;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.bones.databinding.FragmentLogoBinding;

import java.util.Objects;

public class Logo extends Fragment {

    private FragmentLogoBinding binding;
    NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.videoinicio;
        Uri uri = Uri.parse(videoPath);

        binding.video.setVideoURI(uri);
        binding.video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                binding.video.setVisibility(View.GONE);
                binding.texto.setVisibility(View.VISIBLE);
                binding.logo.setVisibility(View.VISIBLE);
                binding.boton.setVisibility(View.VISIBLE);
                binding.texto.startAnimation(AnimationUtils.loadAnimation(getView().getContext(), R.anim.parpadeo));
            }
        });

        binding.video.start();
        binding.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.eleccion);
                binding.texto.setVisibility(View.GONE);
                binding.logo.setVisibility(View.GONE);
                binding.video.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLogoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

}