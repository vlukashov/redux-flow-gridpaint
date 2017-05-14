package com.vlukashov.gridpaint.actions;

import com.vlukashov.gridpaint.redux.Action;

public class ToggleCell implements Action{
    private int w;
    private int h;

    public ToggleCell(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
