package com.example.architectureexample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    public void insert(Note note);

    @Update
    public void update(Note note);

    @Delete
    public void delete(Note note);

    @Query("DELETE FROM note_table")
    public void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    public LiveData<List<Note>> gelAllNotes();

}
