public class CuentaBancariaImpl implements CuentaBancaria{
    private double saldo;
    public CuentaBancariaImpl(double saldoInicial){
        this.saldo = saldoInicial;
    }
    @Override
    public double consultarSaldo() {
        return saldo;
    }
    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean transferir(double cantidad, CuentaBancaria cuentaDestino) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            cuentaDestino.depositar(cantidad);
            return true;
        } else {
            return false;
        }
    }
}