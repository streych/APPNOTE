package com.example.appnote;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {
    public NotesRepositoryImpl() {
        notes.add(new Note("0", "Заметка 1", "01-01-2021", "Заметка 1 Заметка 1"));
        notes.add(new Note("1", "Заметка 2", "02-01-2021", "Заметка 2 Заметка 1"));
        notes.add(new Note("2", "Заметка 3", "03-01-2021", "Заметка 3 Заметка 1"));
        notes.add(new Note("3", "Заметка 4", "04-01-2021", "Заметка 4"));
        notes.add(new Note("4", "Заметка 5", "05-01-2021", "Заметка 5"));
        notes.add(new Note("5", "Заметка 6", "06-01-2021", "Заметка 6"));
        notes.add(new Note("6", "Заметка 7", "07-01-2021", "Заметка 7"));
        notes.add(new Note("7", "Заметка 8", "08-01-2021", "Заметка 8"));
        notes.add(new Note("8", "Заметка 9", "09-01-2021", "Заметка 9"));
        notes.add(new Note("9", "Заметка 10", "10-01-2021", "Заметка 10"));
    }



    public static final NotesRepository INSTANCE  = new NotesRepositoryImpl();

    private final ArrayList<Note> notes = new ArrayList<>();
    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public void deleteCardData(int position) {

    }

    @Override
    public void updateCardData(int position, Note note) {

    }

    @Override
    public Note add(String title, String data, String desc) {
        Note note = new Note(UUID.randomUUID().toString(), title, data, desc);
        notes.add(note);
        return note;
    }

    @Override
    public void clearCardData() {

    }
}
