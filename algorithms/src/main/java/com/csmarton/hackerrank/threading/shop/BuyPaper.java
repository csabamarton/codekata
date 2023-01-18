package com.csmarton.hackerrank.threading.shop;

public class BuyPaper implements Runnable {
    private final SharedProductStore sharedProductStore;

    public BuyPaper(SharedProductStore sharedProductStore) {
        this.sharedProductStore = sharedProductStore;
    }


    @Override
    public void run() {
        System.out.println("Buy a Paper --> " + sharedProductStore.buyProduct(Item.PAPER));
    }
}
