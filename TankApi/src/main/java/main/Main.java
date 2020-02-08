package main;

import client.TankClient;
import views.View;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            View view = new View();
        });

        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
    }
}
