public class Lavoratore {
    protected String nome, cognome;
    protected int RetribuzioneGiorn = 40;

    public Lavoratore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int stipendio(int giorni) {
        return giorni * RetribuzioneGiorn;
    }
}

