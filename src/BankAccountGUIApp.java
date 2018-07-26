/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viruz
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import model.BankAccountModel;
import view.*;

public class BankAccountGUIApp {

    public static void main(String[] args) {
        //Model
        BankAccountModel model = new BankAccountModel(10000.00);
        //Views
        BankAccountView view = new BankAccountView(model);
        ManagerView view2 = new ManagerView();

        model.addObserver(view2);

        JFrame frame = new JFrame();
        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frame.addWindowListener(wa);
        frame.getContentPane().add(view);
        frame.pack();
        frame.show();
    }
}
