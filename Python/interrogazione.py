class Gettoniera:
    def __init__(self):
        self.saldo = 0

    def inserisci_soldi(self):
        self.saldo += int(input("Inserire i soldi: "))

    def dai_resto(self):
        print(f"Resto dato: {self.saldo}")
        self.saldo = 0

    def get_saldo(self):
        return self.saldo

    def rimuovi_saldo(self, soldi):
        self.saldo -= soldi

class Display:
    def inserisci_prodotto(self, catalogo):
        nome_prodotto = input("Inserisci il nome del prodotto da aggiungere: ")
        prezzo_prodotto = int(input("Inserisci il prezzo del prodotto da aggiungere: "))
        q_prodotto = int(input("Inserisci la quantita' del prodotto da aggiungere: "))

        catalogo.append({
            'nome': nome_prodotto,
            'prezzo': prezzo_prodotto,
            'q': q_prodotto
        })

        print("Prodotto aggiunto al catalogo")

    def visualizza_prodotti(self, catalogo):
        print("Catalogo dei prodotti:")
        i = 0
        for prodotto in catalogo:
            print(f" - {i} - {prodotto['nome']} prezzo: {prodotto['prezzo']}€ quantita': {prodotto['q']}")
            i += 1

    def scegli_prodotto(self, catalogo):
        n_prodotto = int(input("Inserisci il numero del prodotto: "))

        if not n_prodotto < len(catalogo):
            print("Prodotto non esistente")
            return

        return catalogo[n_prodotto]

class Erogatore:
    def eroga_prodotto(self, catalogo, prodotto):
        self.rimuovi_prodotto(catalogo, prodotto)
        print(f"{prodotto['nome']} e' stato erogato")
    
    def rimuovi_prodotto(self, catalogo, prodotto):
        if prodotto['q'] > 1:
            index_prodotto = catalogo.index(prodotto)
            catalogo[index_prodotto]['q'] -= 1
        else:
            catalogo.remove(prodotto)

class Distributore:
    def __init__(self):
        self.gettoniera = Gettoniera()
        self.display = Display()
        self.erogatore = Erogatore()
        self.catalogo = []

    def inserisci_prodotto(self):
        self.display.inserisci_prodotto(self.catalogo)

    def inserisci_soldi(self):
        self.gettoniera.inserisci_soldi()
    
    def visualizza_prodotti(self):
        self.display.visualizza_prodotti(self.catalogo)

    def compra_prodotto(self):
        if not (prodotto := self.display.scegli_prodotto(self.catalogo)):
            return

        if prodotto['prezzo'] > self.gettoniera.get_saldo():
            print("Saldo insufficiente")
            return

        self.erogatore.eroga_prodotto(self.catalogo, prodotto)
        self.gettoniera.rimuovi_saldo(prodotto['prezzo'])
        self.gettoniera.dai_resto()

dist = Distributore()

while True:
    print("""
          Inserisci l'operazione da eseguire:
          1. Inserisci prodotto nel distributore
          2. Inserisci soldi nel distributore
          3. Visualizza prodotti nel distributore
          4. Compra prodotto del distributore
          Altro per uscire...
          """)
    option = input("Input: ")

    if option == "1":
        dist.inserisci_prodotto()
    elif option == "2":
        dist.inserisci_soldi()
    elif option == "3":
        dist.visualizza_prodotti()
    elif option == "4":
        dist.compra_prodotto()
    else:
        break
