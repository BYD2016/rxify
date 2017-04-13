package com.ragdroid.rxify.codelab.presenter;

import android.os.SystemClock;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public final class RangePresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    @Inject
    public RangePresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.range(1, 10)
                .doOnNext(item -> SystemClock.sleep(1000))
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
