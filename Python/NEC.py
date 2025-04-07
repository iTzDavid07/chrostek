import matplotlib.pyplot as plt
import numpy as np

# Funzione per generare il segnale del protocollo NEC
def nec_signal(data):
    signal = []

    # Start pulse (9ms high)
    signal.append((0, 9000))  # Start high pulse for 9ms
    signal.append((1, 4500))  # Start low space for 4.5ms

    # Aggiungi la sequenza di bit
    for bit in data:
        if bit == 0:
            signal.append((0, 560))  # Bit 0: 560us high
            signal.append((1, 560))  # Bit 0: 560us low
        elif bit == 1:
            signal.append((0, 560))  # Bit 1: 560us high
            signal.append((1, 1690)) # Bit 1: 1690us low

    # Converti il segnale in due array per la visualizzazione (tempo e stato)
    time = []
    state = []

    current_time = 0
    for s, duration in signal:
        time.append(current_time)
        state.append(s)
        current_time += duration

    return np.array(time), np.array(state)

# Dati di esempio (ad esempio un comando per il telecomando, codifica 16 bit)
data = [1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0]  # 32 bit di esempio

# Ottieni il segnale NEC
time, state = nec_signal(data)

# Creazione del grafico
plt.figure(figsize=(10, 4))
plt.step(time, state, where='post', color='blue')

# Aggiungi etichette e titolo
plt.title('Protocollo NEC per Ricevitore IR')
plt.xlabel('Tempo (microsecondi)')
plt.ylabel('Stato (0 = Low, 1 = High)')
plt.grid(True)
plt.ylim(-0.1, 1.1)  # Limita l'asse Y per miglior visibilità
plt.show()
