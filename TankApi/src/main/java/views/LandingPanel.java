package views;

import colors.Colors;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class LandingPanel extends JPanel {

    private View view;
    private Colors colors;

    private JButton toCreatePanelButton;
    private JButton toSearchPanelButton;
    private JButton toDeletePanelButton;
    private JButton toUpdatePanelButton;
    private JButton quitButton;

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

        toSearchPanelButton  = new JButton();
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

        toCreatePanelButton = new JButton();
        toCreatePanelButton.setBounds(200, 210, 500, 100);
        toCreatePanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toCreatePanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toCreatePanelButton.setText("Create New Tank");
        toCreatePanelButton.setBackground(colors.getGold());
        toCreatePanelButton.setForeground(Color.WHITE);
        toCreatePanelButton.addActionListener(e -> {
            view.changePanel("CreatePanel");
        });
        add(toCreatePanelButton);

        toUpdatePanelButton = new JButton();
        toUpdatePanelButton.setBounds(200, 320, 500, 100);
        toUpdatePanelButton.setFont(new Font("Verdana", Font.BOLD, 40));
        toUpdatePanelButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        toUpdatePanelButton.setText("Update Tank");
        toUpdatePanelButton.setBackground(colors.getGold());
        toUpdatePanelButton.setForeground(Color.WHITE);
        toUpdatePanelButton.addActionListener(e -> {
            view.changePanel("UpdatePanel");
        });
        add(toUpdatePanelButton);

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
    }
}
