public class EstadoSinPapel extends EstadoImpresora {
    @Override
    public void imprimir(Impresora impresora) {
        System.out.println("No se puede imprimir. No hay papel.");
    }

    @Override
    public void agregarPapel(Impresora impresora) {
        System.out.println("Papel recargado. Lista para imprimir.");
        impresora.setEstado(new EstadoLista());
    }

    @Override
    public void resolverError(Impresora impresora) {
        System.out.println("No hay error tecnico.");
    }

    @Override
    public String toString() {
        return "Sin papel";
    }
}
