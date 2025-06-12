package Interfaces;

import model.MenuOrder;
import model.Person;

import java.util.List;

public interface ManagerRoles {

    List<MenuOrder> removeOrder(List<MenuOrder> orderList , Person p);

    void printOrders(List<MenuOrder> orderList) ;


}
