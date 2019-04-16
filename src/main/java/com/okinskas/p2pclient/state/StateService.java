package com.okinskas.p2pclient.state;

import com.okinskas.p2pclient.state.domain.State;
import com.okinskas.p2pclient.state.domain.StateInteractor;
import com.okinskas.p2pclient.state.usecase.GetState;
import com.okinskas.p2pclient.state.usecase.ModifyTrackedInteger;
import com.okinskas.p2pclient.state.usecase.UpdateState;

public class StateService {

    private StateController stateController;

    public StateService(StateInteractor stateInteractor) {
        this.stateController = new StateController(
                new GetState(stateInteractor),
                new UpdateState(stateInteractor),
                new ModifyTrackedInteger(stateInteractor)
        );
    }

    public State getState() {
        return stateController.getState();
    }

    public State updateState(State state) {
        return stateController.updateState(state);
    }

    public State increment() {
        return stateController.increment();
    }

    public State decrement() {
        return stateController.decrement();
    }
}
