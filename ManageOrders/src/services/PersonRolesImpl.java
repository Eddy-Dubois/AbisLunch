package services;

import Interfaces.PersonRoles;
import model.MenuOrder;

import java.util.ArrayList;
import java.util.List;

public class PersonRolesImpl implements PersonRoles {


    @Override
    public List<MenuOrder> addOrder(MenuOrder o) {
        List<MenuOrder> orderList = new ArrayList<>();
        orderList.add(o) ;
        return orderList ;
    }
}
