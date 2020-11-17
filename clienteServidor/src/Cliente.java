import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco=new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


class MarcoCliente extends JFrame{

    public MarcoCliente(){

        setBounds(600,300,280,350);

        LaminaMarcoCliente milamina=new LaminaMarcoCliente();

        add(milamina);

        setVisible(true);
    }

}

class LaminaMarcoCliente extends JPanel{

    private JTextField campo1;

    private JButton miboton;

    public LaminaMarcoCliente(){

        JLabel texto=new JLabel("CLIENTE1");

        add(texto);

        campo1=new JTextField(20);

        add(campo1);

        miboton=new JButton("Enviar");
        EnviaTexto evento = new EnviaTexto ();
        miboton.addActionListener (evento);

        add(miboton);

    }
private class EnviaTexto implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
       // System.out.println (campo1.getText ());

        try {
            Socket misocket=new Socket ("192.168.1.49",9999);

            DataOutputStream flujo_salila= new DataOutputStream(misocket.getOutputStream ());
            flujo_salila.writeUTF ("Cliente1:"+ campo1.getText ());
            flujo_salila.close ();
        } catch (IOException ioException) {
           System.out.println (ioException.getMessage());
        }

    }
}

}

