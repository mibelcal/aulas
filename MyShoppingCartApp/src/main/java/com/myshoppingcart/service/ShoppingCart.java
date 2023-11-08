package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Producto;

import java.util.*;

public class ShoppingCart {

    private ArrayList items;

    public ShoppingCart() {
        items = new ArrayList();
    }

    public double getBalance() {
        double balance = 0.00;
        for (Iterator i = items.iterator(); i.hasNext(); ) {
            Producto item = (Producto) i.next();
            balance += item.getPrecio();
        }
        return balance;
    }

    public void addItem(Producto item) {
        items.add(item);
    }

    public void removeItem(Producto item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public void empty() {
        items.clear();
    }
}