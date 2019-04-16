package com.okinskas.p2pclient.state.usecase;

import com.okinskas.p2pclient.state.domain.StateInteractor;
import com.okinskas.p2pclient.state.domain.State;

public class ModifyTrackedInteger {

    private StateInteractor stateInteractor;

    public ModifyTrackedInteger(StateInteractor stateInteractor) {
        this.stateInteractor = stateInteractor;
    }

    public State increment() {
        return stateInteractor.increment();
    }

    public State decrement() {
        return stateInteractor.decrement();
    }
}
