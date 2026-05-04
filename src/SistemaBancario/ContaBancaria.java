package SistemaBancario;

import java.util.ArrayList;

public class ContaBancaria {
    private String titular;
    private String numeroConta;
    private double saldo;
    private ArrayList<String> historico;

    public ContaBancaria(String titular, String numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();

        historico.add("Conta criada com saldo inicial: R$ " + String.format("%.2f", saldoInicial));
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean temNumeroConta(String numero) {
        return this.numeroConta.equals(numero);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("❌ Valor inválido! Depósito deve ser maior do que 0.");
            return;
        }

        saldo += valor;

        historico.add("Depósito: +R$ " + String.format("%.2f", valor));

        System.out.println("✅ Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("❌ Valor inválido! Saque deve ser maior do que 0.");
            return false;
        }

        if (valor > saldo) {
            System.out.println("❌ Saldo insuficiente! Saldo atual: " + String.format("%.2f", saldo));
            return false;
        }

        saldo -= valor;
        historico.add("Saque: -R$ " + String.format("%.2f", valor));
        System.out.println("✅ Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        System.out.println("Saldo restante: R$ " + String.format("%.2f", saldo));
        return true;
    }

    public void exibirSaldo() {
        System.out.println("\n========== SALDO ==========");
        System.out.println("Titular: " + titular);
        System.out.println("Numero da Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
        System.out.println("===========================\n");
    }

    public void exibirHistorico() {
        System.out.println("\n========== HISTÓRICO ==========");
        System.out.println("Conta: " + numeroConta + " - " + titular);

        for (int i = 0; i < historico.size(); i++) {
            System.out.println((i + 1) + ". " + historico.get(i));
        }
        System.out.println("===============================\n");
    }

    public boolean transferir(double valor, ContaBancaria contaDestino) {
        if (valor <= 0) {
            System.out.println("❌ Valor inválido! Transferencia deve ser maior do que 0.");
            return false;
        }

        if (valor > saldo) {
            System.out.println("❌ Saldo insuficiente! Saldo atual: " + String.format("%.2f", saldo));
            return false;
        }

        saldo -= valor;
        historico.add("Transferência enviada: " + String.format("%.2f", valor) + " para " + contaDestino.getTitular());

        contaDestino.saldo += valor;
        contaDestino.historico.add("Transfêrencia recebida: +R$ " + String.format("%.2f", valor) + " de " + titular);

        System.out.println("✅ Tranferencia de R$ " + String.format("%.2f", valor) + " realizada com sucesso!");
        return true;
    }
}