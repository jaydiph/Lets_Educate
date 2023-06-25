package com.example.lets_educate.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lets_educate.R;
import com.example.lets_educate.databinding.FragmentTeacherHomeBinding;

public class TeacherHomeFragment extends Fragment {

    FragmentTeacherHomeBinding binding;
    public TeacherHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTeacherHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}