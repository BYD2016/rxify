package com.ragdroid.rxify.codelab.presenter;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public final class NeverPresenter extends BaseCLPresenter<Object> implements CodeLabContract.Presenter {

    @Inject
    public NeverPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.never()
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
