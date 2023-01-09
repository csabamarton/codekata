package decorator;

public abstract class ToppingsDecorator extends BasePizza {

    protected BasePizza pizza;

    public ToppingsDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return Math.round(this.pizza.getPrice() + this.price);
    }
}
