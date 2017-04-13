package com.ragdroid.rxify.codelab.presenter2;

import android.util.Log;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public final class ThreadingPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    public Observable<Integer> inputValues = Observable.defer(() -> {
        Log.d("Threading", "Creating observable on " + Thread.currentThread().getName());
        return Observable.range(1, 10);
    });

    public ThreadingPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }


    @Override
    protected Disposable getDisposable() {
        return inputValues
//                .subscribeOn(provider.computation())
//                .observeOn(provider.io())
                .doOnNext(integer -> Log.d("Threading", "Emitting " + integer
                        + " on " + Thread.currentThread().getName()))
//                .observeOn(provider.computation())
                .map(integer -> {
                    Log.d("Threading", "Mapping " + integer
                            + " on " + Thread.currentThread().getName());
                    return integer * 1000;
                })
//                .observeOn(provider.ui())
                .subscribe(integer -> Log.d("Threading", "Received " + integer
                        + " on " + Thread.currentThread().getName()));
    }


}
