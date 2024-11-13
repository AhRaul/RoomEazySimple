package com.example.roomeazysimple.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomeazysimple.entityes.KategoryListTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface KategoryListDao {

    @Query("SELECT * FROM KategoryListTable")
    Flowable <List<KategoryListTable>> getAll();

    @Query("SELECT * FROM KategoryListTable WHERE id = :id")
    Maybe<KategoryListTable> getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(final KategoryListTable kategory);

    @Update
    Completable update(KategoryListTable kategory);

    @Delete
    Completable delete(KategoryListTable kategory);
}
