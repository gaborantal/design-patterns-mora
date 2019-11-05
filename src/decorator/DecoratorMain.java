package decorator;

interface Entitas {
    int mikorFazik();
}

class Ember implements Entitas {
    public int mikorFazik() {
        return 15;
    }
}

class Ruhadarab implements Entitas {
    private Entitas viselo;

    public Ruhadarab(Entitas e) {
        this.viselo = e;
    }

    public int mikorFazik() {
        return viselo.mikorFazik();
    }
}


class Polo extends Ruhadarab {
    public Polo(Entitas e) {
        super(e);
    }

    public int mikorFazik() {
        return super.mikorFazik() - 2;
    }
}

class Sapka extends Ruhadarab {
    public Sapka(Entitas e) {
        super(e);
    }

    public int mikorFazik() {
        return super.mikorFazik() - 1;
    }
}

class Nadrag extends Ruhadarab {
    public Nadrag(Entitas e) {
        super(e);
    }

    public int mikorFazik() {
        return super.mikorFazik() - 4;
    }
}
class Pulover extends Ruhadarab {
    public Pulover(Entitas e) {
        super(e);
    }

    public int mikorFazik() {
        return super.mikorFazik() - 5;
    }
}

class Cipo extends Ruhadarab {
    public Cipo(Entitas e) {
        super(e);
    }

    public int mikorFazik() {
        return super.mikorFazik() - 2;
    }
}
public class DecoratorMain {
    public static void main(String[] args) {
        Entitas e = new Polo(new Nadrag(new Ember()));
        System.out.println(e.mikorFazik()); //9
        System.out.println(new Pulover(e).mikorFazik()); //4
        System.out.println(new Cipo(new Polo(new Nadrag(new Ember()))).mikorFazik()); //7
        System.out.println(new Cipo(new Polo(new Pulover(new Ember()))).mikorFazik()); //6


        e = new Sapka(e);
    }
}
