package com.vlukashov.gridpaint;

import com.vlukashov.gridpaint.actions.SetGridSize;
import com.vlukashov.gridpaint.actions.ToggleCell;
import com.vlukashov.gridpaint.redux.Action;
import com.vlukashov.gridpaint.redux.Reducer;

import java.util.Arrays;

public class AppReducer implements Reducer<AppState> {
    public AppState reduce(AppState state, Action action) {
        if (action instanceof SetGridSize) {
            final AppState newState = new AppState();
            SetGridSize typedAction = (SetGridSize) action;

            int[] newCells = new int[typedAction.getWidth() * typedAction.getHeight()];
            for (int w = 0; w < typedAction.getWidth(); w += 1) {
                for (int h = 0; h < typedAction.getHeight(); h += 1) {
                    newCells[w * typedAction.getWidth() + h] =
                            w < state.getWidth() && h < state.getHeight()
                                    ? state.getCells()[w * state.getWidth() + h]
                                    : 0;
                }
            }

            newState.setWidth(typedAction.getWidth());
            newState.setHeight(typedAction.getHeight());
            newState.setCells(newCells);
            return newState;
        } else if (action instanceof ToggleCell) {
            final AppState newState = new AppState();
            ToggleCell typedAction = (ToggleCell) action;

            int[] newCells = Arrays.copyOf(state.getCells(), state.getCells().length);
            newCells[typedAction.getW() * state.getWidth() + typedAction.getH()] =
                    newCells[typedAction.getW() * state.getWidth() + typedAction.getH()] == 1 ? 0 : 1;

            newState.setWidth(state.getWidth());
            newState.setHeight(state.getHeight());
            newState.setCells(newCells);
            return newState;
        }

        return state;
    }
}
