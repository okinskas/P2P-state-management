package com.okinskas.p2pclient.state.usecase;

import com.okinskas.p2pclient.state.domain.StateInteractor;
import com.okinskas.p2pclient.state.domain.State;

public class UpdateState {

    private StateInteractor stateInteractor;

    public UpdateState(StateInteractor stateInteractor) {
        this.stateInteractor = stateInteractor;
    }

    public State update(State state) {
        return stateInteractor.updateState(state);
    }
}
