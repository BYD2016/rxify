package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * Created by garimajain on 15/01/17.
 */

public final class ReducePresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    //Input
    Observable<String> inputValues = Observable.fromIterable(
            Arrays.asList("Color : Red", "Size : M", "Occasion : Casual", "Type : T-Shirt"));

    //TODO Concatenate filters to send to API
    //Print "Color : Red | Size : M | Occasion : Casual | Type : T-Shirt"

    @Inject
    public ReducePresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .reduce((old, value) -> old + " | " + value)
                .defaultIfEmpty("No item")
                .toObservable()
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
