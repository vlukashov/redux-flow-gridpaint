package com.vlukashov.gridpaint;

import com.vaadin.flow.html.Div;
import com.vaadin.flow.html.H1;
import com.vaadin.flow.router.View;
import com.vaadin.ui.AttachEvent;
import com.vaadin.ui.Composite;
import com.vlukashov.gridpaint.components.Grid;

public class HomeView extends Composite<Div> implements View {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        getElement().setAttribute("style", "padding: 1rem;");
        getContent().add(
                new H1("Try tapping on the grid cells below to toggle their color:"),
                new Grid());
    }
}
