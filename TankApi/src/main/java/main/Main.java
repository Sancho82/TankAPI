package main;

import client.TankClient;
import views.CreateView;

public class Main {
    public static void main(String[] args) {

        CreateView createView = new CreateView();
        TankClient tankClient = new TankClient();
        tankClient.deleteTank("Mike");
    }
}
