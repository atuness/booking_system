/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private int width;
    private int height;

    private Controller controller;

    //panels
    private PanelEast pnlEast;
    private PanelWest pnlWest;
    private PanelSouth pnlSouth;

    public MainPanel(Controller controller, int width, int height){
        this.controller = controller;
        this.width = width;
        this.height = height;

        setUpPanel();
    }

    private void setUpPanel(){
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(10, 10,10,10);
        setBorder(new CompoundBorder(border, margin));

        pnlEast = new PanelEast(controller);
        add(pnlEast, BorderLayout.EAST);

        pnlWest = new PanelWest(controller);
        add(pnlWest, BorderLayout.WEST);

        pnlSouth = new PanelSouth(controller);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    //Berättar vilken som är vald
    public int getListIndex(){
        return pnlWest.getListIndex();
    }

    //Berättar vilken som är vald
    public void addOrder(String orderItem, int amount)
    {
        pnlEast.addOrder(orderItem, amount);
    }

    public int getTxtField(){
        return pnlWest.getTxtField();
    }

    public void updateView(){
        pnlEast.removeAll();
        pnlEast = new PanelEast(controller);
        add(pnlEast, BorderLayout.EAST);
        pnlEast.revalidate();
    }
}
