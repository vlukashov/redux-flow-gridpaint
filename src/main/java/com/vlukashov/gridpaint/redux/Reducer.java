package com.vlukashov.gridpaint.redux;

public interface Reducer<State> {
    State reduce(State state, Action action);
}
