package SistemaBancario;

import java.util.ArrayList;

public class SistemaBancario {
    private ArrayList<ContaBancaria> contas;

    public SistemaBancario() {
        contas = new ArrayList<>();
    }

    public void criarConta(String titular, String numeroConta, double saldoInicial) {
        if (contaExiste(numeroConta)) {
            System.out.println("Erro! Já existe uma conta com este número");
            return;
        }

        ContaBancaria novaConta = new ContaBancaria(titular, numeroConta, saldoInicial);

        contas.add(novaConta);

        System.out.println("✅ Conta criada com sucesso");
        System.out.println("Titular: " + titular);
        System.out.println("Numero da Conta: " + numeroConta);
        System.out.println("Saldo Inicial: R$ " + String.format("%.2f", saldoInicial));
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.temNumeroConta(numeroConta)) {
                return conta;
            }
        }
        System.out.println("❌ Conta não encontrada");
        return null;
    }

    public boolean contaExiste(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.temNumeroConta(numeroConta)) {
                return true;
            }
        }
        return false;
    }

    public void listarTodasAsContas() {
        if (contas.isEmpty()) {
            System.out.println("❌ Nenhuma conta cadastrada");
            return;
        }

        System.out.println("\n========== CONTAS CADASTRADAS ==========");
        for (int i = 0; i < contas.size(); i++) {
            ContaBancaria conta = contas.get(i);
            System.out.println((i + 1) + ". " + conta.getTitular() + " | Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        }
        System.out.println("========================================\n");
    }

    public void recuperarNumeroConta(String nome, double saldo) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(nome) && conta.getSaldo() == saldo) {
                System.out.println("\n✅ Conta Encontrada!");
                System.out.println("Número da Conta: " + conta.getNumeroConta());
                System.out.println("Titular da Conta: " + conta.getTitular());
                System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
                return;
            }
        }
        System.out.println("❌ Conta não encontrada com as informações fornecidas");
    }
}
