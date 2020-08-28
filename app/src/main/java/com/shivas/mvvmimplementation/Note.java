package com.shivas.mvvmimplementation;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey
    @NonNull
    String id;

    @NonNull
    @ColumnInfo(name = "note")
    String mNote;

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", mNote='" + mNote + '\'' +
                '}';
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getmNote() {
        return mNote;
    }

    public void setmNote(@NonNull String mNote) {
        this.mNote = mNote;
    }

    public Note(@NonNull String id, @NonNull String mNote) {
        this.id = id;
        this.mNote = mNote;
    }
}
