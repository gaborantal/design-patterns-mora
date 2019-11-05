package builder.after;

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

    public static BurgerBuilder builder() {
        return new BurgerBuilder();
    }

    public static final class BurgerBuilder {
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

        public BurgerBuilder huspogacsa(HusTipus tipus) {
            this.huspogacsa = tipus;
            return this;
        }

        public BurgerBuilder huspogacsa(String tipus) {
            return huspogacsa(HusTipus.valueOf(tipus));
        }

        public BurgerBuilder setHusokSzama(int husokSzama) {
            if (husokSzama <= 0) {
                this.husokSzama = 0;
            }
            return this;
        }

        public BurgerBuilder setSajtszeletekSzama(int sajtokSzama) {
            if (sajtokSzama >= 0) {
                this.sajtSzeletek = sajtokSzama;
            }
            return this;
        }

        public BurgerBuilder setParadicsom(boolean paradicsom) {
            this.paradicsom = paradicsom;
            return this;
        }

        public BurgerBuilder setHagyma(boolean hagyma) {
            this.hagyma = hagyma;
            return this;
        }

        public BurgerBuilder setSalata(boolean salata) {
            this.salata = salata;
            return this;
        }

        public BurgerBuilder salata() {
            this.salata = salata;
            return this;
        }

        public BurgerBuilder setUborka(boolean uborka) {
            this.uborka = uborka;
            return this;
        }

        public BurgerBuilder setKetchup(boolean ketchup) {
            this.ketchup = ketchup;
            return this;
        }

        public BurgerBuilder setMustar(boolean mustar) {
            this.mustar = mustar;
            return this;
        }

        public BurgerBuilder setMajonez(boolean majonez) {
            this.majonez = majonez;
            return this;
        }

        public BurgerBuilder csipos() {
            this.csipos = true;
            return this;
        }

        public BurgerBuilder bbq() {
            this.bbq = true;
            return this;
        }

        public Burger build() {
            return new Burger(huspogacsa, husokSzama, sajtSzeletek, paradicsom, hagyma, salata, uborka, ketchup, mustar, majonez, csipos, bbq);
        }
    }


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

    public final class MenuBuiler {
        HusTipus burgerHuspogacsa;
        int burgerHusokSzama;
        int burgerSajtSzeletek;
        boolean burgerParadicsom;
        boolean burgerHagyma;
        boolean burgerSalata;
        boolean burgerUborka;
        boolean burgerKetchup;
        boolean burgerMustar;
        boolean burgerMajonez;
        boolean burgerCsipos;
        boolean burgerBbq;

        KrumpliTipus krumpli;
        UditoTipus udito;
        SzoszTipus szosz;
        boolean fagyi;
    }
}


public class MainBuilder {
    public static void main(String[] args) {
        Burger sajtburger = Burger.builder().huspogacsa("MARHA").salata().setSajtszeletekSzama(3).csipos().setKetchup(true).setHusokSzama(2).build();
        Burger sajtburger2 = Burger.builder().huspogacsa("CSIRKE").salata().csipos().build();
    }
}
