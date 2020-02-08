package presenter;

import client.TankClient;
import entity.Tank;
import view.panels.CreatePanel;
import view.panels.DeletePanel;
import view.View;

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

    public Tank findTankByName() {
        return tankClient.findTankByName();
    }

    public void addTank(String name, String owner, String type) {
        ((CreatePanel) (view.getViewPanel())).setMessage(tankClient.addTank(name, owner, type));
    }

    public void deleteTank(String message) {
        ((DeletePanel) (view.getViewPanel())).setMessage(tankClient.deleteTank(message));
    }
}
