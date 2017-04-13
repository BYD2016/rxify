package com.ragdroid.rxify.codelab.presenter2;

import android.os.SystemClock;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

/**
 * Created by garimajain on 15/01/17.
 */

public final class FilterPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    //Input
    Observable<Integer> inputValues = Observable.range(0,10);

    //TODO Print all even numbers

    @Inject
    public FilterPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .filter(integer -> integer % 2 == 0)
                .doOnNext( item -> SystemClock.sleep(1000) )
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
