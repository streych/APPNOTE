package com.example.appnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{

    public interface OnNoteClickedListener{
        void onOnNoteClickedListener(@NonNull Note note);
    }

    private List<Note> notes = new ArrayList<>();

    public void setData(List<Note> toSet){
        notes.clear();
        notes.addAll(toSet);
    }

    private OnNoteClickedListener listener;

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
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (getListener() != null){
                       getListener().onOnNoteClickedListener(notes.get(getAdapterPosition()));
                   }
               }
           });
            title = itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.data);
        }
    }
}
