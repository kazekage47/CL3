#a1
import unittest

def binarySearch(a,key,size):
	low=0
	high = size-1
	mid = int(size/2)
	
	while low<=high:
		if a[mid] == key:
			print "Found at: ",mid+1
			return 1
		elif a[mid] > key:
			high = mid-1
		else:
			low = mid+1
		mid = int((low+high)/2)
		
	print "Not Found"
	return 0

class MyTest(unittest.TestCase):
	def test_positive(self):
		self.assertEqual(binarySearch([1,2,3,4,5,6],4,6),1)
	def test_negative(self):
		self.assertEqual(binarySearch([1,2,3,4,5,6],7,6),0)

a=[]
size = int(input("Size of array: "))
for i in range(size):
	a.append(int(input("Enter element: ")))
	
print "Input array: ",a
a.sort()
print "Sorted array: ",a
key = int(input("Enter key: "))
result = binarySearch(a,key,size)
unittest.main()
