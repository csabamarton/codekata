package com.csmarton.hackerrank.threading.shop;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class SharedProductStore {


    private Map<Item, Integer> inventory = new HashMap<>();

    public SharedProductStore() {
        inventory.put(Item.BOOK, 1);
        inventory.put(Item.PEN, 10);
        inventory.put(Item.PAPER, 4);
        inventory.put(Item.OUT_OF_STOCK, 0);
    }

    public String buyProduct(Item item) {
        if(inventory.containsKey(item)) {
            Integer qty = inventory.get(item);

            if(qty != 0) {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                inventory.put(item, qty - 1);
                return "Purchase has been made for " + item.name() + " Thread: " + Thread.currentThread().getName();
            } else {
                inventory.put(Item.OUT_OF_STOCK, inventory.get(Item.OUT_OF_STOCK) + 1);
                return "Ooops! Product run out of stock. Sorry";
            }
        }
        inventory.put(Item.OUT_OF_STOCK, inventory.get(Item.OUT_OF_STOCK) + 1);

        return "Ooops! Product run out of stock. Sorry";
    }

    public boolean compareInventories(SharedProductStore otherInventory) {
        if(otherInventory.inventory.size() != this.inventory.size())
            return false;

        for (Map.Entry<Item, Integer> entry : this.inventory.entrySet()) {
            if(!otherInventory.inventory.containsKey(entry.getKey()))
                return false;

            if(otherInventory.inventory.get(entry.getKey()) != this.inventory.get(entry.getKey()))
                return false;
        }

        return true;
    }


}
