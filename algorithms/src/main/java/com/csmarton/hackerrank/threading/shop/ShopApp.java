package com.csmarton.hackerrank.threading.shop;

public class ShopApp {

    public static void main(String[] args) throws InterruptedException {
        ShopApp shopApp = new ShopApp();

        SharedProductStore sharedProductStore = new SharedProductStore();

        BuyBook buyBook = new BuyBook(sharedProductStore);
        BuyPen buyPen = new BuyPen(sharedProductStore);
        BuyPaper buyPaper = new BuyPaper(sharedProductStore);

        Thread student1 = new Thread(buyBook, "student1");
        Thread student2 = new Thread(buyBook, "student2");
        Thread student3 = new Thread(buyPen, "student3");

        student1.start();
        student2.start();
        student3.start();

        for (Thread t : new Thread[]{student1, student2, student3}) {
            t.join();
        }

        SharedProductStore inventoryForNonMultiThread = new SharedProductStore();

        inventoryForNonMultiThread.buyProduct(Item.BOOK);
        inventoryForNonMultiThread.buyProduct(Item.BOOK);
        inventoryForNonMultiThread.buyProduct(Item.PEN);

        System.out.println(sharedProductStore.compareInventories(inventoryForNonMultiThread));
    }
}
