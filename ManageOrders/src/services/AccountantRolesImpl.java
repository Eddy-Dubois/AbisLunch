package services;

import Interfaces.AccountantRoles;
import model.MenuOrder;

import java.util.List;

public class AccountantRolesImpl implements AccountantRoles {


    @Override
    public void calculateExpenses(List<MenuOrder> orderList) {
        double totalPrice = 0;
        for (MenuOrder order : orderList) {
            totalPrice += order.getPrice();
        }
        System.out.println("Total Price for Orders for date " + orderList.get(1).getOrderDate() + " is " + totalPrice);
    }
}
