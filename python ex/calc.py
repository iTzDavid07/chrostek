operation = input("Inserire l'operazione da eseguire (+ - * /): ")
a = float(input("Inserire il primo numero: "))
b = float(input("Inserire il secondo numero: "))

if operation == "+":
    result = a + b
elif operation == "-":
    result = a - b
elif operation == "*":
    result = a * b
elif operation == "/":
    result = a / b
else:
    result = "ERRORE, riprovare"

print("Il risultato dell'operazione e'", result)