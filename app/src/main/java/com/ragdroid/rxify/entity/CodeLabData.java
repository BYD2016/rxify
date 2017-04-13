package com.ragdroid.rxify.entity;

import com.ragdroid.rxify.codelab.ChillPresenter;
import com.ragdroid.rxify.codelab.presenter.EmptyPresenter;
import com.ragdroid.rxify.codelab.presenter.ErrorPresenter;
import com.ragdroid.rxify.codelab.presenter.FromPresenter;
import com.ragdroid.rxify.codelab.presenter.IntervalPresenter;
import com.ragdroid.rxify.codelab.presenter.IntervalRangePresenter;
import com.ragdroid.rxify.codelab.presenter.JustPresenter;
import com.ragdroid.rxify.codelab.presenter.NeverPresenter;
import com.ragdroid.rxify.codelab.presenter.RangePresenter;
import com.ragdroid.rxify.codelab.presenter.TimerPresenter;
import com.ragdroid.rxify.codelab.presenter2.AssignmentPresenter;
import com.ragdroid.rxify.codelab.presenter2.BattleFlowPresenter;
import com.ragdroid.rxify.codelab.presenter2.BattlePresenter;
import com.ragdroid.rxify.codelab.presenter2.DistinctPresenter;
import com.ragdroid.rxify.codelab.presenter2.FilterPresenter;
import com.ragdroid.rxify.codelab.presenter2.FlatMapPresenter;
import com.ragdroid.rxify.codelab.presenter2.MapPresenter;
import com.ragdroid.rxify.codelab.presenter2.ReducePresenter;
import com.ragdroid.rxify.codelab.presenter2.SkipPresenter;
import com.ragdroid.rxify.codelab.presenter2.TakePresenter;
import com.ragdroid.rxify.codelab.presenter2.TakeUntilPresenter;
import com.ragdroid.rxify.codelab.presenter2.ThreadingPresenter;

/**
 * Created by garimajain on 18/03/17.
 */

public enum CodeLabData {

    EMPTY(0, "empty"),
    JUST(1, "just"),
    FROM(2, "from"),
    NEVER(3, "never"),
    INTERVAL(4, "interval"),
    ERROR(5, "Error BOOM!"),
    RANGE(6, "ranger"),
    INTERVAL_RANGE(7, "intervalRange"),
    TIMER(8, "timer"),
    FILTER(9, "filter"),
    DISTINCT(10, "distinct"),
    TAKE(11, "take"),
    TAKE_UNTIL(12, "takeUntil"),
    SKIP(13, "skip"),
    REDUCE(14, "reduce"),
    MAP(15, "map"),
    FLATMAP(16, "flatMap"),
    ASSIGNMENT(17, "mergeWith"),
    BATTLE(18, "The Battle"),
    BATTLE_FLOW(19, "The Battle Flow"),
    THREAD(20, "Threading"),
    CHILL(21, "ChilledOut"),
    TIME_TURNER(22, "TimeTurner");


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    CodeLabData(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public static CodeLabData getCodeLab(int id) {
        switch (id) {
            case 0 :
                return EMPTY;
            case 1 :
                return JUST;
            case 2 :
                return FROM;
            case 3 :
                return NEVER;
            case 4 :
                return INTERVAL;
            case 5 :
                return ERROR;
            case 6 :
                return RANGE;
            case 7 :
                return INTERVAL_RANGE;
            case 8 :
                return TIMER;
            case 9 :
                return FILTER;
            case 10:
                return DISTINCT;
            case 11:
                return TAKE;
            case 12:
                return TAKE_UNTIL;
            case 13:
                return SKIP;
            case 14:
                return REDUCE;
            case 15:
                return MAP;
            case 16:
                return FLATMAP;
            case 17:
                return ASSIGNMENT;
            case 18:
                return BATTLE;
            case 19:
                return BATTLE_FLOW;
            case 20:
                return THREAD;
            case 22:
                return TIME_TURNER;
            case 21:
            default:
                return CHILL;
        }
    }

    private final String name;
    private final int id;

}
