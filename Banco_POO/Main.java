package Banco_POO;

public class Main {
    public static void main(String[] args) {
        Conta contaUsuario = new Conta(1000.00); // Saldo inicial
        CaixaEletronico caixa = new CaixaEletronico(contaUsuario);
        caixa.iniciar();
    }
}
