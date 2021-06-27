package com.example.appnote;

import java.util.List;

public interface NotesRepository {

    List<Note> getNotes();
    void deleteCardData(int position);
    void updateCardData(int position, Note note);
    Note add(String title, String data, String desc);
    void clearCardData();
}
