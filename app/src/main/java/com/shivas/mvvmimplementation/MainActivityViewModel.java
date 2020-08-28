package com.shivas.mvvmimplementation;

import android.app.Application;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mRepo;

    private NoteDao mNoteDao;
    private NoteRoomDatabase mNoteRoomDatabase;

    public MainActivityViewModel(Application application) {
        super(application);

        mNoteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        mNoteDao = mNoteRoomDatabase.noteDao();

        if(mRepo == null) {
            mRepo = NicePlaceRepository.getInstance();
            mNicePlaces = mRepo.getNicePlaces();
        }
    }

    public void insert(Note note) {
        mNoteDao.insert(note);
    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        Log.d("Mallik", "MainActivityViewModel getNicePlaces callled");
        return mNicePlaces;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
