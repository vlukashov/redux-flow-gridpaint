package com.vlukashov.gridpaint;

import com.vaadin.flow.html.Div;
import com.vaadin.flow.html.H1;
import com.vaadin.flow.router.View;
import com.vaadin.ui.AttachEvent;
import com.vaadin.ui.Composite;
import com.vlukashov.gridpaint.components.Grid;
import com.vlukashov.gridpaint.redux.Store;

public class HomeView extends Composite<Div> implements View {

    private final Store<AppState> store;

    public HomeView() {
        final AppState initial = new AppState();
        initial.setWidth(10);
        initial.setHeight(10);
        initial.setCells(new int[] {
                0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 0, 1, 0, 0,
                0, 1, 0, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 1, 0, 0, 1, 0, 0, 1,
                1, 0, 0, 1, 0, 0, 1, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 1, 1, 1, 1, 0, 0, 1,
                0, 1, 0, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 1, 0, 0, 0, 0, 1, 0, 0,
                0, 0, 0, 1, 1, 1, 1, 0, 0, 0});
        final AppReducer reducer = new AppReducer();

        this.store = new Store<>(reducer, initial);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        getElement().setAttribute("style", "padding: 1rem;");
        getContent().add(
                new H1("Try tapping on the grid cells below to toggle their color:"),
                new Grid(store));
    }
}
