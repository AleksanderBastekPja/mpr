package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.example.exceptions.PizzaRuntimeException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {

    final static Logger log  = LogManager.getLogger(Main.class);
    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;

    public Order makeOrder(List<Pizza> pizza) {
        log.info("order was created!");
        if(listAvailablePizza().containsAll(pizza)) {
            Double totalPrize = pizza.stream().map(Pizza::getPrice).reduce(0.0, Double::sum);
            return new Order(this.orderList.size(), pizza, totalPrize);
        }
        throw new PizzaRuntimeException();

    }

    public List<Pizza> listAvailablePizza() {
        return this.pizzaList.stream().filter(Pizza::isAvailable).collect(Collectors.toList());
    }

    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
