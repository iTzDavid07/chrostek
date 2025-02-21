import os

def xor(a, b):
    return bytes([x^y for x,y in zip(a,b)])

a = "d905e69ab6df68355136f501bf08f6b107aae602c38650"
b = "b32e7469efaa4a23316609b078f1af1f9df1cff4c1bb54"
c = "0c47f394221a527a1523a3c2af9c37cff4324e976c4e79"
d = "8c3a5c55d09cb5c7c2fd666400ccd23d8425ee05ceb7f5"
e = "e611cea689e997d1a2ad9ad5c7358b931e7ec7f3cc8af1"
f = "5978495b44598f8886e830a71058134377bd4690617fdc"

flag = b"flag{REDACTED}"
flaglen = len(flag)

k1 = os.urandom(flaglen)
k2 = os.urandom(flaglen)
k3 = os.urandom(flaglen)

"""
print(xor(flag, k1).hex())
print(xor(flag, k2).hex())
print(xor(xor(flag, k1), k2).hex())
print(xor(xor(flag, k1), k3).hex())
print(xor(xor(flag, k2), k3).hex())
print(xor(xor(xor(flag, k1), k2), k3).hex())"""

res = ""

for i in range((256*23)):
    print(xor(bytes.fromhex(a), i.to_bytes()).hex())