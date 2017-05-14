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
import com.vlukashov.gridpaint.actions.SetGridSize;
import com.vlukashov.gridpaint.actions.ToggleCell;
import com.vlukashov.gridpaint.redux.Store;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Tag("x-size-setter")
@HtmlImport("components/x-size-setter.html")
public class SizeSetter extends PolymerTemplate<SizeSetter.Model> {

    private final Store<AppState> store;
    private Store.Subscription subscription;

    public SizeSetter(Store<AppState> store) {
        this.store = store;
    }

    public interface Model extends TemplateModel {
        void setWidth(int width);
        int getWidth();

        void setHeight(int height);
        int getHeight();
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
    }

    @EventHandler
    private void handleWidthChange(@EventData("event.target.value") int width) {
        store.dispatch(new SetGridSize(width, getModel().getHeight()));
    }

    @EventHandler
    private void handleHeightChange(@EventData("event.target.value") int height) {
        store.dispatch(new SetGridSize(getModel().getWidth(), height));
    }
}
