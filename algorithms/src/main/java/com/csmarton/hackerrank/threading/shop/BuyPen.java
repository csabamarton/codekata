package com.csmarton.hackerrank.threading.shop;

public class BuyPen implements Runnable {
    SharedProductStore sharedProductStore = null;

    public BuyPen(SharedProductStore sharedProductStore) {
        this.sharedProductStore = sharedProductStore;
    }

    @Override
    public void run() {
        System.out.println("Buy a Pen --> " + sharedProductStore.buyProduct(Item.PEN));
    }
}
