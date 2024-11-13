package com.example.roomeazysimple;

        import android.util.Log;

        import androidx.room.ColumnInfo;

        import com.example.roomeazysimple.app.App;
        import com.example.roomeazysimple.daos.BrandListDao;
        import com.example.roomeazysimple.daos.KategoryListDao;
        import com.example.roomeazysimple.daos.PriceListDao;
        import com.example.roomeazysimple.daos.TypeListDao;
        import com.example.roomeazysimple.entityes.KategoryListTable;
        import com.example.roomeazysimple.entityes.PriceListRelated;

        import java.util.List;

        import io.reactivex.android.schedulers.AndroidSchedulers;
        import io.reactivex.disposables.Disposable;
        import io.reactivex.functions.Action;
        import io.reactivex.functions.Consumer;
        import io.reactivex.observers.DisposableMaybeObserver;
        import io.reactivex.schedulers.Schedulers;

public class DbHelper {

    AppDatabase db = App.getInstance().getDatabase();
    PriceListDao priceListDao = db.priceListDao();
    BrandListDao brandListDao = db.brandListDao();
    KategoryListDao kategoryListDao = db.kategoryListDao();
    TypeListDao typeListDao = db.typeListDao();

    //TODO временный демонстративный метод, добавление готовой тестовой категории
    public void setNewPreparedCategory() {
        KategoryListTable kategoryListTable = new KategoryListTable();
        kategoryListTable.kategoryName = "Женская одежда";
        kategoryListTable.discount = 15.0;
        setNewCategory(kategoryListTable);
    }

    //добавление категории в базу данных
    public void setNewCategory(KategoryListTable preparedKategoryList) {

        final Disposable subscribe = kategoryListDao.insert(preparedKategoryList)
                .subscribeOn(Schedulers.computation())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("DbHelper", "успешное добавление категории");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("DbHelper", "добавление категории облом");
                    }
                });

    }

    //TODO временный демонстративный метод, обновление готовой тестовой категории
    public void updatePreparedCategory() {
        KategoryListTable kategoryListTable = new KategoryListTable();
        kategoryListTable.kategoryName = "Мужская одежда";
        kategoryListTable.discount = 15.0;
        kategoryListTable.id = 5;
        updateCategory(kategoryListTable);
    }

    //обновление категории в другом потоке
    public void updateCategory(KategoryListTable preparedKategoryList) {

        final Disposable subscribe = kategoryListDao.update(preparedKategoryList)
                .subscribeOn(Schedulers.io()).subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("DbHelper", "успешное обновление");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("DbHelper", "обновление облом");
                    }
                });

    }

    //TODO временный демонстративный метод, удаление готовой тестовой категории
    public void deletePreparedCategory() {
        KategoryListTable kategoryListTable = new KategoryListTable();
        kategoryListTable.id = 7;
        deleteCategory(kategoryListTable);
    }

    //метод удаления выбранной категории
    public void deleteCategory(KategoryListTable preparedKategoryList) {

        final Disposable subscribe = kategoryListDao.delete(preparedKategoryList)
                .subscribeOn(Schedulers.io()).subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("DbHelper", "успешное удаление");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("DbHelper", "удаление облом");
                    }
                });

    }

    //получение таблицы категорий в другом потоке
    public void getAllKategories() {
        kategoryListDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<KategoryListTable>>() {
                    @Override
                    public void accept(List<KategoryListTable> kategoryListTables) throws Exception {
                        printKategoryLogs(kategoryListTables);
                    }
                });
    }

    //TODO демонстративный временный метод, вывод категорий в логи
    public void printKategoryLogs(List<KategoryListTable> kategoryListTables) {
        for (int i = 0; i<kategoryListTables.size(); i++) {
            Log.d("DbHelper", String.valueOf(kategoryListTables.get(i).id)
                    + " " + String.valueOf(kategoryListTables.get(i).kategoryName)
                    + " " + String.valueOf(kategoryListTables.get(i).discount));
        }
    }

    //получение одной категории в другом потоке
    public void getKategoryById(long id) {
        kategoryListDao.getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableMaybeObserver<KategoryListTable>() {
                    @Override
                    public void onSuccess(KategoryListTable kategoryListTable) {
                        printKategoryLogs(kategoryListTable);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("DbHelper", "Get by id error!");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("DbHelper", "The category is not found");
                    }
                });
    }

    //TODO демонстративный временный метод, вывод одной категории в логи
    public void printKategoryLogs(KategoryListTable kategoryListTables) {
        Log.d("DbHelper", String.valueOf(kategoryListTables.id)
                + " " + String.valueOf(kategoryListTables.kategoryName)
                + " " + String.valueOf(kategoryListTables.discount));
    }
}
