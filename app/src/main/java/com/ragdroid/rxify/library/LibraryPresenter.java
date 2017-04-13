package com.ragdroid.rxify.library;

import android.util.Log;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.data.BookDataSource;
import com.ragdroid.rxify.entity.Book;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by garimajain on 08/11/16.
 */

public final class LibraryPresenter extends AbstractPresenter<LibraryContract.View> implements
        LibraryContract.Presenter {

    private static final String TAG = LibraryPresenter.class.getSimpleName();
    private final BookDataSource dataSource;

    PublishSubject<String> subject = PublishSubject.create();

    private Disposable disposable;
    private boolean mAutoSearch = false;

    @Inject
    public LibraryPresenter(BookDataSource dataSource,
                            BaseSchedulerProvider provider) {
        super(provider);
        this.dataSource = dataSource;
    }

    @Override
    public void subscribe() {
        if (disposable == null) {
            initDisposable();
        }
    }

    private void initDisposable() {
        if (mAutoSearch) {
            disposable = subject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .switchMap( s -> {
                            Log.d(TAG, "getting books for " + s);
                            return dataSource.getBooksJinxed(s);
                        }
                    )
                    .subscribeOn(provider.io())
                    .observeOn(provider.ui())
                    .subscribe(this::onBooksFetched);
        } else {
            disposable = subject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .observeOn(provider.io())
                    .flatMap( dataSource::getBooksJinxed)
                    .subscribeOn(provider.io())
                    .observeOn(provider.ui())
                    .subscribe(this::onBooksFetched);
        }
    }

    private void onBooksFetched(List<Book> books) {
        if (getView() != null) {
            getView().showBooks(books);
        }
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

    @Override
    public void onQueryTextChange(final String newText) {
        if (newText == null || newText.length() == 0) {
            onBooksFetched(new ArrayList<Book>());
        } else {
            subject.onNext(newText);
        }

    }

    @Override
    public boolean isAutoSearch() {
        return mAutoSearch;
    }

    @Override
    public void onFixBugToggleClicked() {
        this.mAutoSearch = !mAutoSearch;
        unsubscribe();
        initDisposable();
    }
}
