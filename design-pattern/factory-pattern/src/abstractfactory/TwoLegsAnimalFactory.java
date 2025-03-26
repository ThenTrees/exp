package abstractfactory;

import animal.*;

import java.util.Random;

public class TwoLegsAnimalFactory extends AbstractAnimalFactory {
    @Override
    public Animal createAnimal() {
        Random random = new Random();
        int type = random.nextInt(2);
        if(type == 0) {
            return new Bird();
        }else{
            return new Duck();
        }
    }
}
