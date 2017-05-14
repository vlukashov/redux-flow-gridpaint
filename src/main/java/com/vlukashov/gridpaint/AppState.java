package com.vlukashov.gridpaint;

public class AppState {
    public AppState() {
    }

    public AppState(int width, int height, int[] cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getCells() {
        return cells;
    }

    public void setCells(int[] cells) {
        this.cells = cells;
    }

    private int width;
    private int height;
    private int[] cells;
}
