package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public final class FlatMapPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    Observable<String> inputValues = Observable.fromIterable(Arrays.asList("Hello World!", "How Are You?"));

    //TODO Print all the words from strings

    @Inject
    public FlatMapPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .flatMap( inputString ->
                         Observable.fromArray(inputString.split(" "))
                )
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
