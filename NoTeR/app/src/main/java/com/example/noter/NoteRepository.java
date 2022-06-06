package com.example.noter;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private  NoteDao noteDao;
    private LiveData<List<Note>> notes;

    ExecutorService executors = Executors.newSingleThreadExecutor();

    public NoteRepository(Application application){

        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao  =database.noteDao();
        notes = noteDao.getAllNotes();


    }

    public void insert(Note note){

      //  new InsertNotesAsyncTask(noteDao).execute(note);

        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });

    }
    public void update1(Note note){

    //    new UpdateNotesAsyncTask(noteDao).execute(note);

        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.update1(note);
            }
        });


    }
    public void delete(Note note){

     //   new DeleteNotesAsyncTask(noteDao).execute(note);
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });

    }
    public LiveData<List<Note>> getAllNotes(){

        return notes;
    }

    /*
    private static  class InsertNotesAsyncTask extends AsyncTask<Note,Void,Void> {


        private NoteDao noteDao;

        private InsertNotesAsyncTask(NoteDao noteDao){
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.insert(notes[0]);
            return null;
        }
    }


    private static  class UpdateNotesAsyncTask extends AsyncTask<Note,Void,Void> {


        private NoteDao noteDao;

        private UpdateNotesAsyncTask(NoteDao noteDao){
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.update(notes[0]);
            return null;
        }
    }


    private static  class DeleteNotesAsyncTask extends AsyncTask<Note,Void,Void> {


        private NoteDao noteDao;

        private DeleteNotesAsyncTask(NoteDao noteDao){
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.delete(notes[0]);
            return null;
        }
    }

     */

}
