package com.juaracoding;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ATMTest {
    private ATM atm;

    // Metode ini akan dijalankan sebelum setiap metode pengujian
    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000); // Inisialisasi saldo awal 1000
    }

    // Menguji apakah metode lihatSaldo() mengembalikan saldo yang benar
    @Test
    public void testLihatSaldo() {
        assertEquals(atm.lihatSaldo(), 1000.0, "Saldo harus 1000 setelah diinisialisasi.");
    }

    // Menguji apakah metode setorUang() berfungsi dengan benar ketika jumlah yang valid disetor
    @Test
    public void testSetorUang() {
        atm.setorUang(500);
        assertEquals(atm.lihatSaldo(), 1500.0, "Saldo harus 1500 setelah setor 500.");
    }

    // Menguji apakah metode setorUang() melempar pengecualian ketika jumlah yang negatif disetor
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0")
    public void testSetorUangNegatif() {
        atm.setorUang(-200);
    }

    // Menguji apakah metode tarikUang() berfungsi dengan benar ketika jumlah yang valid ditarik
    @Test
    public void testTarikUang() {
        atm.tarikUang(300);
        assertEquals(atm.lihatSaldo(), 700.0, "Saldo harus 700 setelah tarik 300.");
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang ditarik melebihi saldo saat ini
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Saldo tidak mencukupi")
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(1200);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang negatif ditarik
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0")
    public void testTarikUangNegatif() {
        atm.tarikUang(-100);
    }
}
