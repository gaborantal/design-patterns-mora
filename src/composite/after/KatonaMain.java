package composite.after;


interface KatonaiEgyseg {
    int getTamadas();

    int getVedekezes();
}


class Katona implements KatonaiEgyseg {
    String nev;
    int tamadas;
    int vedekezes;

    public Katona(String nev, int tamadas, int vedekezes) {
        this.nev = nev;
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
    }

    public int getTamadas() {
        return tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }
}

class OsszetettKatonaiEgyseg implements KatonaiEgyseg {
    String egysegNev;
    int letszam;
    KatonaiEgyseg[] csapat;
    private int hanyKatonaVan = 0;

    public OsszetettKatonaiEgyseg(String egysegNev, int letszam) {
        this.egysegNev = egysegNev;
        this.letszam = letszam;
        this.csapat = new KatonaiEgyseg[letszam];
    }

    public int getTamadas() {
        int tamadas = 0;
        for (KatonaiEgyseg ke : csapat) {
            tamadas += ke.getTamadas();
        }
        return tamadas;
    }

    public int getVedekezes() {
        int vedekezes = 0;
        for (KatonaiEgyseg ke : csapat) {
            vedekezes += ke.getVedekezes();
        }
        return vedekezes;
    }

    public void ujAlegyseg(KatonaiEgyseg egyseg) {
        if (hanyKatonaVan < csapat.length) {
            csapat[hanyKatonaVan++] = egyseg;
        }
    }
}


public class KatonaMain {
    public static void main(String[] args) {
        Katona elso = new Katona("Első Elemér", 10, 10);
        Katona masodik = new Katona("Második Máté", 5, 6);

        OsszetettKatonaiEgyseg tuzpar = new OsszetettKatonaiEgyseg("tűzpár", 2);
        OsszetettKatonaiEgyseg raj = new OsszetettKatonaiEgyseg("raj", 4);
        OsszetettKatonaiEgyseg szakasz = new OsszetettKatonaiEgyseg("szakasz", 4);
        OsszetettKatonaiEgyseg szazad = new OsszetettKatonaiEgyseg("század", 4);

        tuzpar.ujAlegyseg(elso);
        tuzpar.ujAlegyseg(masodik);
        raj.ujAlegyseg(tuzpar);
        raj.ujAlegyseg(tuzpar);
        raj.ujAlegyseg(tuzpar);
        raj.ujAlegyseg(tuzpar);

        szakasz.ujAlegyseg(raj);
        szakasz.ujAlegyseg(raj);
        szakasz.ujAlegyseg(raj);
        szakasz.ujAlegyseg(raj);

        szazad.ujAlegyseg(szakasz);
        szazad.ujAlegyseg(szakasz);
        szazad.ujAlegyseg(szakasz);
        szazad.ujAlegyseg(szakasz);
        szazad.ujAlegyseg(szakasz);

        System.out.println("A század támadóereje: " + szazad.getTamadas());
    }
}
