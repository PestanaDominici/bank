package com.pestana.poo;

import java.util.Objects;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco(float saldo, boolean status) {
        this.saldo = 0;
        this.status = false;
    }
    public void setNumConta(int n) {
        this.numConta = n;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setTipo(String t) {
        this.tipo = t;
    }
    public String getTipo() {
        return tipo;
    }
    public void setDono(String d) {
        this.dono = d;
    }
    public String getDono() {
        return dono;
    }
    public void setSaldo(float s) {
        this.saldo = s;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setStatus(boolean st) {
        this.status = st;
    }
    public boolean getStatus() {
        return status;
    }
    public void abrirConta(String t) {
        setTipo(t);
        setStatus(true);
        if (Objects.equals(t, "CC")) {
            this.saldo = 50;
        } else if(Objects.equals(t, "CP")) {
            this.saldo = 150;
        }
    }
    public void fecharConta() {
        if (saldo > 0) {
            System.out.println("ERRO! Conta com saldo! Retirar todo dinheiro.");
        } else if (saldo < 0) {
            System.out.println("ERRO! Você esta em debto!");
        } else {
            setStatus(false);
        }
    }
    public void depositar(float v) {
        if (getStatus()) {
            setSaldo(getSaldo() + v);
        } else {
            System.out.println("ERRO! Voce nao tem conta!");
        }
    }
    public void sacar(float v) {
        if (getStatus()) {
            if (saldo > v) {
                setSaldo(getSaldo() - v);
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
            if (status = true) {
                if (saldo > v) {
                    setSaldo(getSaldo() - v);
                }
            }
        } else if (Objects.equals(tipo, "CP")) {
            v = 20;
            if (status = true) {
                if (saldo > v) {
                    setSaldo(getSaldo() - v);
                }
            }
        } else {
            System.out.println("ERRO! Saldo insuficiente!");
        }
    }
}
