package view.panels;

import colors.Colors;
import view.View;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class DeletePanel extends AbstractPanel {

    private View view;

    private JButton deleteButton;
    private JButton backButton;

    private JLabel tankNameLabel;
    private JLabel messageLabel;

    private JTextField tankNameTextField;

    private Colors colors;

    public DeletePanel(View view) {
        this.view = view;
        colors = new Colors();

        setLayout(null);
        setBounds(0, 0,
                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setBackground(colors.getDrape());
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setOpaque(true);

        deleteButton = new JButton();
        deleteButton.setBounds(500, 650, 300, 70);
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 25));
        deleteButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        deleteButton.setText("Delete");
        deleteButton.setBackground(colors.getGold());
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(e -> {
            view.getPresenter().deleteTank(
                    tankNameTextField.getText()
            );
        });
        add(deleteButton);

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

        messageLabel = new JLabel();
        messageLabel.setBounds(500, 610, 610, 30);
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
        Color color = message.equals("Tank with given name successfully deleted.") ? Color.black : Color.red;
        messageLabel.setForeground(color);
        messageLabel.setText(message);
    }
}
