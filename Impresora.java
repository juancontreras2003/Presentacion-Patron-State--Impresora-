public class Impresora {
    private EstadoImpresora estado;

    public Impresora() {
        this.estado = new EstadoSinPapel(); // Estado inicial
    }

    public void setEstado(EstadoImpresora estado) {
        this.estado = estado;
    }

    public EstadoImpresora getEstado() {
        return estado;
    }

    public void imprimir() {
        estado.imprimir(this);
    }

    public void agregarPapel() {
        estado.agregarPapel(this);
    }

    public void resolverError() {
        estado.resolverError(this);
    }
}
