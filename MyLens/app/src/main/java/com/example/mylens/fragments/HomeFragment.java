package com.example.mylens.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mylens.R;
import com.example.mylens.db.LenteDAO;
import com.example.mylens.model.LenteUsada;

import java.util.List;

public class HomeFragment extends Fragment {

    private LenteDAO dao;
    private List<LenteUsada> lentesUsar;
    private LenteUsada item;


    public HomeFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        final TextView txt_oe_dias_restantes = view.findViewById(R.id.txt_oe_dias_restantes);
        final TextView txt_od_dias_restantes = view.findViewById(R.id.txt_od_dias_restantes);

        dao = new LenteDAO(getActivity());
        lentesUsar = dao.ObterUsar();


        if (lentesUsar != null && !lentesUsar.isEmpty()) {
            item = lentesUsar.get(lentesUsar.size() - 1);
        }

        String lenteDias = item.getDiasValidade().toString();
        long milliseconds = Long.parseLong(lenteDias) * 24 * 60 * 60 * 1000;
//        Toast.makeText(getContext(), ""+milliseconds, Toast.LENGTH_SHORT).show();


        new CountDownTimer(milliseconds, 86400000) {

            public void onTick(long millisUntilFinished) {
                txt_oe_dias_restantes.setText("" + millisUntilFinished / 86400000);
                txt_od_dias_restantes.setText("" + millisUntilFinished / 86400000);


            }

            public void onFinish() {
                txt_oe_dias_restantes.setText("0");
            }
        }.start();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView imageView = view.findViewById(R.id.img_case);
        imageView.setImageResource(R.drawable.estojo);


    }


}
