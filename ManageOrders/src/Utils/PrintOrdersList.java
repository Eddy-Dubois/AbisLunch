package Utils;

import model.MenuOrder;

import java.util.List;

public class PrintOrdersList {

    public static void printConfirmedOrders (List<MenuOrder> orderList) {
        for (MenuOrder order : orderList) {
            System.out.println(order);
        }

    }
}
