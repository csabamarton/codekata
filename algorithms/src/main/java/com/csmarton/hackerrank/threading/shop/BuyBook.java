package com.csmarton.hackerrank.threading.shop;

public class BuyBook implements Runnable {
    SharedProductStore sharedProductStore = null;

    public BuyBook(SharedProductStore sharedProductStore) {
        this.sharedProductStore = sharedProductStore;
    }

    @Override
    public void run() {
        System.out.println("Buy a Book --> " + sharedProductStore.buyProduct(Item.BOOK));
    }
}
