import threading
import xml.etree.ElementTree as X

def partition(arr,low,high):
	pIndex=low
	pivot=arr[high]
	
	for i in range(low,high):
		if(arr[i]<pivot):
			arr[i],arr[pIndex]=arr[pIndex],arr[i]
			pIndex+=1
		
	arr[pIndex],arr[high]=arr[high],arr[pIndex]
	return pIndex
	
def quickSort(arr,low,high):
	if(low<high):
		
		p=partition(arr,low,high)
		
		t1=threading.Thread(target=quickSort,args=(arr,low,p-1))
		t2=threading.Thread(target=quickSort,args=(arr,p+1,high))
		t1.start()
		t2.start()
		t1.join()
		print(t1.getName())
		t2.join()
		print(t2.getName())
		

r=X.parse('input.xml').getroot()
arr=map(int,r.text.split())			#r.text
print(arr)
quickSort(arr,0,len(arr)-1)
print(arr)	
		
