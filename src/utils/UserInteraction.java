package utils;

import data.Country;

import java.util.Map;
import java.util.Scanner;

public class UserInteraction {

    public static void userAction(Map<String, Country> countryMap) {
        String decision;
        String userValue;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Type country code: ");
            userValue = scanner.nextLine();
            if (countryMap.containsKey(userValue)) {
                String countryCode = countryMap.get(userValue).getCode();
                String countryName = countryMap.get(userValue).getName();
                long population = countryMap.get(userValue).getPopulation();
                System.out.println(countryName + "(" + countryCode + ") is inhabitated by " + population + " people");
            } else
                System.out.println("There is no such country code in my collection");

            System.out.println("Do you want to try again? y/n");
            decision = scanner.nextLine();
        } while (decision.equals("y"));
    }
}
