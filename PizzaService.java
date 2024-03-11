import java.io.File;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class PizzaService implements PizzaInterface {

    private int nextId = 1;
    private String pizzaNotFoundMessage;
    private PizzaStore pizzaStore;

    public PizzaService(PizzaStore pizzaStore) {
        this.pizzaStore = pizzaStore;
    }

    public Pizza addNewPizza(Pizza pizza) {
        pizzaStore.addPizza(pizza);
        return pizza;
    }

    public List<Customer> getCustomers() {
        return pizzaStore.getCustomers();
    }

    @Override
    public void addCustomer(Customer customer) {
        pizzaStore.addCustomer(customer);
    }

    public void deletePizza(Pizza pizza) {
        if(pizzaStore.getPizzas().contains(pizza)) {
            pizzaStore.deletePizza(pizza);
        }
    }

    public Pizza updatePrice(Pizza pizza, double newPrice) {
        if(pizzaStore.getPizzas().contains(pizza)) {
            pizza.setPrice(newPrice);
            return pizza;
        }else {
            return null;
        }
    }

    public List<Pizza> getAllPizzas() {
        return pizzaStore.getPizzas();
    }

    public Pizza orderNewPizza(Pizza pizza, Customer customer) {
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if(getAllPizzas().contains(pizza)) {
            customer.addOrder(new Order(nextId++, formattedDate, pizza.getPrice(), pizza.getTopping().getSpiceLevel()), pizza);
            return pizza;
        } else {
            return null;
        }
    }

    @Override
    public Pizza getPizzaByName(String pizzaName) {
        List<Pizza> pizzas = pizzaStore.getPizzas();
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaName().equals(pizzaName)) {
                return pizza;
            }
        }
        return null;
    }

    @Override
    public Pizza getPizzaById(int pizzaId) {
        List<Pizza> pizzas = pizzaStore.getPizzas();
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaId() == pizzaId) {
                return pizza;
            }
        }
        return null;
    }

    @Override
    public List<Pizza> getPizzaBySize(String size) {
        List<Pizza> pizzas = pizzaStore.getPizzas();
        List<Pizza> pizzasBySize = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            if (pizza.getSize().equals(size)) {
                pizzasBySize.add(pizza);
            }
        }
        return pizzasBySize;
    }

    @Override
    public String toString() {
        return pizzaStore.getStoreName() +
                " \n" + "Pizza Store location: " + pizzaStore.getStoreLocation();
    }
}
