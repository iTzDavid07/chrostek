public class Fattorino extends Lavoratore {
    public Fattorino(String nome, String cognome) {
        super(nome, cognome);
    }

    public int stipendio(int giorni) {
        return super.stipendio(giorni) / 2;
    }    
}
