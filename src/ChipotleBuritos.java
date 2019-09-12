import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * The purpose of this program is to assemble 25 burritos.  There will be a random number of
 * ingredients on each.  An amount is determined for each burrito and a total amount is calculeted.
 * Each burrito is printed as well as its ingredients.
 */

public class ChipotleBuritos {
    private static Scanner key = new Scanner(System.in);
    private static Random rand = new Random();
    private static int totalIngredients = 0;

    public static void main(String[] args) {
        int numberOfOrders = 25;
        HashMap<String, String> burrito = new HashMap<>();
        String[] ingredients = {"Rice", "Meat", "Beans", "Salsa", "Veggies", "Cheese", "Guac", "Queso", "SourCream"};
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (String ingredient : ingredients ) {
            if ( ingredient.equals("Rice")) { burrito.put(ingredient, getRice()); }
            else if ( ingredient.equals("Meat")) { burrito.put(ingredient, getMeat()); }
            else if ( ingredient.equals("Beans")) { burrito.put(ingredient, getBeans()); }
            else if ( ingredient.equals("Salsa")) { burrito.put(ingredient, getSalsa()); }
            else if ( ingredient.equals("Veggies")) { burrito.put(ingredient, getVeggies()); }
            else if ( ingredient.equals("Cheese") ) {
                if (getItem()) {

                }

            }
            else if ( ingredient.equals("Guac") ) {
                if (getItem()) {

                }

            }
            else if ( ingredient.equals("Queso") ) {
                if (getItem()) {

                }

            }
            else if ( ingredient.equals("SourCream") ) {
                if (getItem()) {

                }
                
            }
        }

        for (String keyName : burrito.keySet()) {
            System.out.println("key: " + keyName + " value: " + burrito.get(keyName));
        }
        System.out.println("Number of ingredients: " + totalIngredients);
        System.out.println("The cost of the order is " + formatter.format(calcAmount(totalIngredients)));

    }

    private static double calcAmount( int numberOfIngredients ) {
        double totalAmount = 0.0;
        double basePrice = 3.0;

        totalAmount += basePrice;
        for (int i = 0; i < numberOfIngredients; i++ ) {
            totalAmount += 0.5;
        }

        return totalAmount;
    }

    public static String getRice() {
        String riceName;
        ArrayList<String> rice = new ArrayList<>();
        rice.add("white");
        rice.add("brown");
        rice.add("none");
        rice.add("all");

        int choice = rand.nextInt(rice.size());
        riceName = rice.get(choice);

        if (riceName.equals("all")) {
            totalIngredients += 3;              // Create a method for this?
        }
        else if (riceName.equals("none")) {
            totalIngredients += 0;
        }
        else {
            totalIngredients += 1;
        }

        return riceName;
    }

    private static String getMeat() {
        String meatName;
        ArrayList<String> meat = new ArrayList<>();
        meat.add("chicken");
        meat.add("steak");
        meat.add("carnidas");
        meat.add("chorizo");
        meat.add("sofritas");
        meat.add("veggies");
        meat.add("none");
        meat.add("all");

        int choice = rand.nextInt(meat.size());
        meatName = meat.get(choice);

        if (meatName.equals("all")) {
            totalIngredients += 6;              // Create a method for this?
        }
        else if (meatName.equals("none")) {
            totalIngredients += 0;
        }
        else {
            totalIngredients += 1;
        }

        return meatName;
    }

    private static String getBeans() {
        String beanName = "";
        ArrayList<String> bean = new ArrayList<>();
        bean.add("pinto");
        bean.add("black");
        bean.add("none");

        int choice = rand.nextInt(bean.size());
        beanName = bean.get(choice);

        if (beanName.equals("none")) {
            totalIngredients += 0;              // Create a method for this?
        }
        else {
            totalIngredients += 1;
        }

        return beanName;
    }

    private static String getSalsa() {
        String salsaName = "";
        ArrayList<String> salsa = new ArrayList<>();
        salsa.add("mild");
        salsa.add("medium");
        salsa.add("hot");
        salsa.add("none");
        salsa.add("all");

        int choice = rand.nextInt(salsa.size());
        salsaName = salsa.get(choice);

        if (salsaName.equals("all")) {
            totalIngredients += 3;              // Create a method for this?
        }
        else if (salsaName.equals("none")) {
            totalIngredients += 0;
        }
        else {
            totalIngredients += 1;
        }

        return salsaName;
    }

    private static String getVeggies() {
        String veggieName = "";
        ArrayList<String> veggie = new ArrayList<>();
        veggie.add("lettuce");
        veggie.add("fajita");
        veggie.add("veggies");
        veggie.add("none");
        veggie.add("all");

        int choice = rand.nextInt(veggie.size());
        veggieName = veggie.get(choice);

        if (veggieName.equals("all")) {
            totalIngredients += 3;              // Create a method for this?
        }
        else if (veggieName.equals("none")) {
            totalIngredients += 0;
        }
        else {
            totalIngredients += 1;
        }

        return veggieName;
    }

    // These methods are different from those above, they are Yes/No questions or boolean
    private static boolean getItem() {
        boolean decision = false;
        int choice = rand.nextInt(1);
        if (choice == 1) {
            totalIngredients += 1;
            decision = true;
        }
        return decision;
    }
}
