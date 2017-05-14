package com.vlukashov.gridpaint.redux;

import java.util.LinkedHashSet;

public final class Store<State> {

    public interface Listener {
        void onStateChanged();
    }

    public interface Subscription {
        void unsubscribe();
    }

    public Store(Reducer<State> reducer, State initialState) {
        this.reducer = reducer;
        this.state = initialState;
    }

    public State getState() {
        return this.state;
    }

    public void dispatch(Action action) {
        this.state = this.reducer.reduce(this.state, action);
        this.subscriptions.forEach(StoreSubscription::onStateChanged);
    }

    public Subscription subscribe(Listener listener) {
        return new StoreSubscription(listener);
    }

    private State state;
    private Reducer<State> reducer;
    private LinkedHashSet<StoreSubscription> subscriptions = new LinkedHashSet<>();

    private class StoreSubscription implements Subscription {
        private Listener listener;

        StoreSubscription(Listener listener) {
            this.listener = listener;
            subscriptions.add(this);
        }

        void onStateChanged() {
            this.listener.onStateChanged();
        }

        @Override
        public void unsubscribe() {
            subscriptions.remove(this);
        }
    }
}