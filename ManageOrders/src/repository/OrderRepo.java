package repository;

import model.MenuItem;
import model.MenuOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {


    List<model.MenuOrder> orderList = new ArrayList<MenuOrder>();

    public OrderRepo(List<MenuOrder> orderList) {
        this.orderList = orderList;
    }

    public OrderRepo() {

    }

    public List<MenuOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(MenuOrder order) {
        this.orderList.add(order) ;
    }


    public void setOrderList(List<MenuOrder> orderList) {
        this.orderList = orderList;
    }
}
