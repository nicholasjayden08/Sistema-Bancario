package SistemaBancario;

import java.util.Scanner;

public class SistemaBancarioMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistema = new SistemaBancario();

        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do Titular: ");
                    String titular = scanner.nextLine();

                    System.out.println("Número da Conta");
                    String numeroConta = scanner.nextLine();

                    System.out.println("Saldo Inicial: R$ ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine();

                    sistema.criarConta(titular, numeroConta, saldoInicial);
                    break;
                case 2:
                    System.out.println("Número da Conta: ");
                    String numeroContaDeposito = scanner.nextLine();

                    ContaBancaria contaDeposito = sistema.buscarConta(numeroContaDeposito);
                    if (contaDeposito != null) {
                        System.out.println("Valor a depositar: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.depositar(valorDeposito);
                    }
                    break;
                case 3:
                    System.out.println("Número da Conta: ");
                    String numeroContaSaque = scanner.nextLine();

                    ContaBancaria contaSaque = sistema.buscarConta(numeroContaSaque);
                    if (contaSaque != null) {
                        System.out.println("Valor a sacar: R$ ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.sacar(valorSaque);
                    }
                    break;
                case 4:
                    System.out.println("Número da Conta: ");
                    String numeroContaSaldo = scanner.nextLine();

                    ContaBancaria contaSaldo = sistema.buscarConta(numeroContaSaldo);
                    if (contaSaldo != null) {
                        contaSaldo.exibirSaldo();
                    }
                    break;
                case 5:
                    System.out.println("Número da Conta: ");
                    String numeroContaHistorico = scanner.nextLine();

                    ContaBancaria contaHistorico = sistema.buscarConta(numeroContaHistorico);
                    if (contaHistorico != null) {
                        contaHistorico.exibirHistorico();
                    }
                    break;
                case 6:
                    System.out.println("Número da Conta do Emissor: ");
                    String numeroContaEnvio = scanner.nextLine();

                    ContaBancaria contaEnvio = sistema.buscarConta(numeroContaEnvio);
                    if (contaEnvio != null) {
                        System.out.println("Número da Conta do Recepitor");
                        String numeroContaRecebimento = scanner.nextLine();

                        ContaBancaria contaRecebimento = sistema.buscarConta(numeroContaRecebimento);
                        if (contaRecebimento != null) {
                            System.out.println("Valor a Transferir: R$ ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();

                            contaEnvio.transferir(valorTransferencia, contaRecebimento);
                        }
                    }
                    break;
                case 7:
                    sistema.listarTodasAsContas();
                    break;
                case 8:
                    System.out.println("Nome do Titular: ");
                    String nomeRecupera = scanner.nextLine();

                    System.out.println("Coloque o saldo atual de sua conta: ");
                    double saldoRecupera = scanner.nextDouble();
                    scanner.nextLine();

                    sistema.recuperarNumeroConta(nomeRecupera, saldoRecupera);
                    break;
                case 9:
                    rodando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n===== SISTEMA BANCÁRIO =====");
        System.out.println("1. Criar Conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Ver Saldo");
        System.out.println("5. Ver Histórico");
        System.out.println("6. Transferir");
        System.out.println("7. Listar Conta");
        System.out.println("8. Recuperar Conta");
        System.out.println("9. Sair");
        System.out.println("=============================");
        System.out.println("Escolha uma opção");
    }
}
