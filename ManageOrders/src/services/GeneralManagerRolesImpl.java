package services;

import Interfaces.GeneralManagerRoles;
import model.MenuOrder;
import model.Sandwich;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GeneralManagerRolesImpl implements GeneralManagerRoles {
    @Override
    public void viewStats(List<MenuOrder> orderList) {

        orderList.stream().forEach(System.out::println);

        Map<MenuOrder, Long> sandwichCounts = orderList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),   // groups by Sandwich object itself
                        Collectors.counting()  // counts occurrences
                ));
        sandwichCounts.forEach((sandwich, count) ->
                System.out.println(sandwich.getSandwich() + " (" + sandwich.getOrderDate() + "): " + count));


    }

}
