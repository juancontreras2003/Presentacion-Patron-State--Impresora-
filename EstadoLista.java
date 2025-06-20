public class EstadoLista extends EstadoImpresora {
    @Override
    public void imprimir(Impresora impresora) {
        System.out.println("Comenzando a imprimir...");
        impresora.setEstado(new EstadoImprimiendo());
    }

    @Override
    public void agregarPapel(Impresora impresora) {
        System.out.println("Ya hay papel suficiente.");
    }

    @Override
    public void resolverError(Impresora impresora) {
        System.out.println("No hay error que resolver.");
    }

    @Override
    public String toString() {
        return "Lista para imprimir";
    }
}
