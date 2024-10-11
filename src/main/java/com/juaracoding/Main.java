package com.juaracoding;

public class Main {
    public static void main(String[] args) {
        // Membuat objek ATM dengan saldo awal 1000
        ATM atm = new ATM(1000);

        // Melihat saldo awal
        System.out.println("Saldo saat ini: " + atm.lihatSaldo());

        // Menyetor uang
        System.out.println("Menyetor 500...");
        atm.setorUang(500);
        System.out.println("Saldo setelah setor: " + atm.lihatSaldo());

        // Menarik uang
        System.out.println("Menarik 300...");
        atm.tarikUang(300);
        System.out.println("Saldo setelah tarik: " + atm.lihatSaldo());

        // Mencoba menarik uang melebihi saldo
        try {
            System.out.println("Menarik 1200 (melebihi saldo)...");
            atm.tarikUang(1200);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mencoba setor uang negatif
        try {
            System.out.println("Menyetor -200...");
            atm.setorUang(-200);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mencoba menarik uang negatif
        try {
            System.out.println("Menarik -100...");
            atm.tarikUang(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Melihat saldo akhir
        System.out.println("Saldo akhir: " + atm.lihatSaldo());
    }
}

