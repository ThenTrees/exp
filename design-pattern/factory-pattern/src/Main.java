
import abstractfactory.FourLegsAnimalFactory;
import abstractfactory.TwoLegsAnimalFactory;
import factory.AnimalFactory;
import factory.BasicAnimalFactory;
import factory.RandomAnimalFactory;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory;
        Random random = new Random();
        int type = random.nextInt(2);
        if (type == 0) {
            animalFactory = new FourLegsAnimalFactory();
        }else {
            animalFactory = new TwoLegsAnimalFactory();
        }
        System.out.println(animalFactory.createAnimal().getName());
        System.out.println(animalFactory.createAnimal().getName());
        System.out.println(animalFactory.createAnimal().getName());
        System.out.println(animalFactory.createAnimal().getName());
        System.out.println(animalFactory.createAnimal().getName());

    }
}