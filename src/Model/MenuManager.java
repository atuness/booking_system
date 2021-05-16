/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package Model;

public class MenuManager {

    private MenuItem[] menuList;
    private int numberOfItems = 0;
    private int numberOfItemsOrderList;
    private MenuItem[] orderList;
    private int orderID = 42;

    public MenuManager(){
        menuList = new MenuItem[5];
        //Lägg till 5 st med olika parametrar
        addNewMenuItem("Margarita", 90.99, ItemType.food);
        addNewMenuItem("Vesuvio", 90.00, ItemType.food);
        addNewMenuItem("Hawaii", 79.99, ItemType.food);
        addNewMenuItem("Markaryd Special", 199.99, ItemType.food);
        addNewMenuItem("Calzone", 29.99, ItemType.food);

        orderList = new MenuItem[5];
    }

    public void resetOrder(){
        numberOfItemsOrderList = 0;
        orderList = new MenuItem[5];
        orderID++;
    }

    public void addNewMenuItem(String name,double price, ItemType type){
        menuList[numberOfItems] = new Pizza(name, price, type);
        numberOfItems++;
    }

    public String[] getInfoStrings(){
        String[] menuListStrings = new String[numberOfItems];
        for(int i = 0; i< numberOfItems; i++){
            menuListStrings[i] = menuList[i].toString();
        }
        return menuListStrings;
    }

    public double getPriceAfterTax(int whatIndex){
        return menuList[whatIndex].getPriceAfterTax();
    }

    public MenuItem[] getOrderList() {
        return orderList;
    }

    public MenuItem getOrderListItem(int whatIndex) {
        return menuList[whatIndex];
    }

    public String getOrderItemString(int whatIndex) {
        return menuList[whatIndex].toString();
    }

    public void setOrderList(MenuItem[] orderList) {
        this.orderList = orderList;
    }

    public MenuItem[] getMenuList() {
        return menuList;
    }

    public void setMenuList(MenuItem[] menuList) {
        this.menuList = menuList;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getNumberOfItemsOrderList() {
        return numberOfItemsOrderList;
    }

    public void setNumberOfItemsOrderList(int numberOfItemsOrderList) {
        this.numberOfItemsOrderList = numberOfItemsOrderList;
    }

    public void addOrder(MenuItem orderItem, int amount, int whatIndex){
        orderList[numberOfItemsOrderList] = orderItem;
        orderList[numberOfItemsOrderList].setAmount(amount);
        orderList[numberOfItemsOrderList].getPriceAfterTax();
        numberOfItemsOrderList++;
    }

    //Hämtar priset och antalet för varje Pizza och adderar dem till en totalsumma
    public double placeOrder(){
        double total = 0;
        for(int i = 0; i< numberOfItemsOrderList; i++){
            total = total + (orderList[i].getPriceAfterTax() * orderList[i].getAmount());
        }
        return total;
    }

    public String[] getOrderInfoStrings(){
        String[] orderListStrings = new String[numberOfItemsOrderList];
        for(int i = 0; i< numberOfItemsOrderList; i++){
            orderListStrings[i] = orderList[i].toString();
        }
        return orderListStrings;
    }
}