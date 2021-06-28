package com.example.appnote;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesFragment extends Fragment {
    private boolean isLandscape;
    private NotesAdapter notesAdapter;
    private NotesRepository repository = NotesRepositoryImpl.INSTANCE;
    private int longClikedIndex;
    private Note longClikedNote;

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notesAdapter = new NotesAdapter(this);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        RecyclerView notesList = view.findViewById(R.id.notes_list);
        notesList.setLayoutManager(new LinearLayoutManager(requireContext()));
        List<Note> notes = repository.getNotes();
        notesAdapter.setData(notes);
        notesAdapter.setListener(new NotesAdapter.OnNoteClickedListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onOnNoteClickedListener(@NonNull Note note) {

                if (requireActivity() instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) requireActivity();
                    mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container, FragmentDetail.newInstance(note)).addToBackStack(null).commit();
                }
            }
        });

        notesAdapter.setLongClickedListener(new NotesAdapter.OnNoteLongClickedListener() {
            @Override
            public void OnNoteLongClickedListener(@NonNull Note note, int index) {
                longClikedIndex = index;
                longClikedNote = note;
            }
        });
        notesList.setAdapter(notesAdapter);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.menu_notes_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_delete) {
            repository.deleteCardData(longClikedNote);
            notesAdapter.deleteCardData(longClikedNote);
            notesAdapter.notifyItemRemoved(longClikedIndex);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}