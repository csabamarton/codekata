package decorator;

public class ExtraCheeseTopping extends ToppingsDecorator {

    public ExtraCheeseTopping(BasePizza pizza) {
        super(pizza);

        this.price = 0.99;
    }
}
