package factory;

import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Duck;

import java.util.Random;

public class RandomAnimalFactory implements AnimalFactory{

    @Override
    public Animal createAnimal() {
        Random random = new Random();
        int type = random.nextInt(3);
        if(type == 0) {
            return new Dog();
        }else if(type == 1) {
            return new Cat();
        } else  {
            return new Duck();
        }
    }
}
