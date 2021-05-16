/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package Model;

public abstract class MenuItem {

    private String name;
    double price;
    ItemType itemType;
    int amount;
    double priceAfterTax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceAfterTax() {
        return priceAfterTax;
    }

    public void setPriceAfterTax(double priceAfterTax) {
        this.priceAfterTax = priceAfterTax;
    }
}
