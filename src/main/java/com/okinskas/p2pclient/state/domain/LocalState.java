package com.okinskas.p2pclient.state.domain;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class LocalState implements State {

    private AtomicInteger updateCount;
    private AtomicInteger trackedInteger;

    public LocalState() {
        this.updateCount = new AtomicInteger(0);
        this.trackedInteger = new AtomicInteger(0);
    }

    public int incrementTrackedInteger() {
        updateCount.incrementAndGet();
        return trackedInteger.incrementAndGet();
    }

    public int decrementTrackedInteger() {
        updateCount.incrementAndGet();
        return trackedInteger.decrementAndGet();
    }

    @Override
    public int getUpdateCount() {
        return updateCount.get();
    }

    @Override
    public int getTrackedInteger() {
        return trackedInteger.get();
    }
}
