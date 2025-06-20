public class EstadoImprimiendo extends EstadoImpresora {
    @Override
    public void imprimir(Impresora impresora) {
        System.out.println("Ya se está imprimiendo. Espere...");
    }

    @Override
    public void agregarPapel(Impresora impresora) {
        System.out.println("No se puede agregar papel mientras imprime.");
    }

    @Override
    public void resolverError(Impresora impresora) {
        System.out.println("No hay error. Está imprimiendo.");
    }

    @Override
    public String toString() {
        return "Imprimiendo";
    }
}
