package Banco_POO;

public class Conta {
    private double saldo;

    
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    
    public void depositar(double valor) {
        try {
            if (valor <= 0) {
                throw new IllegalArgumentException("O valor para depósito deve ser maior que zero.");
            }
            saldo += valor;
            System.out.println("\033[32mDepósito de R$" + valor + " realizado com sucesso!\033[0m"); // Verde
        } catch (IllegalArgumentException e) {
            System.out.println("\033[31m" + e.getMessage() + "\033[0m"); // Vermelho
        }
    }

    // Método para sacar valor da conta
    public void sacar(double valor) {
        try {
            if (valor <= 0) {
                throw new IllegalArgumentException("O valor para saque deve ser maior que zero.");
            } else if (valor > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }
            saldo -= valor;
            System.out.println("\033[32mSaque de R$" + valor + " realizado com sucesso!\033[0m"); // Verde
        } catch (IllegalArgumentException e) {
            System.out.println("\033[31m" + e.getMessage() + "\033[0m"); // Vermelho
        }
    }

    
    public void verificarSaldo() {
        System.out.println("\033[34mSaldo atual: R$" + saldo + "\033[0m"); // Azul
    }
}


