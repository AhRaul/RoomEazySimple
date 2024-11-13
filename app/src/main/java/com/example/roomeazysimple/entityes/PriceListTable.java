package com.example.roomeazysimple.entityes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PriceListTable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "kategory_id")
    public long kategoryId;

    @ColumnInfo(name = "type_id")
    public long typeId;

    @ColumnInfo(name = "brand_id")
    public long brandId;

    public double price;

}
