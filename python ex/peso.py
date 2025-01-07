KGSLBS = 2.205

peso = float(input("Inserire il peso: "))
type = input("lbs o kgs: ")

if type == "lbs":
    peso_elaborato = peso / KGSLBS
    result = f"{peso} lbs = {peso_elaborato} kgs"
elif type == "kgs":
    peso_elaborato = peso * KGSLBS
    result = f"{peso} kgs = {peso_elaborato} lbs"
else:
    result = "ERRORE, riprovare"

print(result)