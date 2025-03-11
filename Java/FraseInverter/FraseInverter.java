import java.util.ArrayList;

class FraseInverter {
	private ArrayList<String> Frase = new ArrayList<String>();

    public void inputFrase(String input) {
        Frase.clear();
        String[] parole = input.split(" ");
        for (String parola : parole) {
            Frase.add(parola);
        }
    }

    public String getInverted() {
        String invertito = "";
        while (!Frase.isEmpty()) {
            invertito += Frase.removeLast() + " ";
        }
        return invertito;
    }
}