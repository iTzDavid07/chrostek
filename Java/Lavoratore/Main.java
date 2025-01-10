public class Main {
    public static void main(String[] args) {
        Lavoratore l1 = new Lavoratore("Andrea", "Lattanzi");
        Lavoratore l2 = new Lavoratore("Gabriel", "Cardenas");

        Capo c1 = new Capo("David", "Chrostek");

        Fattorino f1 = new Fattorino("Lorenzo", "Carmenini");
        Fattorino f2 = new Fattorino("Adriano", "Ciacciarelli");
        Fattorino f3 = new Fattorino("Francesco", "Petrini");
        Fattorino f4 = new Fattorino("Leonardo", "Raimondi");

        Impiegato i1 = new Impiegato("Daniele", "Bucci");
        Impiegato i2 = new Impiegato("Mattia", "Migliori");
        Impiegato i3 = new Impiegato("Chiara", "Colaneri");
        Impiegato i4 = new Impiegato("Federico", "Siviero");
        Impiegato i5 = new Impiegato("Daniele", "Auciello");

        int giorni = 31;

        System.out.println("Stipendio di tutti i lavoratori:");
        System.out.println("Lo stipendio di " + l1.getNome() + " " + l1.getCognome() + " e' " + l1.stipendio(giorni));
        System.out.println("Lo stipendio di " + l2.getNome() + " " + l2.getCognome() + " e' " + l2.stipendio(giorni));
        System.out.println("Lo stipendio di " + c1.getNome() + " " + c1.getCognome() + " e' " + c1.stipendio(giorni));
        System.out.println("Lo stipendio di " + f1.getNome() + " " + f1.getCognome() + " e' " + f1.stipendio(giorni));
        System.out.println("Lo stipendio di " + f2.getNome() + " " + f2.getCognome() + " e' " + f2.stipendio(giorni));
        System.out.println("Lo stipendio di " + f3.getNome() + " " + f3.getCognome() + " e' " + f3.stipendio(giorni));
        System.out.println("Lo stipendio di " + f4.getNome() + " " + f4.getCognome() + " e' " + f4.stipendio(giorni));
        System.out.println("Lo stipendio di " + i1.getNome() + " " + i1.getCognome() + " e' " + i1.stipendio(giorni));
        System.out.println("Lo stipendio di " + i2.getNome() + " " + i2.getCognome() + " e' " + i2.stipendio(giorni));
        System.out.println("Lo stipendio di " + i3.getNome() + " " + i3.getCognome() + " e' " + i3.stipendio(giorni));
        System.out.println("Lo stipendio di " + i4.getNome() + " " + i4.getCognome() + " e' " + i4.stipendio(giorni));
        System.out.println("Lo stipendio di " + i5.getNome() + " " + i5.getCognome() + " e' " + i5.stipendio(giorni));
    }
}
