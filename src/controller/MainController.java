package src.controller;

import src.view.MainView;

public class MainController extends Controller {
    private MainView view;

    @Override
    public void init() {
        view = new MainView();
        view.setVisible(true);
    }
}
