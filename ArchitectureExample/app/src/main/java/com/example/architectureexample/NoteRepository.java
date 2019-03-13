package com.example.architectureexample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDAO = noteDatabase.noteDAO();
        allNotes = noteDAO.gelAllNotes();
    }

    public void insert(Note note){
        new InsertNoteAsyncTask(noteDAO).execute(note);
    }

    public void update(Note note){
        new UpdateNoteAsyncTask(noteDAO).execute(note);
    }

    public void delete(Note note){
        new DeleteNoteAsyncTask(noteDAO).execute(note);
    }

    public void deleteAllNotes(){
        new DeleteNoteAsyncTask(noteDAO).execute();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        private InsertNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        private UpdateNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        private DeleteNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void>{
        private NoteDAO noteDAO;

        private DeleteAllNotesAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAllNotes();
            return null;
        }
    }
}
