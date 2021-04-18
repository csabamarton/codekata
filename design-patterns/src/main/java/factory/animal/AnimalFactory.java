package factory.animal;

import factory.AbstractFactory;
import factory.Animal;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String animalType) {
        if(animalType == "Duck")
            return new Duck();
        else if(animalType == "Dog")
            return new Dog();
        return null;
    }
}
