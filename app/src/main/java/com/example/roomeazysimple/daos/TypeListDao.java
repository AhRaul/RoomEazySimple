package com.example.roomeazysimple.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.roomeazysimple.entityes.TypeListTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface TypeListDao {

    @Query("SELECT * FROM TypeListTable")
    Flowable<List<TypeListTable>> getAll();

    @Query("SELECT * FROM TypeListTable WHERE id = :id")
    Maybe<TypeListTable> getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(TypeListTable type);

    @Update
    Completable update(TypeListTable type);

    @Delete
    Completable delete(TypeListTable type);
}
