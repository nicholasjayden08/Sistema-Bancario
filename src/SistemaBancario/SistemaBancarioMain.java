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
                    ContaBancaria contaDeposito = buscarComTentativas(scanner, sistema, "Depositar");
                    if (contaDeposito != null) {
                        System.out.println("Valor a depositar: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.depositar(valorDeposito);
                    }
                    break;
                case 3:
                    ContaBancaria contaSaque = buscarComTentativas(scanner, sistema, "Sacar");
                    if (contaSaque != null) {
                        System.out.println("Valor a sacar: R$ ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.sacar(valorSaque);
                    }
                    break;
                case 4:
                    ContaBancaria contaSaldo = buscarComTentativas(scanner, sistema, "Ver Saldo");
                    if (contaSaldo != null) {
                        contaSaldo.exibirSaldo();
                    }
                    break;
                case 5:
                    ContaBancaria contaHistorico = buscarComTentativas(scanner, sistema, "Ver Histórico");
                    if (contaHistorico != null) {
                        contaHistorico.exibirHistorico();
                    }
                    break;
                case 6:
                    ContaBancaria contaEnvio = buscarComTentativas(scanner, sistema, "Conta do emissor");
                    if (contaEnvio != null) {
                        ContaBancaria contaRecebimento = buscarComTentativas(scanner, sistema, "Conta do recepitor)");

                        if (contaRecebimento != null) {
                            if (contaEnvio.getNumeroConta().equals(contaRecebimento.getNumeroConta())) {
                                System.out.println("❌ Você não pode tranferir para sua própria conta");
                                break;
                            }

                            System.out.println("Valor a Transferir: R$ ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();

                            contaEnvio.transferir(valorTransferencia, contaRecebimento);
                        }
                        else {
                            System.out.println("❌ Conta destinatária não encontrada!");
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

    private static ContaBancaria buscarComTentativas(Scanner scanner, SistemaBancario sistema, String operacao) {
        int tentativas = 2;

        while (tentativas > 0) {
            System.out.println("(" + operacao + ") Digite o número da conta: ");
            String numeroConta = scanner.nextLine();

            ContaBancaria conta = sistema.buscarConta(numeroConta);

            if (conta != null) {
                return conta;
            }

            tentativas--;

            if (tentativas > 0) {
                System.out.println("❌ Conta não encontrada! Tente novamente.");
            }
            else {
                System.out.println("❌ Conta não encontrada!");
            }
        }
        return null;
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
