class Gettoniera:
    saldo = 0

    def inserisci_soldi(self):
        self.saldo += int(input("Inserire un soldi: "))

    def dai_resto(self):
        resto = self.saldo
        saldo = 0
        print(f"Resto ricevuto: {resto}")

    def get_saldo(self):
        return self.saldo

    def rimnuovi_soldi(self, soldi):
        self.saldo -= soldi

class Display:
    prodotti = [
        {"nome": "Acqua", "prezzo": 1},
        {"nome": "Patatine", "prezzo": 3},
        {"nome": "Cibo", "prezzo": 7}
    ]

    def visualizza_prodotti(self):
        print("Lista dei prodotti")
        i = 0
        for prodotto in self.prodotti:
            print(f" - {i} - {prodotto.get('nome')} prezzo: {prodotto.get('prezzo')}€")
            i += 1

    def get_prodotto(self, n_prodotto):
        return self.prodotti[n_prodotto]

    def scegli_prodotto(self):
        n_prodotto = int(input("Inserisci il numero del prodotto: "))

        if not self.get_prodotto(n_prodotto):
            print("Prodotto non esistente")
            return

        return self.get_prodotto(n_prodotto)


class Erogatore:
    def compra_prodotto(self, prodotto):
        print(f"{prodotto.get('nome')} e' stato erogato")

class Distributore:
    def __init__(self):
        self.gettoniera = Gettoniera()
        self.display = Display()
        self.erogatore = Erogatore()

    def inserisci_soldi(self):
        self.gettoniera.inserisci_soldi()

    def visualizza_prodotti(self):
        self.display.visualizza_prodotti()

    def compra_prodotto(self):
        prodotto = self.display.scegli_prodotto()
        if not prodotto:
            return

        if prodotto.get('prezzo') > self.gettoniera.get_saldo():
            print("Saldo insufficiente")
            return

        self.gettoniera.rimnuovi_soldi(prodotto.get('prezzo'))
        self.erogatore.compra_prodotto(prodotto)
        self.gettoniera.dai_resto()

dist = Distributore()

dist.inserisci_soldi()
dist.visualizza_prodotti()
dist.compra_prodotto()