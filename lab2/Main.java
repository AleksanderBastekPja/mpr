package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.service.PizzaService;

import java.util.List;


public class Main {
    final static Logger log  = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("margarita", 5.21, true);
        Pizza pizza2 = new Pizza("neapolitana", 7.21, false);
        Pizza pizza3 = new Pizza("pepperoni", 8.21, true);
        Pizza pizza4 = new Pizza("swojska", 12.21, true);

        List<Pizza> pizzaList1 = List.of(pizza1, pizza2, pizza3, pizza4);

        PizzaService pizzaService = new PizzaService(pizzaList1);

        List<Pizza> availablePizzaList = pizzaService.listAvailablePizza();

        System.out.println(availablePizzaList);
        log.info(availablePizzaList);

        try {
            Order order = pizzaService.makeOrder(List.of(pizza1));
        } catch (Exception e) {
            log.error("Pizza nie istnieje");
        }
    }
}