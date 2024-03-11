import java.util.*;

public class PizzaAdministration {

    private static int pizzaId = 1;
    private static int customerId = 1;

    private static final String error = "Pizza was not found !!!";
    public static void openAdminRole(Scanner in, PizzaInterface pizzaService) {

        System.out.println("Welcome to ADMIN console !!!");
        while (true) {
            System.out.println("choose an Option : ");
            System.out.println("1) Add Pizza");
            System.out.println("2) Update Price");
            System.out.println("3) Delete Pizza");
            System.out.println("4) View All Pizza");
            System.out.println("5) Search Pizza");
            System.out.println("6) Exit");
            int choice;
            try {
                choice = in.nextInt();
                System.out.println();
                in.nextLine();

                switch (choice) {
                    case 1:
                        addPizza(in, pizzaService);
                        break;
                    case 2:
                        updatePrice(in, pizzaService);
                        break;
                    case 3:
                        deletePizza(in, pizzaService);
                        break;
                    case 4:
                        viewAllPizza(pizzaService);
                        break;
                    case 5:
                        searchPizza(in,pizzaService);
                        break;
                    case 6:
                        System.out.println("Thank you, ADMIN !!!");
                        return;
                    default:
                        System.out.println("Invalid value. Enter number between 1 and 6");
                }
            } catch (Exception e) {
                System.out.println(e);
                if(!(e.getMessage()==error)) {
                    System.exit(0);
                }
            }
        }
    }


    public static void openCustomerRole(Scanner in, PizzaInterface pizzaService) {

        Customer customer = null;
        try {
            System.out.println("Welcome to CUSTOMER console !!!");
            System.out.println("Enter your doorNumber, street, city, district, state...");
            String text1 = in.nextLine();
            String[] address1 = text1.split(", ");
            int doorNumber = 0;
            String street = "", city = "", district = "", state = "";
            if (address1.length == 5) {
                doorNumber = Integer.parseInt(address1[0]);
                street = address1[1];
                city = address1[2];
                district = address1[3];
                state = address1[4];
            }
            Address address = new Address(doorNumber, street, city, district, state);

            System.out.println("Enter your Details as name, email, mobile...");
            String text2 = in.nextLine();
            String[] address2 = text2.split(", ");
            long mobile = 0;
            String name = "", email = "";
            if (address2.length == 3) {
                name = address2[0];
                email = address2[1];
                mobile = Long.parseLong(address2[2]);
            }
            customer = new Customer(customerId++, name, email, mobile, address);

            System.out.println("\nWe added you as our New Customer...\n");
            pizzaService.addCustomer(customer);
            System.out.println(customer + "\n");
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        while (true) {
            System.out.println("choose an Option : ");
            System.out.println("1) Order Pizza");
            System.out.println("2) Pay Bill");
            System.out.println("3) View All Pizza");
            System.out.println("4) View your Orders");
            System.out.println("5) Search Pizza");
            System.out.println("6) Exit");
            int choice;
            try {
                choice = in.nextInt();
                System.out.println();
                in.nextLine();

                switch (choice) {
                    case 1:
                        orderNewPizza(in, pizzaService, customer);
                        break;
                    case 2:
                        System.out.println("<=>Check your order's Bill Amount here...<=>\n");
                        System.out.println("Your Payable Bill Amount for all your orders is Rs : $" + customer.getPayableAmount() + "\n");
                        break;
                    case 3:
                        viewAllPizza(pizzaService);
                        break;
                    case 4:
                        viewAllYourOrders(pizzaService);
                        break;
                    case 5:
                        searchPizza(in, pizzaService);
                        break;
                    case 6:
                        System.out.println("Thank you for visiting us, come again !!!");
                        return;
                    default:
                        System.out.println("Invalid value. Enter number between 1 and 6");
                }
            } catch (Exception e) {
                System.out.println(e);
                if(!(e.getMessage()==error)) {
                    System.exit(0);
                }
            }
        }
    }

    public static void addPizza(Scanner in, PizzaInterface pizzaService) {
        System.out.println("<=>Add New Pizza Menu<=>\n");
        System.out.println("Enter Details as name of Topping, spice level(basic/mediate/full), description to add a new Topping...");
        String input1 = in.nextLine();
        String[] parts1 = input1.split(", ");
        String topping = "", spiceLevel = "", description = "";
        if(parts1.length==3) {
            topping = parts1[0];
            spiceLevel = parts1[1];
            description = parts1[2];
        }
        String[] validSpiceLevels = {"basic", "mediate", "full"};
        boolean found = false;
        for (String level : validSpiceLevels) {
            if (level.equals(spiceLevel)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ArrayIndexOutOfBoundsException("Invalid spice level. Enter 'basic', 'mediate', or 'full'.");
        }
        Topping topping1 = new Topping(topping, spiceLevel, description);

        System.out.println("Enter Details as name of Base, type(thin/thick), description to add a new PizzaBase...");
        String baseName = "", type = "", description1 = "";
        String input2 = in.nextLine();
        String[] parts2 = input2.split(", ");
        if(parts2.length==3) {
            baseName = parts2[0];
            type = parts2[1];
            description1 = parts2[2];
        }

        if(!(type.equals("thin") || type.equals("thick"))) {
            throw new ArrayIndexOutOfBoundsException("Invalid type. Enter 'thin' or 'thick'.");
        }
        PizzaBase pizzaBase = new PizzaBase(baseName, type, description1);

        System.out.println("Enter Details as name of Pizza, price, size(small/medium/large) to add a new Pizza...");
        String input3 = in.nextLine();
        String[] parts3 = input3.split(", ");
        String pizzaName = "", size = "";
        double price = 0.0;
        if (parts3.length == 3) {
            pizzaName = parts3[0];
            price = Double.parseDouble(parts3[1]);
            size = parts3[2];
        }
        if(!(size.equals("small") || size.equals("medium") || size.equals("large"))) {
            throw new ArrayIndexOutOfBoundsException("Invalid type. Enter 'small' or 'medium' or 'large.");
        }
        Pizza newPizza = new Pizza(pizzaId++, pizzaName, price, size, topping1, pizzaBase);
        pizzaService.addNewPizza(newPizza);
        System.out.println("New Pizza Added Successfully !!!\n");
        System.out.println(newPizza + "\n");
    }

    public static void updatePrice(Scanner in, PizzaInterface pizzaService) throws PizzaNotFoundException {
        if(pizzaService.getAllPizzas().isEmpty()) {
            throw new PizzaNotFoundException(error);
        }else {
            System.out.println("<=>Update Pizza Menu<=>\n");
            System.out.println("Enter Pizza Name : ");
            String nameToChange = in.nextLine();
            System.out.println("Enter New Price to be updates : ");
            double priceToChange = in.nextDouble();
            in.nextLine();
            Pizza pizzaToUpdate = pizzaService.getPizzaByName(nameToChange);
            if (pizzaToUpdate != null) {
                pizzaService.updatePrice(pizzaToUpdate, priceToChange);
                System.out.println("Pizza Details updated Successfully !!!");
                System.out.println(pizzaToUpdate);
            } else {
                throw new PizzaNotFoundException(error);
            }
        }
    }

    public static void deletePizza(Scanner in, PizzaInterface pizzaService) throws PizzaNotFoundException {
        if(pizzaService.getAllPizzas().isEmpty()) {
            throw new PizzaNotFoundException(error);
        }else {
            System.out.println("<=>Delete Pizza Menu<=>\n");
            System.out.println("Enter Pizza Name : ");
            String nameToDelete = in.nextLine();
            Pizza pizzaToDelete = pizzaService.getPizzaByName(nameToDelete);
            if (pizzaToDelete != null) {
                pizzaService.deletePizza(pizzaToDelete);
                System.out.println("Pizza Deleted Successfully !!!");
            } else {
                throw new PizzaNotFoundException(error);
            }
        }
    }

    public static void viewAllPizza(PizzaInterface pizzaService) throws PizzaNotFoundException {
        System.out.println("<=>View All Pizza Menu<=>");
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        if(pizzas.isEmpty()) {
            throw new PizzaNotFoundException(error);
        }else {
            for(Pizza pizza : pizzas) {
                System.out.println(pizza + "\n");
            }
        }
    }

    public static void searchPizza(Scanner in, PizzaInterface pizzaService) throws PizzaNotFoundException {
        if(pizzaService.getAllPizzas().isEmpty()) {
            throw new PizzaNotFoundException(error);
        }else {
            System.out.println("<=>Search Pizza Menu<=>\n");
            System.out.println("Choose Your Type : ");
            System.out.println("1) Search by Name");
            System.out.println("2) Search by ID");
            System.out.println("3) Search by Size");
            int choice1;
            try {
                choice1 = in.nextInt();
                in.nextLine();

                switch (choice1) {
                    case 1:
                        System.out.println("Enter Pizza Name to Search : ");
                        String name2 = in.nextLine();
                        Pizza byName = pizzaService.getPizzaByName(name2);
                        if (pizzaService.getAllPizzas().contains(byName)) {
                            System.out.println(byName + "\n");
                        } else {
                            throw new PizzaNotFoundException(error);
                        }
                        break;
                    case 2:
                        System.out.println("Enter Pizza ID to Search : ");
                        int id = in.nextInt();
                        Pizza byId = pizzaService.getPizzaById(id);
                        if (pizzaService.getAllPizzas().contains(byId)) {
                            System.out.println(byId + "\n");
                        } else {
                            throw new PizzaNotFoundException(error);
                        }
                        break;
                    case 3:
                        System.out.println("Enter Pizza Size to Search : ");
                        String size1 = in.nextLine();
                        List<Pizza> bySize = pizzaService.getPizzaBySize(size1);
                        if (bySize.isEmpty()) {
                            throw new PizzaNotFoundException(error);
                        } else {
                            for (Pizza pizza : bySize) {
                                System.out.println(pizza + "\n");
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid input. Enter number between 1 and 3");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void orderNewPizza(Scanner in, PizzaInterface pizzaService, Customer customer) throws PizzaNotFoundException {
        if(pizzaService.getAllPizzas().isEmpty()) {
            throw new PizzaNotFoundException(error);
        }else {
            System.out.println("<=>Order new Pizza Menu<=>\n");
            System.out.println("Available Pizzas : ");
            System.out.print("[");
            List<Pizza> pizzaNames = pizzaService.getAllPizzas();
            for (Pizza name : pizzaNames) {
                System.out.println(name + "\n");
            }
            System.out.println("]\n");
            System.out.println("Enter Pizza Name to Place your Order : ");
            String orderPizza = in.nextLine();
            Pizza orderedPizza = pizzaService.getPizzaByName(orderPizza);
            if (orderedPizza != null) {
                pizzaService.orderNewPizza(orderedPizza, customer);
                System.out.println("\nYour order has been successfully placed !!!\n");
            } else {
                System.out.println("Pizza or customer not found.");
            }
        }
    }

    public static void viewAllYourOrders(PizzaInterface pizzaService) throws PizzaNotFoundException {
        if (pizzaService.getAllPizzas().isEmpty()) {
            throw new PizzaNotFoundException(error);
        } else {
            System.out.println("Your Orders : ");
            List<Customer> customers = pizzaService.getCustomers();
            for (Customer customer : customers) {
                System.out.println("Customer: " + customer.getCustomerName());
                List<Order> orders = customer.getOrders();
                for (Order order : orders) {
                    System.out.println("\n" + order);
                    List<Pizza> pizzasInOrder = order.getPizzas();
                    for (Pizza pizza : pizzasInOrder) {
                        System.out.println(pizza);
                    }
                }
            }
        }
    }
}
