#a3
def decimalToBinary(x):
	a = [0] * 8
	i=7
	while x and i>=0:
		a[i] = x%2
		x = x/2
		i -= 1
	return a
	
def add(x,y):
	d = [0] * 17
	c = 0
	i = 16
	while i>=0:
		temp = x[i] + y[i] + c
		d[i] = temp%2
		c = temp/2
		i-=1		
	return d
	
def sub(x,y):
	d = [0] * 16
	c = 0
	i = 15
	while i>=1:
		temp = x[i] - y[i] - c
		d[i] = temp%2
		c = abs(temp/2)
		i-=1
	return d

def rightShift(x):
	i = 16
	while i>=1:
		x[i] = x[i-1]
		i-=1
	return x
	
def binaryToDecimal(x):
	if x[0] == 1:
		one = [0] * 15 + [1]
		x = sub(x,one)
		for i in range(len(x)):
			x[i] = 1 - x[i]
			
	i = 15
	p = 0
	ans = 0
	while i>=1:
		if x[i] == 1:
			ans += 2**p
		p+=1
		i-=1
			
	if x[0]:
		print -ans 
		return -ans
	print ans
	return ans

def MyBooths(num1,num2):
	print "Input: "
	a = decimalToBinary(num1)
	print a
	b = decimalToBinary(num2)
	print b
	a_neg = decimalToBinary(-num1)
	
	p = [0] * 8
	p.extend(b)
	p.append(0)
	
	a += [0] * 9
	a_neg += [0] * 9
	
	for i in range(8):
		if p[-2] == 1 and p[-1] == 0:
			p = add(p,a_neg)
			print "A-M: ",p
		elif p[-2] == 0 and p[-1] == 1:
			p = add(p,a)
			print "A+M: ",p
		p = rightShift(p)
		print "Right Shift: ",p
		
	p = p[:-1]
	print p
	return binaryToDecimal(p)
