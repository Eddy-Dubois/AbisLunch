package repository;

import model.MenuOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<MenuOrder> orderList = new ArrayList<>();

    public OrderRepository(MenuOrder order) {
        this.orderList.add(order);
    }

    public void setOrderList(List<MenuOrder> orderList) {
        this.orderList = orderList;
    }
}
