package com.vlukashov.gridpaint.components;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.Tag;
import com.vaadin.flow.template.PolymerTemplate;
import com.vaadin.flow.template.model.TemplateModel;
import com.vaadin.ui.AttachEvent;

import java.util.Arrays;
import java.util.List;

@Tag("x-grid")
@HtmlImport("components/x-grid.html")
public class Grid extends PolymerTemplate<Grid.Model> {

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
        getModel().setWidth(10);
        getModel().setHeight(10);
        getModel().setCells(Arrays.asList(
                new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(false), new Cell(false), new Cell(false),
                new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false),
                new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(false),
                new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(false), new Cell(false), new Cell(true),
                new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(false),
                new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false),
                new Cell(false), new Cell(false), new Cell(false), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(false), new Cell(false), new Cell(false)));
    }
}
