public class EstadoError extends EstadoImpresora {
    @Override
    public void imprimir(Impresora impresora) {
        System.out.println("ERROR. No se puede imprimir.");
    }

    @Override
    public void agregarPapel(Impresora impresora) {
        System.out.println("No se puede agregar papel. Hay un error tecnico.");
    }

    @Override
    public void resolverError(Impresora impresora) {
        System.out.println("Error solucionado. Volviendo al estado inicial.");
        impresora.setEstado(new EstadoLista());
    }

    @Override
    public String toString() {
        return "Error de impresion";
    }
}
