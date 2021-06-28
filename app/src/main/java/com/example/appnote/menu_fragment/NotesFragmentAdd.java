package com.example.appnote.menu_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnote.NotesAdapter;
import com.example.appnote.NotesRepository;
import com.example.appnote.NotesRepositoryImpl;
import com.example.appnote.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NotesFragmentAdd extends Fragment {
    private final NotesRepository repository = NotesRepositoryImpl.INSTANCE;
    private final NotesAdapter notesAdapter = new NotesAdapter();

    public static NotesFragmentAdd newInstance() {
        NotesFragmentAdd fragment = new NotesFragmentAdd();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_notes_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextTitle = getActivity().findViewById(R.id.input_title);
        EditText editTextDescription = getActivity().findViewById(R.id.input_description);
        Button buttonAdd = getActivity().findViewById(R.id.add_note);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String date = format.format(Calendar.getInstance().getTime());

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.add(String.valueOf(editTextTitle.getText()), date, String.valueOf(editTextDescription.getText()));
                //Snackbar.make( view ,"Hello Android", Snackbar.LENGTH_LONG).show();
                notesAdapter.notifyDataSetChanged();
            }
        });
    }
}