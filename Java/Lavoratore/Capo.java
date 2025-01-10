public class Capo extends Lavoratore {
    public Capo(String nome, String cognome) {
        super(nome, cognome);
    }

    public int stipendio(int giorni) {
        return super.stipendio(giorni) + 1000 * giorni;
    }
}
