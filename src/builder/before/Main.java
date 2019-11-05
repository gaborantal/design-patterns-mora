package builder.before;

enum HusTipus {CSIRKE, MARHA, GRILLEZETT_CSIRKE}
enum KrumpliTipus {SIMA, STEAK}
enum UditoTipus {COLA, COLA_ZERO, NARANCS, NARANCS_ZERO, TONIK, TONIK_ZERO, TEA_CITROM}
enum SzoszTipus {CSILI, KETCHUP, MUSTAR, MAJONEZ, EDES_SAVANYU}

class Burger {
    HusTipus huspogacsa;
    int husokSzama;
    int sajtSzeletek;
    boolean paradicsom;
    boolean hagyma;
    boolean salata;
    boolean uborka;
    boolean ketchup;
    boolean mustar;
    boolean majonez;
    boolean csipos;
    boolean bbq;

    public Burger(HusTipus huspogacsa, int husokSzama, int sajtSzeletek, boolean paradicsom, boolean hagyma, boolean salata, boolean uborka, boolean ketchup, boolean mustar, boolean majonez, boolean csipos, boolean bbq) {
        this.huspogacsa = huspogacsa;
        this.husokSzama = husokSzama;
        this.sajtSzeletek = sajtSzeletek;
        this.paradicsom = paradicsom;
        this.hagyma = hagyma;
        this.salata = salata;
        this.uborka = uborka;
        this.ketchup = ketchup;
        this.mustar = mustar;
        this.majonez = majonez;
        this.csipos = csipos;
        this.bbq = bbq;
    }
    // ...
}

class Menu {
    Burger burger;
    KrumpliTipus krumpli;
    UditoTipus udito;
    SzoszTipus szosz;
    boolean fagyi;

    public Menu(Burger burger, KrumpliTipus krumpli, UditoTipus udito, SzoszTipus szosz, boolean fagyi) {
        this.burger = burger;
        this.krumpli = krumpli;
        this.udito = udito;
        this.szosz = szosz;
        this.fagyi = fagyi;
    }

    public Menu(HusTipus huspogacsa, int husokSzama, int sajtSzeletek, boolean paradicsom, boolean hagyma, boolean salata, boolean uborka, boolean ketchup, boolean mustar, boolean majonez, boolean csipos, boolean bbq, KrumpliTipus krumpli, UditoTipus udito, SzoszTipus szosz, boolean fagyi) {
        this.burger = new Burger(huspogacsa, husokSzama, sajtSzeletek, paradicsom, hagyma, salata, uborka, ketchup, mustar, majonez, csipos, bbq);
        this.krumpli = krumpli;
        this.udito = udito;
        this.szosz = szosz;
        this.fagyi = fagyi;
    }

}


public class Main {

    public static void main(String[] args) {
        Burger sajtburger = new Burger(HusTipus.MARHA, 1, 1, true, true, true, true, true, true, false, false, false);
        Menu sajtBurgerMenu = new Menu(sajtburger, KrumpliTipus.SIMA, UditoTipus.COLA_ZERO, SzoszTipus.CSILI, false);
        Menu sajtBurgerMenu2 = new Menu(HusTipus.MARHA, 1, 1, true, true, true, true, true, true, false, false, false, KrumpliTipus.SIMA, UditoTipus.COLA_ZERO, SzoszTipus.CSILI, false);
    }
}
