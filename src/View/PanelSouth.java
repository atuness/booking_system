/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSouth extends JPanel{

    private Controller controller;
    private JButton btnAdd;
    private JButton btnExit;

    public PanelSouth(Controller controller){
        this.controller = controller;
        createComponents();
        addListeners();
    }

    private void createComponents(){
        btnAdd = new JButton("Add to cart");
        Dimension dim = new Dimension(50,50);
        btnAdd.setSize(dim);
        add(btnAdd);

        btnExit = new JButton("Checkout");
        btnExit.setSize(dim);
        add(btnExit);
    }

    //Connect button to event-handler methods
    private void addListeners(){
        ActionListener listener = new ButtonActionListeners();
        btnAdd.addActionListener(listener);
        btnExit.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnAdd){
                controller.addButtonPressed();
            }else if(e.getSource() == btnExit){
                controller.exitButtonPressed();
            }
        }
    }
}
