package presenter;

import client.TankClient;
import entity.Tank;
import view.panels.CreatePanel;
import view.panels.DeletePanel;
import view.View;
import view.panels.SearchPanel;

import java.util.Optional;

public class Presenter {

    private View view;
    private TankClient tankClient;

    public Presenter(View view) {
        this.view = view;
        this.tankClient = new TankClient();
    }

    public View getView() {
        return view;
    }

    public TankClient getTankClient() {
        return tankClient;
    }

    public String findTankByName(String name) {
        String message;
        Optional<Tank> tank = tankClient.findTankByName(name);
        message = tank.isPresent() ? "Tank found!" : "Tank with given name doesn't exist.";

        ((SearchPanel) (view.getViewPanel())).setStatistics(tank, message);
        return message;
    }

    public void addTank(String name, String owner, String type) {
        ((CreatePanel) (view.getViewPanel())).setMessage(tankClient.addTank(name, owner, type));
    }

    public void deleteTank(String message) {
        ((DeletePanel) (view.getViewPanel())).setMessage(tankClient.deleteTank(message));
    }
}
