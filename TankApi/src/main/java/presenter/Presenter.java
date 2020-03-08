package presenter;

import client.TankClient;
import entity.Tank;
import view.View;
import view.panels.CreatePanel;
import view.panels.DeletePanel;
import view.panels.SearchPanel;

import java.util.Optional;

public class Presenter {

    private View view;
    private TankClient tankClient;
    private Optional<Tank> tankOnDisplay;

    public Presenter(View view) {
        this.view = view;
        this.tankClient = new TankClient();
    }

    public String findTankByName(String name) {
        String message;
        tankOnDisplay = tankClient.findTankByName(name);
        message = tankOnDisplay.isPresent() ? "Tank found." : "Tank with given name doesn't exist.";

        ((SearchPanel) (view.getViewPanel())).setSearchStatistics(tankOnDisplay, message);

        return message;
    }

    public void addTank(String name, String owner, String type) {
        ((CreatePanel) (view.getViewPanel())).setMessage(tankClient.addTank(name, owner, type));
    }

    public String updateTank(String newTankName, String newTankOwner, String newTankType) {
        tankOnDisplay.get()
                .setName(newTankName)
                .setOwner(newTankOwner)
                .setType(newTankType);

        String message = tankClient.updateTank(tankOnDisplay.get()) != null ?
                "Tank successfully updated." : "Update unsuccessful.";
        ((SearchPanel) (view.getViewPanel())).setUpdateStatistics(tankOnDisplay.get(), message);

        return message;
    }

    public void deleteTank(String message) {
        ((DeletePanel) (view.getViewPanel())).setMessage(tankClient.deleteTank(message));
    }
}
