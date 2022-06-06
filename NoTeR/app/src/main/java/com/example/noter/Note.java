package com.example.noter;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public  int id ;

    public  String tile;
    public String description;

    public Note(String tile, String description) {
        this.tile = tile;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTile() {
        return tile;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
