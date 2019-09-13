import java.text.NumberFormat;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.Random;
// import java.util.Scanner;

/**
 * Author:  John Kneisler
 * Date:    09/13/19
 *
 * Purpose:
 * The purpose of this program is to assemble 25 burritos.  There will be a random number of
 * ingredients on each.  An amount is determined for each burrito and a total amount is calculeted.
 * Each burrito is printed as well as its ingredients.
 *
 * Design Decisions:
 * Each major choice of ingredients where multiple choices are required were encapsulated in their own method.
 * For ingredients that are yes|no choices, a single method was created for them.
 *
 * Assumptions:
 * If a user selects "all" for multiple ingredients, then only one ingredient is added to the ingredients list.
 */

public class ChipotleBuritos {
    // private static Scanner key = new Scanner(System.in);
    private static Random rand = new Random();
    private static int totalIngredients = 0;
    private static StringBuilder outputTmp = new StringBuilder();

    public static void main(String[] args) {
        int numberOfOrders = 25;
        int strLength;              // used in the formatting of the StringBuilder object
        // HashMap<String, String> burrito = new HashMap<>();
        String[] ingredients = {"Rice", "Meat", "Beans", "Salsa", "Veggies", "Cheese", "Guac", "Queso", "SourCream"};
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (int i = 0; i < numberOfOrders; i++) {              // Establish the orders for 25 burittos

            for (String ingredient : ingredients) {
                if (ingredient.equals("Rice")) {
                    // burrito.put(ingredient, getRice());
                    getRice();
                } else if (ingredient.equals("Meat")) {
                    // burrito.put(ingredient, getMeat());
                    getMeat();
                } else if (ingredient.equals("Beans")) {
                    // burrito.put(ingredient, getBeans());
                    getBeans();
                } else if (ingredient.equals("Salsa")) {
                    // burrito.put(ingredient, getSalsa());
                    getSalsa();
                } else if (ingredient.equals("Veggies")) {
                    // burrito.put(ingredient, getVeggies());
                    getVeggies();
                } else if (ingredient.equals("Cheese")) {
                    if (getItem()) {
                        outputTmp.append("cheese, ");
                    }
                } else if (ingredient.equals("Guac")) {
                    if (getItem()) {
                        outputTmp.append("guac, ");
                    }
                } else if (ingredient.equals("Queso")) {
                    if (getItem()) {
                        outputTmp.append("queso, ");
                    }

                } else if (ingredient.equals("SourCream")) {
                    if (getItem()) {
                        outputTmp.append("sour cream, ");
                    }
                }
            }

            // Output for the orders
            /*
            for (String keyName : burrito.keySet()) {
                System.out.println("key: " + keyName + " value: " + burrito.get(keyName));
            }
            System.out.println("Number of ingredients: " + totalIngredients);
            System.out.println("The cost of the order is " + formatter.format(calcAmount(totalIngredients)));

            outputTmp.append("\t");
            outputTmp.append(formatter.format(calcAmount(totalIngredients)));

            System.out.println(outputTmp.toString());
            System.out.println();

             */
            strLength = outputTmp.length();
            outputTmp.delete(strLength - 2, strLength);         // remove the last ", " in the StringBuilder object
            outputTmp.append("\t");
            outputTmp.append(formatter.format(calcAmount(totalIngredients)));

            System.out.println(outputTmp.toString());
            System.out.println();

            outputTmp.delete(0, outputTmp.length());        // Start with an empty StringBulider object for each order
            totalIngredients = 0;                           // Zero out the totalIngredients for the next order
        }
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

    private static void getRice() {
    // private static String getRice() {
        String riceName;
        ArrayList<String> rice = new ArrayList<>();
        rice.add("white");
        rice.add("brown");
        rice.add("none");
        rice.add("all");

        int choice = rand.nextInt(rice.size());
        riceName = rice.get(choice);

        if ( riceName.equals("none") ) {
            outputTmp.append("no rice, ");
        }
        else if ( riceName.equals("all") ) {
            totalIngredients += 1;
            outputTmp.append("white rice, brown rice, ");
        }
        else {
            totalIngredients += 1;
            outputTmp.append(riceName);
            outputTmp.append(" rice, ");
        }

        // return riceName;
    }

    private static void getMeat() {
    // private static String getMeat() {
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

        if ( meatName.equals("none") ) {
            outputTmp.append("no meat, ");
        }
        else if ( meatName.equals("all") ) {
            totalIngredients += 1;
            outputTmp.append("chicken, steak, carnidas, chorizo, sofritas, veggies, ");
        }
        else {
            totalIngredients += 1;
            outputTmp.append(meatName);
            outputTmp.append(", ");
        }

        // return meatName;
    }

    private static void getBeans() {
    // private static String getBeans() {
        String beanName;
        ArrayList<String> bean = new ArrayList<>();
        bean.add("pinto");
        bean.add("black");
        bean.add("none");

        int choice = rand.nextInt(bean.size());
        beanName = bean.get(choice);

        if ( beanName.equals("none") ) {
            outputTmp.append("no beans, ");
        }
        else if ( beanName.equals("all") ) {
            totalIngredients += 1;
            outputTmp.append("pinto beans, black beans, ");
        }
        else {
            totalIngredients += 1;
            outputTmp.append(beanName);
            outputTmp.append(" beans, ");
        }

        // return beanName;
    }

    private static void getSalsa() {
    // private static String getSalsa() {
        String salsaName;
        ArrayList<String> salsa = new ArrayList<>();
        salsa.add("mild");
        salsa.add("medium");
        salsa.add("hot");
        salsa.add("none");
        salsa.add("all");

        int choice = rand.nextInt(salsa.size());
        salsaName = salsa.get(choice);

        if ( salsaName.equals("none") ) {
            outputTmp.append("no salsa, ");
        }
        else if ( salsaName.equals("all") ) {
            totalIngredients += 1;
            outputTmp.append("mild salsa, medium salsa, hot salsa, ");
        }
        else {
            totalIngredients += 1;
            outputTmp.append(salsaName);
            outputTmp.append(" salsa, ");
        }

        // return salsaName;
    }

    private static void getVeggies() {
    // private static String getVeggies() {
        String veggieName;
        ArrayList<String> veggie = new ArrayList<>();
        veggie.add("lettuce");
        veggie.add("fajita veggies");
        veggie.add("none");
        veggie.add("all");

        int choice = rand.nextInt(veggie.size());
        veggieName = veggie.get(choice);

        if ( veggieName.equals("none") ) {
            outputTmp.append("no veggies, ");
        }
        else if ( veggieName.equals("all") ) {
            totalIngredients += 1;
            outputTmp.append("lettuce, fajita veggies, ");
        }
        else {
            totalIngredients += 1;
            outputTmp.append(veggieName);
            outputTmp.append(", ");
        }

        // return veggieName;
    }

    // These methods are different from those above, they are Yes/No questions or boolean
    private static boolean getItem() {
        boolean decision = false;
        int choice = rand.nextInt(2);
        // System.out.println("CHOICE: " + choice);             REMOVE
        if (choice == 1) {
            totalIngredients += 1;
            decision = true;
        }
        return decision;
    }
}
