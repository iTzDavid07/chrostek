public class Impiegato extends Lavoratore {
    public Impiegato(String nome, String cognome) {
        super(nome, cognome);
    }

    public int stipendio(int giorni) {
        return super.stipendio(giorni) + 10 * giorni;
    }
}
