package com.example.filerouge.model;

import java.util.Collection;
import java.util.Date;

public class Order {
    private int idOrder;
    private Date dateOrder;
    private double totalAmount;
    private User user;
    private Payment payment;
    private Collection<OrderItem> orderItems;
}
