package inMemoryModel;

import modelElements.Camera;
import modelElements.Flash;
import modelElements.PoligonalModel;
import modelElements.Scene;

public class ModelStore implements IModelChanger {
    public PoligonalModel models;
    public Scene scenes;
    public Flash flashes;
    public Camera cameras;
    private IModelChangedObserver changeObservers;
    public Scene GetScena(int i){
        return new Scene();
    }

    @Override
    public void notifyChange(IModelChanger sender) {

    }

}
