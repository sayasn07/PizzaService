import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Order> orders = new ArrayList<>();
    private Address address;
    private long mobile;
    private String email;
    private String customerName;
    private int customerId;
    private Order order;

    public Customer(int customerId, String customerName, String email, long mobile, Address address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public void addOrder(Order order, Pizza pizza) {
        orders.add(order);
        order.addPizza(pizza);
    }

    public double getPayableAmount() {
        double sum = 0.0;
        for (Order order : orders) {
            sum += order.getPayableBillAmount();
        }
        return sum;
    }

    public List<Pizza> getCustomerOrder() {
        return order.getPizzas();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
//        return order.getPizzas();
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String toString() {
        return "Customer Details => ID : " + getCustomerId() + ", Name : " + getCustomerName() +
                ", Email : " + getEmail() + ", Mobile : " + getMobile() + "\n" + getAddress();
    }
}
