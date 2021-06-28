package com.example.appnote;

import android.text.Editable;

import java.util.List;

public interface NotesRepository {

    List<Note> getNotes();
    void deleteCardData(Note note);
    Note update(int id, String title, String data, String desc);
    Note add(String title, String data, String desc);
    void clearCardData();
}
