package abstractfactory;

import animal.Animal;
import factory.AnimalFactory;

public abstract class AbstractAnimalFactory implements AnimalFactory {
    public abstract Animal createAnimal();
}
