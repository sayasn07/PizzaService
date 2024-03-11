import java.util.*;

public class PizzaDashboard {
    public static void main(String[] args) {
        PizzaService pizzaService = new PizzaService(new PizzaStore(7, "Sayasat's Pizza - Savory Culinary Adventures", "SDU, Kaskelen"));
        Scanner in = new Scanner(System.in);
        PizzaAdministration administration = new PizzaAdministration();
        while(true) {
            System.out.println("Hey Buddy, Welcome to " + pizzaService + "\n");
            System.out.println("choose your Role to Login : ");
            System.out.println("1) ADMIN");
            System.out.println("2) CUSTOMER");
            System.out.println("3) EXIT");
            int choice;
            try {
                choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1:
                        administration.openAdminRole(in, pizzaService);
                        break;
                    case 2:
                        administration.openCustomerRole(in, pizzaService);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Option. Try again !!!");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }
}

