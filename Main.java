public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        impresora.imprimir();           // No hay papel
        impresora.agregarPapel();       // Recarga papel
        impresora.imprimir();           // Ahora sí imprime
        impresora.resolverError();      // No hace nada
        impresora.setEstado(new EstadoError());
        impresora.imprimir();           // Bloqueado
        impresora.resolverError();      // Soluciona error
        impresora.imprimir();           // Vuelve a imprimir
    }
}
