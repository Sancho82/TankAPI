package view.panels;

import view.View;

import javax.swing.*;

public class SearchPanel extends AbstractPanel {

    private View view;

    private JLabel messageLabel;

    public SearchPanel(View view) {
        this.view = view;
    }

    @Override
    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
