package presenter;

import client.TankClient;
import entity.Tank;
import views.View;

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

    public Tank createTank(String name, String owner, String type) {
        return tankClient.addTank(name, owner, type);
    }

    public void deleteTank(String name) {
        tankClient.deleteTank(name);
    }
}
