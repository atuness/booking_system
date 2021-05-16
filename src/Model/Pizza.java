/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package Model;

public class Pizza extends MenuItem implements MenuItemI, Food {

    private String[] toppings;
    private String[] margarita = {"Tomatsås","Ost","skinka"};
    private String[] vesuvio = {"Tomatsås","Ost","skinka", "champinjon"};

    //Skapar ett defaultobjekt av Pizza
    public Pizza(){
        setName("Default");
        setItemType(ItemType.food);
        setPrice(89.90);
        setToppings(margarita);
    }

    public Pizza(String name, double price, ItemType type){
        setName(name);
        setItemType(type);
        setPrice(price);
        setToppings(margarita);
        setAmount(0);
        calculateTax();
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public void calculateTax(){
        double finalPrice = price + (price * 0.12);
        setPriceAfterTax(finalPrice);
    }

    private String getToppingString(){
        String topping = "";
        for(int i=0; i< toppings.length; i++){
            topping = topping + " " + toppings[i];
        }
        return topping;
    }

    public String toString(){
        if(getAmount()>0 ){
            return String.format("%dst %s %.2fkr. %s ", getAmount(), getName(), getPrice(), getToppingString());
        }else{
            return String.format("%s %.2fkr. %s ", getName(), getPrice(), getToppingString());
        }
    }
}
