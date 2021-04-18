package factory.animal;

import factory.Animal;

public class Duck implements Animal {
    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Hap-Hap";
    }
}
