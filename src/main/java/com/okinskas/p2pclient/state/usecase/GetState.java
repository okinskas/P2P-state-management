package com.okinskas.p2pclient.state.usecase;

import com.okinskas.p2pclient.state.domain.StateInteractor;
import com.okinskas.p2pclient.state.domain.State;

public class GetState {

    private StateInteractor stateInteractor;

    public GetState(StateInteractor stateInteractor) {
        this.stateInteractor = stateInteractor;
    }

    public State get() {
        return this.stateInteractor.getState();
    }
}
