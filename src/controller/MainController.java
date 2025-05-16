package src.controller;

import src.view.MainView;

public class MainController {
    private MainView view;

    public void init() {
        view = new MainView();
        view.setVisible(true);
    }
}
