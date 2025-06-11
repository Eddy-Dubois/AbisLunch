package Interfaces;

import model.MenuItem;
import model.MenuOrder;

import java.util.List;

public interface AccountantRoles {

    void calculateExpenses(List<MenuOrder> orderList);
}
