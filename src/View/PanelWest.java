/*Elisabeth Nyström, ai8798, Medieproduktion och processdesign*/

package View;

import Controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class PanelWest extends JPanel {

    private Controller controller;
    private JList txtValue;
    private JTextField txtField;
    private JLabel txtLabel;

    public PanelWest(Controller controller){
        this.controller = controller;
        createComponents();
    }

    private void createComponents(){
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(10, 10,10,10);
        setBorder(new CompoundBorder(border, margin));

        txtValue = new JList(controller.getMenuList());
        txtValue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Dimension dim = new Dimension(300,175);
        txtValue.setPreferredSize(dim);
        add(txtValue, BorderLayout.NORTH);

        txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(260,30));
        add(txtField, BorderLayout.EAST);

        txtLabel = new JLabel("Amount");
        txtLabel.setPreferredSize(new Dimension(50,30));
        add(txtLabel, BorderLayout.WEST);
    }

    //Berättar vilken som är vald
    public int getListIndex() {
        return txtValue.getSelectedIndex();
    }

    public int getTxtField() {
        String input = txtField.getText();
        int intInput = -1;
        try{
            intInput = Integer.parseInt(input);
            return intInput;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please enter a valid amount");
        }
        return -1;
    }

    public void setTxtField(JTextField txtField) {
        this.txtField = txtField;
    }
}
