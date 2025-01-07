temp = float(input("Inserire la temperatura: "))
from_temp = input("Da Celsius (C) o Kelvin (K) o Fahrenheit (F): ").upper()
to_temp = input("A Celsius (C) o Kelvin (K) o Fahrenheit (F): ").upper()

if from_temp == "C" and to_temp == "K":
    temp_elaborata = temp + 273.15
    result = f"{temp} C = {temp_elaborata} K"
elif from_temp == "C" and to_temp == "F":
    temp_elaborata = (temp * 9/5) + 32
    result = f"{temp} C = {temp_elaborata} F"
elif from_temp == "K" and to_temp == "C":
    temp_elaborata = temp - 273.15
    result = f"{temp} K = {temp_elaborata} C"
elif from_temp == "K" and to_temp == "F":
    temp_elaborata = ((temp - 273.15) * 9/5) + 32
    result = f"{temp} K = {temp_elaborata} F"
elif from_temp == "F" and to_temp == "C":
    temp_elaborata = (temp - 32) * 5/9
    result = f"{temp} F = {temp_elaborata} K"
elif from_temp == "F" and to_temp == "K":
    temp_elaborata = ((temp - 32) * 5/9) + 273.15
    result = f"{temp} F = {temp_elaborata} K"
else:
    result = "ERRORE, riprovare"

print(result)