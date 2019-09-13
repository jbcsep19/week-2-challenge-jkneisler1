import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

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
 * The decision was made to return void from these methods because each method is responsible for three actions
 * 1) Determine the number of ingredients for the choice made (used to determine the total cost of the order)
 * 2) Format the output string for the particular choices made for each major category
 * 3) Create the individual choices for each major category
 * The first two actions cannot both be returned to the caller without difficulty.
 * Each order is saved in a string array.
 *
 * Assumptions:
 * If a user selects "all" for multiple ingredients, then only one ingredient is added to the ingredients list.
 */

public class ChipotleBuritos {
    private static int numberOfOrders = 25;
    private static Random rand = new Random();
    private static int totalIngredients = 0;
    private static StringBuilder outputTmp = new StringBuilder();
    private static String[] orders = new String[numberOfOrders];

    public static void main(String[] args) {
        int strLength;              // used in the formatting of the StringBuilder object
        String[] ingredients = {"Rice", "Meat", "Beans", "Salsa", "Veggies", "Cheese", "Guac", "Queso", "SourCream"};
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        for (int i = 0; i < numberOfOrders; i++) {          // Establish the orders for 25 burittos
            String eachOrder;
            outputTmp.append("Burrito ");                   // Beginning of each order line
            outputTmp.append((i + 1));
            outputTmp.append(": ");

            for (String ingredient : ingredients) {
                if (ingredient.equals("Rice")) {
                    getRice();
                } else if (ingredient.equals("Meat")) {
                    getMeat();
                } else if (ingredient.equals("Beans")) {
                    getBeans();
                } else if (ingredient.equals("Salsa")) {
                    getSalsa();
                } else if (ingredient.equals("Veggies")) {
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

            // Output for each order
            strLength = outputTmp.length();
            outputTmp.delete(strLength - 2, strLength);     // remove the last ", " in the StringBuilder object
            outputTmp.append("\t");
            outputTmp.append(formatter.format(calcAmount(totalIngredients)));

            eachOrder = outputTmp.toString();               // Final output string for each burrito order
            System.out.println(eachOrder);                  // Print to output
            orders[i] = eachOrder;                          // Saving each individual order
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
    }

    private static void getMeat() {
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
    }

    private static void getBeans() {
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
    }

    private static void getSalsa() {
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
    }

    private static void getVeggies() {
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
    }

    // These methods are different from those above, they are Yes/No questions or boolean
    private static boolean getItem() {
        boolean decision = false;
        int choice = rand.nextInt(2);
        if (choice == 1) {
            totalIngredients += 1;
            decision = true;
        }
        return decision;
    }
}
