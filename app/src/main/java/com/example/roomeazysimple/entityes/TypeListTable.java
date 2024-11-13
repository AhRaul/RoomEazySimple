package com.example.roomeazysimple.entityes;

import androidx.room.Entity;
        import androidx.room.PrimaryKey;

@Entity
public class TypeListTable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String typeName;
}
