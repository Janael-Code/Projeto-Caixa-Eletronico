package Banco_POO;

import java.util.Scanner;

public class CaixaEletronico {
    private Conta conta;
    private Scanner scanner;

   
    public CaixaEletronico(Conta conta) {
        this.conta = conta;
        this.scanner = new Scanner(System.in);
    }

    
    public void iniciar() {
        System.out.println("\033[1;36mBem-vindo ao Caixa Eletrônico!\033[0m"); // Azul claro

        boolean continuar = true;

        while (continuar) {
            exibirMenu();

            int opcao = obterOpcaoMenu();

            switch (opcao) {
                case 1:
                    realizarDeposito();
                    break;
                case 2:
                    realizarSaque();
                    break;
                case 3:
                    conta.verificarSaldo();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\033[1;33mObrigado por usar o Caixa Eletrônico! Até logo!\033[0m"); // Amarelo
                    break;
                default:
                    System.out.println("\033[31mOpção inválida. Tente novamente.\033[0m"); // Vermelho
            }
        }

        scanner.close();
    }

    
    private void exibirMenu() {
        System.out.println("\n\033[1;35mEscolha uma operação:\033[0m"); // Roxo
        System.out.println("\033[1;32m1 - Depositar\033[0m"); // Verde
        System.out.println("\033[1;32m2 - Sacar\033[0m"); // Verde
        System.out.println("\033[1;32m3 - Verificar Saldo\033[0m"); // Verde
        System.out.println("\033[1;31m4 - Sair\033[0m"); // Vermelho
    }

    // Método para obter uma opção válida do menu
    private int obterOpcaoMenu() {
        int opcao = -1;

        while (opcao < 1 || opcao > 4) {
            try {
                System.out.print("\033[1;33mDigite sua opção: \033[0m");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao < 1 || opcao > 4) {
                    throw new IllegalArgumentException("Opção inválida. Escolha entre 1 e 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\033[31mPor favor, insira um número válido.\033[0m"); // Vermelho
            } catch (IllegalArgumentException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m"); // Vermelho
            }
        }
        return opcao;
    }

    
    private void realizarDeposito() {
        double valor = obterValorOperacao("depositar");
        conta.depositar(valor);
    }

    
    private void realizarSaque() {
        double valor = obterValorOperacao("sacar");
        conta.sacar(valor);
    }

    
    private double obterValorOperacao(String tipo) {
        double valor = -1;
        while (valor <= 0) {
            try {
                System.out.print("\033[1;33mDigite o valor que deseja " + tipo + ": \033[0m");
                valor = Double.parseDouble(scanner.nextLine());
                if (valor <= 0) {
                    throw new IllegalArgumentException("O valor deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\033[31mPor favor, insira um valor válido.\033[0m"); // Vermelho
            } catch (IllegalArgumentException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m"); // Vermelho
            }
        }
        return valor;
    }
}
