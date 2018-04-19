import os
import unittest
def read(filename):
	a=open(filename,'r')
	inx=[]
	for inp in a:
		inx.append(int(inp))
	return (inx)

def sort(inp):
	inp.sort()
	return inp

def search(key,lst,first,last):
	if(first<=last):	
		mid=(last+first)/2
		if(key==lst[mid]):
			return mid
		elif(key<lst[mid]):
			return search(key,lst,first,mid-1)
		elif(key>lst[mid]):
			return search(key,lst,mid+1,last)
		
class Test(unittest.TestCase):
	def test_postive(self):
		self.assertEqual(search(1,[0,1,2,3,4,5],0,5),1)
	def test_negative(self):
		self.assertEqual(search(10,[0,1,2,3,4,5],0,5),None)
	
some=read("input.txt")
print "Input Array is:",some
srt=sort(some)
print "Sorted Array is:",srt
x=input("\nEnter the key to be searched\t")
ind=search(x,srt,0,len(srt)-1)
print("Value found at index :",ind)
print("Unit testing :")
unittest.main()
