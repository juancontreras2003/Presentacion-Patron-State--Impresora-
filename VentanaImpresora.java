import javax.swing.*;
import java.awt.*;


public class VentanaImpresora extends JFrame {
    private Impresora impresora;
    private JLabel estadoLabel;
    private JButton  imprimirBtn, agregarPapelBtn, resolverErrorBtn;

    public VentanaImpresora(Impresora impresora) {

        this.impresora = impresora;
        setTitle("Ventana Impresora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        estadoLabel = new JLabel("Estado: " + impresora.getEstado());
        imprimirBtn = new JButton("Imprimir");
        agregarPapelBtn = new JButton("Recargar Papel");
        resolverErrorBtn = new JButton("Resolver Error");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.add(estadoLabel);
        panel.add(imprimirBtn);
        panel.add(agregarPapelBtn);
        panel.add(resolverErrorBtn);

        add(panel);

        imprimirBtn.addActionListener(e -> {
           impresora.imprimir();
            actualizarEstado();
        });

        agregarPapelBtn.addActionListener(e -> {
            impresora.agregarPapel();
            actualizarEstado();
        });

        resolverErrorBtn.addActionListener(e -> {
            impresora.resolverError();
            actualizarEstado();
        });
    }

    private void actualizarEstado() {
        estadoLabel.setText("Estado: " + impresora.getEstado());
    }

    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        VentanaImpresora ventana = new VentanaImpresora(impresora);
        ventana.setVisible(true);
    }
}