package decorator;

public class PizzaDemo {
    public static void main(String[] args) {

        Margherita pizza = new Margherita();
        System.out.println(("Plain Margherita: " + pizza.getPrice()));

        ExtraCheeseTopping moreCheese = new ExtraCheeseTopping(new Margherita());
        System.out.println("Plain Margherita with double extra cheese: " + moreCheese.getPrice());

        ExtraCheeseTopping someMoreCheese = new ExtraCheeseTopping(new ExtraCheeseTopping(new Margherita()));
        System.out.println("Plain Margherita with double extra cheese: " + someMoreCheese.getPrice());

    }
}
