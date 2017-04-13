package com.ragdroid.rxify.codelab.presenter;

import android.os.SystemClock;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public final class FromPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    @Inject
    public FromPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.defer( () -> {
            SystemClock.sleep(2000); // 2s
            return Observable.fromIterable(Arrays.asList(1, 2, 3, 4, 5, 6));
        } )
        .compose(lazyTransformer)
        .subscribe(next, error, complete);
    }
}
