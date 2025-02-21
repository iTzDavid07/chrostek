public class GestoreFrasi {
    private String testo;
    public int vocali;
    public int spazi;

    // costruttore: inizializza gli attributi
    public GestoreFrasi() {
        testo = "";
        vocali = 0;
        spazi = 0;
    }

    // calcola il numero di vocali e di spazi
    public void analizza(String t) {
        char carattere;
        this.testo = t;
        testo.toLowerCase();
        for (int i = 0; i < testo.length(); i++) {
            carattere = testo.charAt(i);
            switch (carattere) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vocali++;
                    break;
                case ' ':
                    spazi++;
                    break;
            }
        }
    }

    // calcola la frequenza delle vocali
    public double getFreqVocali() {
        double freqVocali;
        freqVocali = (double) vocali / testo.length();
        return arrotonda(freqVocali);
    }

    // calcola la frequenza degli spazi
    public double getFreqSpazi() {
        double freqSpazi;
        freqSpazi = (double) spazi / testo.length();
        return arrotonda(freqSpazi);
    }

    // arrotonda a due cifre decimali
    private double arrotonda(double valore) {
        return (double) Math.round(valore * 100) / 100;
    }
}