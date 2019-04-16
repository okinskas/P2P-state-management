package com.okinskas.p2pclient.state;

import com.okinskas.p2pclient.state.domain.State;
import com.okinskas.p2pclient.state.usecase.GetState;
import com.okinskas.p2pclient.state.usecase.ModifyTrackedInteger;
import com.okinskas.p2pclient.state.usecase.UpdateState;

class StateController {

    private GetState getState;
    private UpdateState updateState;
    private ModifyTrackedInteger modifyTrackedInteger;

    public StateController(GetState getState,
                           UpdateState updateState,
                           ModifyTrackedInteger modifyTrackedInteger) {
        this.getState = getState;
        this.updateState = updateState;
        this.modifyTrackedInteger = modifyTrackedInteger;
    }

    public State getState() {
        return getState.get();
    }

    public State updateState(State state) {
        return updateState.update(state);
    }

    public State increment() {
        return modifyTrackedInteger.increment();
    }

    public State decrement() {
        return modifyTrackedInteger.decrement();
    }
}
