package com.shivas.mvvmimplementation;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);


}
