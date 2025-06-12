package repository;

import model.MenuOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<MenuOrder> orderList = new ArrayList<>();

    public OrderRepository(List<MenuOrder> orderList) {
        this.orderList = orderList;
    }

    public OrderRepository() {
    }

    public List<MenuOrder> setOrderList(MenuOrder order) {
        this.orderList.add(order);
        return List.of();
    }

    public void setOrderList(List<MenuOrder> orderList) {
        this.orderList = orderList;
    }

    public List<MenuOrder> getOrderList() {
        return orderList;
    }
}
