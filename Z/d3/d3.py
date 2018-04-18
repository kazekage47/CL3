import random
import hashlib

def isprime(num):
	if(num==1):
		return False
	elif(num==2):
		return True
	else:
		for x in range(2,num):
			if(num%x==0):
				return False
		return True
	
def check_tuple_compat(p,q):
	if(not isprime(p)):
		print("P not Prime")
		return False
		
	if(not isprime(q)):
		print("Q not prime")
		return False
		
	if((p-1)%q!=0):
		print("Not a prime divisor")
		return False
	
	return True

while True:
	print("Enter Parameter tuple<p,q>: ")
	p=input('p: ')
	q=input('q: ')
	
	if not(check_tuple_compat(p,q)):
		print("Not a prime divisor")
	else:
		break

msg=raw_input("Enter the message: ")
m=hashlib.sha1()
m.update(msg)
print(m.hexdigest())
H=int(str(m.hexdigest()),16)
h=random.randint(1,p-1)
print 'h: ', h
g=pow(h,(p-1)/q)%p
print "g: ",g

while True:
	x=input("Enter value of x (1<x<q):")
	if x<1 or x>q:
		print 'Invalid x!.... Try again'
	else:
		break
y=pow(g,x)%p
print 'Public key: ',[p,q,g,y]
print 'Private key: ',[p,q,g,x]
#-----------------------------------------------------------------------
#generating signature with private key
k=random.randint(1,q)
r=(pow(g,k)%p)%q

temp=float(1)/k
temp=temp%q
s=temp*(H+r*x)
print("Digital siganture produced: {r,s}: ",[r,s])

#-----------------------------------------------------------------------
#verifying signature with public key
temp=1/s
w=temp%q
u1=(H*w)%q
u2=(r*w)%q
v=((pow(g,u1)*pow(y,u2))%p)%q

if(v==r):
	print("Verification Successful")
else:
	print("Verification Failed")

























	
	
	
	
	
	
	
	
	
	
	
	
		
		
