package presenter;

import client.TankClient;
import entity.Tank;
import views.CreateView;

public class Presenter {

    private CreateView createView;
    private TankClient tankClient;

    public Presenter(CreateView createView) {
        this.createView = createView;
        this.tankClient = new TankClient();
    }

    public CreateView getCreateView() {
        return createView;
    }

    public TankClient getTankClient() {
        return tankClient;
    }

    public Tank createTank(String name, String owner, String type) {
        return tankClient.addTank(name, owner, type);
    }
}
