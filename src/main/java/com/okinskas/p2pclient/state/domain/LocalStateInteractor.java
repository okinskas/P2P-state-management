package com.okinskas.p2pclient.state.domain;

import java.net.DatagramSocket;
import java.net.SocketException;

public class LocalStateInteractor implements StateInteractor {

    private State state;
    private StateServer stateServer;
    private DatagramSocket socket;

    public LocalStateInteractor(State state) {
        this.state = state;
        initialiseServer();
    }

    private void initialiseServer() {
        try {
            socket = new DatagramSocket(4445);
            stateServer = new StateServer(state, socket);
            new Thread(stateServer).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public State updateState(State state) {
        this.state = state;
        return state;
    }

    @Override
    public State increment() {
        state.incrementTrackedInteger();
        return state;
    }

    @Override
    public State decrement() {
        state.decrementTrackedInteger();
        return state;
    }

    @Override
    public void end() {
        state = null;
        stateServer.end();
        socket.close();
    }
}
