package com.vlukashov.gridpaint.actions;

import com.vlukashov.gridpaint.redux.Action;

public class SetGridSize implements Action {
    private int width;
    private int height;

    public SetGridSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
