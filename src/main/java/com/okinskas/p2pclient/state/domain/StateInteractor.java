package com.okinskas.p2pclient.state.domain;

public interface StateInteractor {

    State getState();
    State updateState(State state);
    State increment();
    State decrement();
    void end();
}
