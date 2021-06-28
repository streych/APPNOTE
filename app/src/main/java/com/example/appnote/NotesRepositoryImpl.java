package com.example.appnote;

import android.text.Editable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {
    public NotesRepositoryImpl() {
        notes.add(new Note(0, "Заметка 1", "01-01-2021", "Заметка 1 Заметка 1"));
        notes.add(new Note(1, "Заметка 2", "02-01-2021", "Заметка 2 Заметка 1"));
        notes.add(new Note(2, "Заметка 3", "03-01-2021", "Заметка 3 Заметка 1"));
        notes.add(new Note(3, "Заметка 4", "04-01-2021", "Заметка 4"));
        notes.add(new Note(4, "Заметка 5", "05-01-2021", "Заметка 5"));
        notes.add(new Note(5, "Заметка 6", "06-01-2021", "Заметка 6"));
        notes.add(new Note(6, "Заметка 7", "07-01-2021", "Заметка 7"));
        notes.add(new Note(7, "Заметка 8", "08-01-2021", "Заметка 8"));
        notes.add(new Note(8, "Заметка 9", "09-01-2021", "Заметка 9"));
        notes.add(new Note(9, "Заметка 10", "10-01-2021", "Заметка 10"));
    }



    public static final NotesRepository INSTANCE  = new NotesRepositoryImpl();

    private final ArrayList<Note> notes = new ArrayList<>();
    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public void deleteCardData(Note note) {
        notes.remove(note);
    }

    @Override
    public Note update(int id, String title, String data, String desc) {
        Note note = new Note(id, title, data, desc);
        for (int i = 0; i < notes.size(); i++){
            Note item = notes.get(i);

            if (item.getId() == id){

                notes.add(0, note);
                notes.remove(i);
            }
        }
        return note;
    }

    @Override
    public Note add(String title, String data, String desc) {
        Random random = new Random();
        int ran = random.nextInt() * 1000;
        Note note = new Note(ran, title, data, desc);
        notes.add(0, note);
        return note;
    }

    @Override
    public void clearCardData() {

    }
}
