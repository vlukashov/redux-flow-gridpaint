package com.vlukashov.gridpaint;

import com.vaadin.flow.html.Div;
import com.vaadin.flow.html.H1;
import com.vaadin.flow.router.View;
import com.vaadin.ui.AttachEvent;
import com.vaadin.ui.Composite;

public class HomeView extends Composite<Div> implements View {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        getContent().add(new H1("I'm the Home view"));
    }
}
