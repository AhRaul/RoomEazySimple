package com.example.roomeazysimple;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomeazysimple.daos.BrandListDao;
import com.example.roomeazysimple.daos.KategoryListDao;
import com.example.roomeazysimple.daos.PriceListDao;
import com.example.roomeazysimple.daos.TypeListDao;
import com.example.roomeazysimple.entityes.BrandListTable;
import com.example.roomeazysimple.entityes.KategoryListTable;
import com.example.roomeazysimple.entityes.PriceListTable;
import com.example.roomeazysimple.entityes.TypeListTable;

@Database(entities = {PriceListTable.class, BrandListTable.class, KategoryListTable.class, TypeListTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PriceListDao priceListDao();
    public abstract BrandListDao brandListDao();
    public abstract KategoryListDao kategoryListDao();
    public abstract TypeListDao typeListDao();
}
