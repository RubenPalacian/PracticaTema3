import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente3 mimarco3=new MarcoCliente3();

        mimarco3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


class MarcoCliente3 extends JFrame{

    public MarcoCliente3(){

        setBounds(600,300,280,350);

        LaminaMarcoCliente3 milamina=new LaminaMarcoCliente3 ();

        add(milamina);

        setVisible(true);
    }

}

class LaminaMarcoCliente3 extends JPanel{

    private JTextField campo3;

    private JButton miboton3;

    public LaminaMarcoCliente3(){

        JLabel texto=new JLabel("CLIENTE3");

        add(texto);

        campo3=new JTextField(20);

        add(campo3);

        miboton3=new JButton("Enviar");
        EnviaTexto evento = new EnviaTexto ();
        miboton3.addActionListener (evento);

        add(miboton3);

    }
    private class EnviaTexto implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Socket misocket=new Socket ("192.168.1.49",9999);

                DataOutputStream flujo_salila= new DataOutputStream(misocket.getOutputStream ());
                flujo_salila.writeUTF ("Cliente3:"+ campo3.getText ());
                flujo_salila.close ();
            } catch (IOException ioException) {
                System.out.println (ioException.getMessage());
            }

        }
    }

}
