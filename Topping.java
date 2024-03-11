public class Topping {

    private String description;
    private String spiceLevel;
    private String toppingName;

    public Topping(String toppingName, String spiceLevel, String description) {
        this.toppingName = toppingName;
        this.spiceLevel = spiceLevel;
        this.description = description;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Toppings Details => Topping Name : " + getToppingName() +
                ", SpiceLevel : " + getSpiceLevel() + ", Description : " + getDescription();
    }
}
