package Banco_Encapsulado;

public class Main {
    public static void main(String[] args) {
        // Criação de uma conta bancária
        ContaBancaria conta = new ContaBancaria("João Silva", 500.0);

        // Exibindo informações da conta
        conta.exibirInformacoes();

        // Realizando operações de depósito e saque
        conta.depositar(150.0);
        conta.sacar(100.0);
        conta.sacar(600.0);  // Tentativa de saque maior que o saldo

        // Exibindo informações novamente
        conta.exibirInformacoes();
    }
}
