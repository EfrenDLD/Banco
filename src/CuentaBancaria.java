public interface CuentaBancaria {
    double consultarSaldo();
    void depositar(double cantidad);
    boolean retirar(double cantidad);
    boolean transferir(double cantidad, CuentaBancaria cuentaDestino);
}
