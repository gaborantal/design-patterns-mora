package composite.before;

class Katona {
    String nev;
    int tamadas;
    int vedekezes;

    public Katona(String nev, int tamadas, int vedekezes) {
        this.nev = nev;
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
    }
}

class Tuzpar {
    Katona[] csapat = new Katona[2];

    public Tuzpar(Katona e, Katona m) {
        this.csapat[0] = e;
        this.csapat[1] = m;
    }

}

class Raj {
    Tuzpar[] csapat = new Tuzpar[4];
}

class Szakasz {
    Raj[] csapat = new Raj[4];
}

class Szazad {
    Szakasz[] csapat = new Szakasz[4];
}
// ...

public class KatonaMain {
    public static void main(String[] args) {
        // Létrehozunk két katonát
        Katona elso = new Katona("Első Elemér", 10, 10);
        Katona masodik = new Katona("Második Máté", 5, 6);
        // Csinálunk egy tűzpárt belőlük
        Tuzpar elsoTuzpar = new Tuzpar(elso, masodik);
        // Létrehozunk egy rajt, amiben az összes tűzpárt beállítjuk
        Raj elsoRaj = new Raj();
        elsoRaj.csapat[0] = elsoTuzpar;
        elsoRaj.csapat[1] = elsoTuzpar;
        elsoRaj.csapat[2] = elsoTuzpar;
        elsoRaj.csapat[3] = elsoTuzpar;
        // A rajokból formálunk egy szakaszt
        Szakasz legjobbak = new Szakasz();
        legjobbak.csapat[0] = elsoRaj;
        legjobbak.csapat[1] = elsoRaj;
        legjobbak.csapat[2] = elsoRaj;
        legjobbak.csapat[3] = elsoRaj;
        // És végül egy századot
        Szazad szazadom = new Szazad();
        szazadom.csapat[0] = legjobbak;
        szazadom.csapat[1] = legjobbak;
        szazadom.csapat[2] = legjobbak;
        szazadom.csapat[3] = legjobbak;
        // Mennyi az összes támadóerejük?
        int osszTamadas = 0;
        for (int i=0; i<szazadom.csapat.length; i++){
            for (int j=0; j<szazadom.csapat[i].csapat.length; j++){
                for (int k=0; k<szazadom.csapat[i].csapat[j].csapat.length; k++){
                    for (int l=0; l<szazadom.csapat[i].csapat[j].csapat[k].csapat.length; l++){
                        osszTamadas += szazadom.csapat[i].csapat[j].csapat[k].csapat[l].tamadas;
                    }
                }
            }
        }
        System.out.println("A század támadóképessége: " + osszTamadas);
    }
}
