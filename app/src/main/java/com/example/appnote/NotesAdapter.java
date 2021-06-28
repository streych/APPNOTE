package com.example.appnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{


    public void deleteCardData(Note longClikedNote) {
        notes.remove(longClikedNote);
    }

    public interface OnNoteClickedListener{
        void onOnNoteClickedListener(@NonNull Note note);
    }

    public interface OnNoteLongClickedListener{
        void OnNoteLongClickedListener(@NonNull Note note, int index);
    }

    private Fragment fragment;

    private List<Note> notes = new ArrayList<>();
    public NotesAdapter(Fragment fragment) {
        this.fragment = fragment;
    }
    public void setData(List<Note> toSet){
        notes.clear();
        notes.addAll(toSet);
    }

    private OnNoteClickedListener listener;

    public OnNoteLongClickedListener getLongClickedListener() {
        return longClickedListener;
    }

    public void setLongClickedListener(OnNoteLongClickedListener longClickedListener) {
        this.longClickedListener = longClickedListener;
    }

    private OnNoteLongClickedListener longClickedListener;

    public OnNoteClickedListener getListener() {
        return listener;
    }

    public void setListener(OnNoteClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemVirew = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemVirew);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title.setText(note.getTitle());
        holder.data.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView data;
        public NoteViewHolder(@NonNull View itemView){
            super(itemView);
            fragment.registerForContextMenu(itemView);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (getListener() != null){
                       getListener().onOnNoteClickedListener(notes.get(getAdapterPosition()));
                   }
               }
           });

           itemView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View v) {
                   itemView.showContextMenu();
                   if (getLongClickedListener() != null){
                       int index = getAdapterPosition();
                       getLongClickedListener().OnNoteLongClickedListener(notes.get(index), index);
                   }
                   return true;
               }
           });
            title = itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.data);
        }
    }

}

