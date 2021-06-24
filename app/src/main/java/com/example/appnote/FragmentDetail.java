package com.example.appnote;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetail extends Fragment {
    public static final String TAG = "DetailsFragment";
    private static final String ARG_NOTE = "ARG_NOTE";

    public static FragmentDetail newInstance(Note note) {
        FragmentDetail fragment = new FragmentDetail();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView title = view.findViewById(R.id.newTitle);
        TextView data = view.findViewById(R.id.newDate);
        TextView description = view.findViewById(R.id.newDescription);
        if (getArguments() != null) {
            Note note = getArguments().getParcelable(ARG_NOTE);
            title.setText(note.getTitle());
            title.setTextSize(50);
            data.setText(note.getDate());
            description.setText(note.getDescription());
            description.setTextSize(30);

        }

    }
}