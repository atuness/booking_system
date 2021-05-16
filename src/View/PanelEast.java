/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package View;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;

public class PanelEast extends JPanel {

    private Controller controller;
    private JList txtValue;
    private JList txtAmount;
    private DefaultListModel insideList = new DefaultListModel();
    private DefaultListModel insideListAmount = new DefaultListModel();


    public PanelEast(Controller controller){
        this.controller = controller;
        createComponents();
    }

    private void createComponents(){
        txtAmount = new JList(insideListAmount);
        txtAmount.setPreferredSize(new Dimension(30,200));
        add(txtAmount);

        txtValue = new JList(insideList);
        Dimension dim = new Dimension(300,200);
        txtValue.setPreferredSize(dim);
        add(txtValue);
    }

    public void addOrder(String orderItem, int amount){
        insideList.addElement(orderItem);
        insideListAmount.addElement(amount);
    }
}
