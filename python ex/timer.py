import time

timer = int(input("Inserisci il tempo in secondi: "))

s, m, o = 0, 0, 0

for i in range(timer):
    s += 1
    
    if s == 60:
        s -= 60
        m += 1
        
    if m == 60:
        m -= 60
        o += 1
    
    time.sleep(1)
    
    print(f"{o:02}:{m:02}:{s:02}")
    print("Tempo scaduto!")