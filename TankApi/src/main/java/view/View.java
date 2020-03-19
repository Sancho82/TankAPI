package view;

import presenter.Presenter;
import view.panels.*;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private Presenter presenter;
    private AbstractPanel viewPanel;

    public View() {
        setTitle("View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        presenter = new Presenter(this);
        viewPanel = new LandingPanel(this);
        add(viewPanel);
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public Component getViewPanel() {
        return viewPanel;
    }

    public void changePanel(String message) {
        switch (message) {
            case "LandingPanel":
                remove(viewPanel);
                viewPanel = new LandingPanel(this);
                add(viewPanel);
                repaint();
                break;

            case "SearchPanel":
                remove(viewPanel);
                viewPanel = new SearchPanel(this);
                add(viewPanel);
                repaint();
                break;

            case "ListAllPanel":
                //TODO
                break;

            case "CreatePanel":
                remove(viewPanel);
                viewPanel = new CreatePanel(this);
                add(viewPanel);
                repaint();
                break;

            case "DeletePanel":
                remove(viewPanel);
                viewPanel = new DeletePanel(this);
                add(viewPanel);
                repaint();
                break;

            case "Quit":
                System.exit(0);
                break;
        }
    }

}
