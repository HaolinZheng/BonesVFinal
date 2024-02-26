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
import com.example.bones.databinding.FragmentLogoBinding;

public class Eleccion extends Fragment {

    FragmentEleccionBinding binding;
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
                navController.navigate(R.id.registro);
            }
        });
        binding.boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.iniciosesion);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEleccionBinding.inflate(inflater, container, false);
        escribirTexto(binding.text1, "Bienvenido/a", 0);
        return binding.getRoot();
    }
    private void escribirTexto(final TextView textView, final String textoCompleto, final int indice) {
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (indice <= textoCompleto.length()) {
                textView.setText(textoCompleto.substring(0, indice));
                escribirTexto(textView, textoCompleto, indice + 1);
            } else {
                switch (textoCompleto) {
                    case "Bienvenido/a":
                        escribirTexto(binding.text2, "Doctor.........", 0);
                        break;
                    case "Doctor.........":
                        escribirTexto(binding.text3, "Espera,", 0);
                        break;
                    case "Espera,":
                        escribirTexto(binding.text4, "usted quien era?", 0);
                        break;
                    case "usted quien era?":
                        binding.boton1.setVisibility(View.VISIBLE);
                        binding.boton1.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.aparecion));
                        binding.boton2.setVisibility(View.VISIBLE);
                        binding.boton2.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.aparecion));
                        break;
                }
            }
        }, 50);
    }
}