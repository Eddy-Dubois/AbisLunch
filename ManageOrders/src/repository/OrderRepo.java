package repository;

import model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {


    List<model.MenuItem> orderList = new ArrayList<MenuItem>();

    public OrderRepo(List<MenuItem> orderList) {
        this.orderList = orderList;
    }

    public OrderRepo() {

    }



    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }
}
