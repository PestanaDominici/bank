package com.pestana.poo;

import java.util.Objects;

public class ContaBanco {
    // atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    // Metodos personalizados
    public void estadoAtual() {
        System.out.println("-------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (Objects.equals(t, "CC")) {
            this.setSaldo(50);
        } else if(Objects.equals(t, "CP")) {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("ERRO! Conta com saldo! Retirar todo dinheiro.");
        } else if (this.getSaldo() < 0) {
            System.out.println("ERRO! Você esta em debto!");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }
    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(getSaldo() + v);
            System.out.println("Deposito realizado na conta de " + this.getDono());
        } else {
            System.out.println("ERRO! Voce nao tem conta!");
        }
    }
    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("ERRO! Saldo insuficiente!");
            }
        } else {
            System.out.println("ERRO! Voce nao tem conta!");
        }
    }
    public void pagarMensal() {
        int v = 0;
        if (Objects.equals(tipo, "CC")) {
            v = 12;
        } else if (Objects.equals(tipo, "CP")) {
            v = 20;
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("ERRO! Voce nao tem conta");
        }
    }
    // metodos especiais
    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }
    public void setNumConta(int n) {
        this.numConta = n;
    }
    public int getNumConta() {
        return this.numConta;
    }
    public void setTipo(String t) {
        this.tipo = t;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setDono(String d) {
        this.dono = d;
    }
    public String getDono() {
        return this.dono;
    }
    public void setSaldo(float s) {
        this.saldo = s;
    }
    public float getSaldo() {
        return this.saldo;
    }
    public void setStatus(boolean st) {
        this.status = st;
    }
    public boolean getStatus() {
        return this.status;
    }

}
