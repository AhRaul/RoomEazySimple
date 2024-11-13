package com.example.roomeazysimple.entityes;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class KategoryListTable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String kategoryName;

    public double discount;
}
