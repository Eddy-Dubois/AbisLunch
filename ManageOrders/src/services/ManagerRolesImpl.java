package services;

import Interfaces.ManagerRoles;
import model.MenuOrder;
import model.Person;

import java.util.Iterator;
import java.util.List;

public class ManagerRolesImpl  implements ManagerRoles {


    @Override
    public List<MenuOrder> removeOrder(List<MenuOrder> orderList , Person person) {

        Iterator<MenuOrder> iter = orderList.iterator();
        while (iter.hasNext()) {
            MenuOrder m = iter.next();
            Person p = m.getPerson();
            if (p.getPersonName().equalsIgnoreCase(person.getPersonName())) {
                iter.remove();
            }
        }
        return orderList;
    }


    @Override
    public void printOrders(List<MenuOrder> orderList) {
        orderList.stream()
                .forEach(System.out::println);
    }
}
