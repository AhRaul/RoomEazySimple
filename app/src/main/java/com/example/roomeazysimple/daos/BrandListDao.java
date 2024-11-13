package com.example.roomeazysimple.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomeazysimple.entityes.BrandListTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface BrandListDao {

    @Query("SELECT * FROM BrandListTable")
    Flowable<List<BrandListTable>> getAll();

    @Query("SELECT * FROM BrandListTable WHERE id = :id")
    Maybe<BrandListTable> getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(BrandListTable brand);

    @Update
    Completable update(BrandListTable brand);

    @Delete
    Completable delete(BrandListTable brand);
}
