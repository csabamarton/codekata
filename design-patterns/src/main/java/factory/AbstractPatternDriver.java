package factory;

public class AbstractPatternDriver {

    public static void main(String[] args) {
        AbstractFactory abstractFactory;

        abstractFactory = FactoryProvider.getFactory("Animal");
        Animal dog = (Animal) abstractFactory.create("Dog");

        System.out.println(dog);
    }
}

