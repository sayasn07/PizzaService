import java.util.List;

public interface PizzaInterface {

    Pizza getPizzaById(int pizzaId);

    List<Pizza> getAllPizzas();

    List<Pizza> getPizzaBySize(String size);

    Pizza getPizzaByName(String pizzaName);

    Pizza orderNewPizza(Pizza pizza, Customer customer);

    void deletePizza(Pizza pizza);

    Pizza addNewPizza(Pizza pizza);

    Pizza updatePrice(Pizza pizza, double newPrice);

    void addCustomer(Customer customer);

    List<Customer> getCustomers();
}
