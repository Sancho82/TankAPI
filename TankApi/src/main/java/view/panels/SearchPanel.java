package view.panels;

import colors.Colors;
import entity.Tank;
import view.View;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.util.Optional;

public class SearchPanel extends AbstractPanel {

    private View view;

    private JButton findButton;
    private JButton backButton;

    private JLabel tankNameLabel;
    private JLabel displayLabel;
    private JLabel messageLabel;

    private JTextField tankNameTextField;

    private Colors colors;

    public SearchPanel(View view) {
        this.view = view;
        colors = new Colors();

        setLayout(null);
        setBounds(0, 0,
                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setBackground(colors.getDrape());
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setOpaque(true);

        findButton = new JButton();
        findButton.setBounds(500, 650, 300, 70);
        findButton.setFont(new Font("Verdana", Font.BOLD, 25));
        findButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        findButton.setText("Search");
        findButton.setBackground(colors.getGold());
        findButton.setForeground(Color.WHITE);
        findButton.addActionListener(e -> {
            view.getPresenter().findTankByName(
                    tankNameTextField.getText()
            );
        });
        add(findButton);

        backButton = new JButton();
        backButton.setBounds(810, 650, 300, 70);
        backButton.setFont(new Font("Verdana", Font.BOLD, 25));
        backButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        backButton.setText("Back");
        backButton.setBackground(colors.getGold());
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            view.changePanel("LandingPanel");
        });
        add(backButton);

        tankNameLabel = new JLabel("Name:");
        tankNameLabel.setBounds(500, 100, 100, 30);
        tankNameLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tankNameLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        tankNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tankNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        tankNameLabel.setBackground(colors.getFog());
        tankNameLabel.setForeground(Color.white);
        tankNameLabel.setOpaque(true);
        add(tankNameLabel);

        tankNameTextField = new JTextField();
        tankNameTextField.setBounds(610, 100, 500, 30);
        tankNameTextField.setFont(new Font("Verdana", Font.BOLD, 20));
        tankNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        tankNameTextField.setBackground(colors.getFog());
        tankNameTextField.setForeground(Color.WHITE);
        tankNameTextField.setOpaque(true);
        add(tankNameTextField);

        displayLabel = new JLabel();
        displayLabel.setBounds(500, 200, 610, 90);
        displayLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        displayLabel.setHorizontalAlignment(SwingConstants.LEFT);
        displayLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        displayLabel.setBackground(colors.getLife());
        displayLabel.setForeground(Color.white);
        displayLabel.setOpaque(true);
        add(displayLabel);

        messageLabel = new JLabel();
        messageLabel.setBounds(500, 610, 610, 30);
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
        messageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        messageLabel.setBackground(colors.getDrape());
        messageLabel.setOpaque(true);
        add(messageLabel);
    }

    @Override
    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    public void setStatistics(Optional<Tank> tank, String message) {
        if (tank.isPresent()) {
            messageLabel.setForeground(Color.black);
            displayLabel.setText(
                    "<html>" +
                            "Name: " + tank.get().getName() + "<br>" +
                            "Owner: " + tank.get().getOwner() + "<br>" +
                            "Type: " + tank.get().getType() + "<br>" +
                            "<html>"
            );

        } else {
            messageLabel.setForeground(Color.red);
            displayLabel.setText("");
        }
        messageLabel.setText(message);
    }
}
