package com.example.roomeazysimple.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomeazysimple.entityes.PriceListRelated;
import com.example.roomeazysimple.entityes.PriceListTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface PriceListDao {

    //TODO вывод связанных таблиц, задача на будущее
//    @Query("SELECT PriceListTable.id, KategoryListTable.kategoryName AS kategory_name, " +
//            "TypeListTable.typeName AS type_name, BrandListTable.brandName AS brand_name, " +
//            "PriceListTable.price, KategoryListTable.discount AS kategory_discount " +
//            "FROM PriceListTable, KategoryListTable, TypeListTable, BrandListTable " +
//            "WHERE BrandListTable.id == PriceListTable.brand_id & " +
//            "KategoryListTable.id == PriceListTable.kategory_id & " +
//            "TypeListTable.id == PriceListTable.type_id")
//    Flowable<List<PriceListRelated>> getAllWithRelation();

    @Query("SELECT * FROM PriceListTable")
    Flowable<List<PriceListTable>> getAll();

    @Query("SELECT * FROM PriceListTable WHERE id = :id")
    Maybe<PriceListTable> getById(long id);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    Completable insert(PriceListTable priceListTableProduct);

    @Update
    Completable update(PriceListTable priceListTableProduct);

    @Delete
    Completable delete(PriceListTable priceListTableProduct);
}

