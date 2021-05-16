/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package Controller;

import Model.MenuItem;
import Model.MenuManager;
import View.MainFrame;
import javax.swing.*;

public class Controller {

    //skapar instanser av objekten
    private MenuManager menuManager = new MenuManager();
    private MainFrame view = new MainFrame(this);


    //Skicka menylista till view (PanelWest) via controller
    public String[] getMenuList(){
        String[] menuList = menuManager.getInfoStrings();
        return menuList;
    }

    //Formulerar kvittot som en array av strängar.Denna skickas till view som gör ett popup-fönster
    public void getReceipt(){
        String[] orderList = menuManager.getOrderInfoStrings();
        if(orderList.length!=0){
            String[] receipt = new String[8 + orderList.length];
            receipt[0]= "Your order ID is: ";
            receipt[1]= Integer.toString(menuManager.getOrderID());
            receipt[2]= "-------------------------";
            for (int i = 0; i<menuManager.getNumberOfItemsOrderList(); i++) {
                receipt[i+3] = orderList[i];
            }
            int howMany = 3+orderList.length;
            receipt[howMany] = "-------------------------";
            receipt[howMany+1] = "Total after tax: ";
            double d = menuManager.placeOrder();
            String strD = Double.toString(d);
            receipt[howMany+2]= strD + " SEK";
            receipt[howMany+3]= "Thank you for placing an order";
            view.printReceipt(receipt);
            menuManager.resetOrder();
            view.updateView();
        }else{
            JOptionPane.showMessageDialog(null,"You need to add an object before checkout.");
        }
    }

    //Lägger till itemobjekt i orderList och itemString till view när add-knappen klickas
    public void addButtonPressed(){
        int whatIndex = view.getListIndex();
        try{
            MenuItem orderItem = menuManager.getOrderListItem(whatIndex);
            int amount = view.getTxtField();
            if(amount>0){
                //view.addOrder(orderItem.toString(),amount);
                String orderItemString = menuManager.getOrderItemString(whatIndex);
                view.addOrder(orderItemString,amount);
                menuManager.addOrder(orderItem, amount, whatIndex);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Please choose an object.");
        }
    }

    //Metod som skriver ut kvittot
    public void exitButtonPressed(){
        getReceipt();
    }
}
