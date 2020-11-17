import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente2 mimarco=new MarcoCliente2 ();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


class MarcoCliente2 extends JFrame{

    public MarcoCliente2(){

        setBounds(600,300,280,350);

        LaminaMarcoCliente2 milamina=new LaminaMarcoCliente2 ();

        add(milamina);

        setVisible(true);
    }

}

class LaminaMarcoCliente2 extends JPanel{

    private JTextField campo2;

    private JButton miboton2;

    public LaminaMarcoCliente2(){

        JLabel texto=new JLabel("CLIENTE2");

        add(texto);

        campo2=new JTextField(20);

        add(campo2);

        miboton2=new JButton("Enviar");
        EnviaTexto2 evento = new EnviaTexto2 ();
        miboton2.addActionListener (evento);

        add(miboton2);

    }
    private class EnviaTexto2 implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println (campo1.getText ());

            try {
                Socket misocket=new Socket ("192.168.1.49",9999);

                DataOutputStream flujo_salila= new DataOutputStream(misocket.getOutputStream ());
                flujo_salila.writeUTF ("Cliente2:"+ campo2.getText ());
                flujo_salila.close ();
            } catch (IOException ioException) {
                System.out.println (ioException.getMessage());
            }

        }
    }

}

