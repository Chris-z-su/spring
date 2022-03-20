package com.shubao.domain;

import java.util.Date;
import java.util.Objects;

public class Order {

    private int id;

    private Date ordertime;

    private double total;

    //当前订单属于哪一个用户
    private User user;

    public Order() {
    }

    public Order(int id, Date ordertime, double total, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.total, total) == 0 && Objects.equals(ordertime, order.ordertime) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordertime, total, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
