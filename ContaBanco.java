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
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (Objects.equals(t, "CC")) {
            this.setSaldo(50);
        } else if(Objects.equals(t, "CP")) {
            this.setSaldo(150);
        }
    }
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("ERRO! Conta com saldo! Retirar todo dinheiro.");
        } else if (this.getSaldo() < 0) {
            System.out.println("ERRO! Você esta em debto!");
        } else {
            this.setStatus(false);
        }
    }
    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(getSaldo() + v);
        } else {
            System.out.println("ERRO! Voce nao tem conta!");
        }
    }
    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() > v) {
                this.setSaldo(getSaldo() - v);
            } else {
                System.out.println("ERRO! Saldo insuficiente!");
            }
        } else {
            System.out.println("ERRO! Voce nao tem conta!");
        }
    }
    public void pagarMensal() {
        float v;
        if (Objects.equals(tipo, "CC")) {
            v = 12;
            if (this.getStatus()) {
                if (this.getSaldo() > v) {
                    this.setSaldo(this.getSaldo() - v);
                }
            }
        } else if (Objects.equals(tipo, "CP")) {
            v = 20;
            if (this.getStatus()) {
                if (this.getSaldo() > v) {
                    this.setSaldo(this.getSaldo() - v);
                }
            }
        } else {
            System.out.println("ERRO! Saldo insuficiente!");
        }
    }
    // metodos especiais
    public ContaBanco(float saldo, boolean status) {
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

