import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class VentanaImpresora extends JFrame {
    private Impresora impresora;
    private JLabel estadoLabel;
    private JButton imprimirBtn, agregarPapelBtn, resolverErrorBtn, errorBtn;

    public VentanaImpresora(Impresora impresora) {
        this.impresora = impresora;
        setTitle("Ventana Impresora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        estadoLabel = new JLabel("Estado: " + impresora.getEstado());

        imprimirBtn = new JButton("Imprimir");
        agregarPapelBtn = new JButton("Recargar Papel");
        resolverErrorBtn = new JButton("Resolver Error");
        errorBtn = new JButton("Crear Error");

        JTextArea consolaArea = new JTextArea(6, 40);
        consolaArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consolaArea);

        PrintStream printStream = new PrintStream(new OutputStream() {
            public void write(int b) {
                SwingUtilities.invokeLater(() -> {
                    consolaArea.append(String.valueOf((char) b));
                    consolaArea.setCaretPosition(consolaArea.getDocument().getLength());
                });
            }
        });
        System.setOut(printStream);
        System.setErr(printStream);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(estadoLabel, BorderLayout.NORTH);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel botonesPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        botonesPanel.add(imprimirBtn);
        botonesPanel.add(agregarPapelBtn);
        botonesPanel.add(resolverErrorBtn);
        botonesPanel.add(errorBtn);

        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Acciones de botones
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

        errorBtn.addActionListener(e -> {
            impresora.setEstado(new EstadoError());
            System.out.println("Error simulado.");
            actualizarEstado();
        });
    }

    private void actualizarEstado() {
        estadoLabel.setText("Estado: " + impresora.getEstado());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Impresora impresora = new Impresora();
            new VentanaImpresora(impresora).setVisible(true);
        });
    }
}
