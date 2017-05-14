package com.vlukashov.gridpaint.components;

import com.vaadin.annotations.EventData;
import com.vaadin.annotations.EventHandler;
import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.Tag;
import com.vaadin.flow.template.PolymerTemplate;
import com.vaadin.flow.template.model.TemplateModel;
import com.vaadin.ui.AttachEvent;
import com.vaadin.ui.DetachEvent;
import com.vlukashov.gridpaint.AppState;
import com.vlukashov.gridpaint.actions.ToggleCell;
import com.vlukashov.gridpaint.redux.Store;

import java.util.*;
import java.util.stream.Collectors;

@Tag("x-grid")
@HtmlImport("components/x-grid.html")
public class Grid extends PolymerTemplate<Grid.Model> {

    private final Store<AppState> store;
    private Store.Subscription subscription;

    public Grid(Store<AppState> store) {
        this.store = store;
    }

    public static class Cell {
        private boolean isFilled;

        public Cell() {
            this.isFilled = false;
        }

        public Cell(boolean isFilled) {
            this.isFilled = isFilled;
        }

        public boolean getIsFilled() {
            return isFilled;
        }
    }

    public interface Model extends TemplateModel {
        void setWidth(int width);
        void setHeight(int height);
        void setCells(List<Cell> cells);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        this.subscription = this.store.subscribe(this::render);
        render();
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        this.subscription.unsubscribe();
    }

    private void render() {
        final AppState state = this.store.getState();

        getModel().setWidth(state.getWidth());
        getModel().setHeight(state.getHeight());
        getModel().setCells(
                Arrays.stream(state.getCells())
                        .mapToObj(i -> new Cell(i > 0))
                        .collect(Collectors.toList()));
    }

    @EventHandler
    private void toggleCell(
            @EventData("event.model.cell.w") int w,
            @EventData("event.model.cell.h") int h) {
        store.dispatch(new ToggleCell(w, h));
    }
}
