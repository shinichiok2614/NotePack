package com.example.notepack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "NoteDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE NoteTB (id INTEGER PRIMARY KEY, title TEXT,  TEXT, data TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNote(note.Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("data", note.getData());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("NoteDB", null, contentValues);
        db.close();
    }

    public note.Note getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("NoteDB", new String[]{"id", "title", "data"}, "id" + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        note.Note note = new note.Note(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2)
        );
        cursor.close();
        return note;
    }
}
