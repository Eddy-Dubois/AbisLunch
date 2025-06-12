package services;

import Interfaces.PersonRoles;
import model.MenuItem;
import model.MenuOrder;

import java.util.List;

public class PersonRolesImpl implements PersonRoles {

    public PersonRolesImpl() {
    }

    @Override
    public List<MenuItem> addOrder(MenuOrder o) {
        return List.of();
    }

/*    public List<MenuOrder> addOrder(MenuOrder o) {
        List<MenuOrder> listOrder = new ArrayList<>();
        listOrder.add(o) ;
        return listOrder;
    }*/
}
