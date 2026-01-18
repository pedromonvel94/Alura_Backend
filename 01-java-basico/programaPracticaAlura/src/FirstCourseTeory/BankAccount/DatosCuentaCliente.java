package BankAccount;

import java.util.ArrayList;

public class DatosCuentaCliente {

    public String username;
    public String tipoCuenta;
    public double saldo;
    public String cuentaAhorros;
    public String cuentaCorriente;

    public DatosCuentaCliente(String tipoCuenta) {
        this.username = "pedromonvel";
        this.saldo = 10000000.00;
        this.tipoCuenta = tipoCuenta;
        this.cuentaAhorros = "02175025555";
        this.cuentaCorriente = "31163699999";
    }

    public String getUsername() {
        return username;
    }

    public String getCuentaAhorros() {
        return cuentaAhorros;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setUsername(String nombre) {
        this.username = nombre;
    }

    public void setCuentaAhorros(String cuentaAhorros) {
        this.cuentaAhorros = cuentaAhorros;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
