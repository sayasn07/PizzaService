public class Address {

    private String state;
    private String district;
    private String city;
    private String street;
    private int doorNumber;

    public Address(int doorNumber, String street, String city, String district, String state) {
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return "Address => Door Number : " + getDoorNumber() + ", Street : " + getStreet() +
                ", City : " + getCity() + ", District : " + getDistrict() + ", State : " + getState();
    }
}
