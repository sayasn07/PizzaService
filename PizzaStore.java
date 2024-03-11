import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class PizzaStore {

    List<Customer> customers = new ArrayList<>();
    List<Pizza> pizzas = new ArrayList<>();
    private String storeLocation;
    private String storeName;
    private int storeId;

    public PizzaStore() {}

    public PizzaStore(int storeId, String storeName, String storeLocation) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void deletePizza(Pizza pizza) {
        pizzas.remove(pizza);

    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String toString() {
        return getStoreName() +
                " \n" + "Pizza Store location: " + getStoreLocation();
    }
}
