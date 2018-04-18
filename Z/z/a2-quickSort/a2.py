#a2
import threading
import xml.etree.ElementTree as X

def part(a,low,high):
	pIndex = low
	pivot = a[high]
	
	for i in range(low,high):
		if a[i]<pivot:
			a[i], a[pIndex] = a[pIndex], a[i]
			pIndex+=1
		
	a[pIndex], a[high] = a[high], a[pIndex]
	return pIndex

def quickSort(a,low,high):
	if low<high:
		p = part(a,low,high)
		t1 = threading.Thread(target=quickSort,args=(a,low,p-1))
		t2 = threading.Thread(target=quickSort,args=(a,p+1,high))
		t1.start()
		t2.start()
		t1.join()
		print t1.getName()
		t2.join()
		print t2.getName()

r = X.parse("input.xml").getroot()
a = map(int,r.text.split())
print "Input array: ",a
quickSort(a,0,len(a)-1)
print "Sorted array: ",a
