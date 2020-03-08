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
    private JButton updateButton;

    private JLabel tankNameLabel;
    private JLabel tankOwnerLabel;
    private JLabel tankTypeLabel;
    private JLabel displayLabel;
    private JLabel messageLabel;

    private JTextField tankNameTextField;
    private JTextField tankOwnerTextField;
    private JTextField tankTypeTextField;

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

        updateButton = new JButton();
        updateButton.setBounds(655, 300, 300, 70);
        updateButton.setFont(new Font("Verdana", Font.BOLD, 25));
        updateButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        updateButton.setText("Update");
        updateButton.setBackground(colors.getRare());
        updateButton.setForeground(Color.WHITE);
        updateButton.setVisible(false);
        updateButton.addActionListener(e -> {
            view.getPresenter().updateTank(
                    tankNameTextField.getText(),
                    tankOwnerTextField.getText(),
                    tankTypeTextField.getText()
            );
        });
        add(updateButton);

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

        tankOwnerLabel = new JLabel("Owner:");
        tankOwnerLabel.setBounds(500, 135, 100, 30);
        tankOwnerLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tankOwnerLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        tankOwnerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tankOwnerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        tankOwnerLabel.setBackground(colors.getFog());
        tankOwnerLabel.setForeground(Color.white);
        tankOwnerLabel.setOpaque(true);
        tankOwnerLabel.setVisible(false);
        add(tankOwnerLabel);

        tankTypeLabel = new JLabel("Type:");
        tankTypeLabel.setBounds(500, 170, 100, 30);
        tankTypeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        tankTypeLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        tankTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tankTypeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        tankTypeLabel.setBackground(colors.getFog());
        tankTypeLabel.setForeground(Color.white);
        tankTypeLabel.setOpaque(true);
        tankTypeLabel.setVisible(false);
        add(tankTypeLabel);

        tankNameTextField = new JTextField();
        tankNameTextField.setBounds(610, 100, 500, 30);
        tankNameTextField.setFont(new Font("Verdana", Font.BOLD, 20));
        tankNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        tankNameTextField.setBackground(colors.getFog());
        tankNameTextField.setForeground(Color.WHITE);
        tankNameTextField.setOpaque(true);
        add(tankNameTextField);

        tankOwnerTextField = new JTextField();
        tankOwnerTextField.setBounds(610, 135, 500, 30);
        tankOwnerTextField.setFont(new Font("Verdana", Font.BOLD, 20));
        tankOwnerTextField.setHorizontalAlignment(SwingConstants.LEFT);
        tankOwnerTextField.setBackground(colors.getFog());
        tankOwnerTextField.setForeground(Color.WHITE);
        tankOwnerTextField.setOpaque(true);
        tankOwnerTextField.setVisible(false);
        add(tankOwnerTextField);

        tankTypeTextField = new JTextField();
        tankTypeTextField.setBounds(610, 170, 500, 30);
        tankTypeTextField.setFont(new Font("Verdana", Font.BOLD, 20));
        tankTypeTextField.setHorizontalAlignment(SwingConstants.LEFT);
        tankTypeTextField.setBackground(colors.getFog());
        tankTypeTextField.setForeground(Color.WHITE);
        tankTypeTextField.setOpaque(true);
        tankTypeTextField.setVisible(false);
        add(tankTypeTextField);

        displayLabel = new JLabel();
        displayLabel.setBounds(500, 205, 610, 90);
        displayLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        displayLabel.setHorizontalAlignment(SwingConstants.LEFT);
        displayLabel.setVerticalAlignment(SwingConstants.CENTER);
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

    public void displayUpdateOptions(Tank tank) {
        tankOwnerLabel.setVisible(true);
        tankTypeLabel.setVisible(true);
        tankOwnerTextField.setVisible(true);
        tankOwnerTextField.setText(tank.getOwner());
        tankTypeTextField.setVisible(true);
        tankTypeTextField.setText(tank.getType());
        updateButton.setVisible(true);
    }

    public void hideUpdateOptions() {
        tankOwnerLabel.setVisible(false);
        tankTypeLabel.setVisible(false);
        tankOwnerTextField.setText(null);
        tankOwnerTextField.setVisible(false);
        tankTypeTextField.setText(null);
        tankTypeTextField.setVisible(false);
        updateButton.setVisible(false);
        displayLabel.setText(null);
    }

    public void setSearchStatistics(Optional<Tank> tank, String message) {
        if (tank.isPresent()) {
            messageLabel.setForeground(Color.black);
            displayUpdateOptions(tank.get());
            displayLabel.setText(
                    "<html>" +
                            "Name: " + tank.get().getName() + "<br>" +
                            "Owner: " + tank.get().getOwner() + "<br>" +
                            "Type: " + tank.get().getType() + "<br>" +
                            "<html>"
            );

        } else {
            messageLabel.setForeground(Color.red);
            hideUpdateOptions();
            displayLabel.setText(null);
        }
        setMessage(message);
    }

    public void setUpdateStatistics(Tank tank, String message) {
        if (message.equals("Tank successfully updated.")) {
            messageLabel.setForeground(Color.black);
            displayUpdateOptions(tank);
            displayLabel.setText(
                    "<html>" +
                            "Name: " + tank.getName() + "<br>" +
                            "Owner: " + tank.getOwner() + "<br>" +
                            "Type: " + tank.getType() + "<br>" +
                            "<html>"
            );

        } else {
            messageLabel.setForeground(Color.red);
            hideUpdateOptions();
            displayLabel.setText(null);
        }
        setMessage(message);
    }
}
