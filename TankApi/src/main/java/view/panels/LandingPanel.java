package view.panels;

import colors.Colors;
import view.View;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class LandingPanel extends AbstractPanel {

    private View view;
    private Colors colors;

    private JButton toSearchPanelButton;
    private JButton toListAllPanelButton;
    private JButton toCreatePanelButton;
    private JButton toDeletePanelButton;
    private JButton quitButton;

    private JLabel messageLabel;

    public LandingPanel(View view) {
        colors = new Colors();
        this.view = view;

        setLayout(null);
        setBounds(0, 0,
                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setBackground(colors.getDrape());
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setOpaque(true);

        toSearchPanelButton = new JButton();
        toSearchPanelButton.setBounds(200, 100, 500, 100);
        toSearchPanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toSearchPanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toSearchPanelButton.setText("Search for Tank");
        toSearchPanelButton.setBackground(colors.getGold());
        toSearchPanelButton.setForeground(Color.WHITE);
        toSearchPanelButton.addActionListener(e -> {
            view.changePanel("SearchPanel");
        });
        add(toSearchPanelButton);

        toListAllPanelButton = new JButton();
        toListAllPanelButton.setBounds(200, 210, 500, 100);
        toListAllPanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toListAllPanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toListAllPanelButton.setText("List all Tanks");
        toListAllPanelButton.setBackground(colors.getGold());
        toListAllPanelButton.setForeground(Color.WHITE);
        toListAllPanelButton.addActionListener(e -> {
            view.changePanel("ListAllPanel");
            setMessage("Function is currently unavailable");
        });
        add(toListAllPanelButton);

        toCreatePanelButton = new JButton();
        toCreatePanelButton.setBounds(200, 320, 500, 100);
        toCreatePanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toCreatePanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toCreatePanelButton.setText("Create New Tank");
        toCreatePanelButton.setBackground(colors.getGold());
        toCreatePanelButton.setForeground(Color.WHITE);
        toCreatePanelButton.addActionListener(e -> {
            view.changePanel("CreatePanel");
        });
        add(toCreatePanelButton);

        toDeletePanelButton = new JButton();
        toDeletePanelButton.setBounds(200, 430, 500, 100);
        toDeletePanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toDeletePanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toDeletePanelButton.setText("Delete Tank");
        toDeletePanelButton.setBackground(colors.getGold());
        toDeletePanelButton.setForeground(Color.WHITE);
        toDeletePanelButton.addActionListener(e -> {
            view.changePanel("DeletePanel");
        });
        add(toDeletePanelButton);

        quitButton = new JButton();
        quitButton.setBounds(200, 540, 500, 100);
        quitButton.setFont(new Font("Verdana", Font.BOLD, 40));
        quitButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        quitButton.setText("Quit");
        quitButton.setBackground(colors.getGold());
        quitButton.setForeground(Color.WHITE);
        quitButton.addActionListener(e -> {
            view.changePanel("Quit");
        });
        add(quitButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(200, 650, 610, 30);
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
        messageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        messageLabel.setBackground(colors.getDrape());
        messageLabel.setForeground(Color.red);
        messageLabel.setOpaque(true);
        add(messageLabel);
    }

    @Override
    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
