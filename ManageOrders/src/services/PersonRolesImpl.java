package services;

import Interfaces.PersonRoles;
import model.MenuOrder;

import java.util.ArrayList;
import java.util.List;

public class PersonRolesImpl implements PersonRoles {

    List<MenuOrder> listOrder = new ArrayList<>();

    public PersonRolesImpl() {
    }

    @Override
    public List<MenuOrder> addOrderMenu(MenuOrder o) {
        listOrder.add(o) ;
        return listOrder;
    }

}
