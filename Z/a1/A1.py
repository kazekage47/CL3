import unittest
def binary_search(arr,size,key):
	low = 0
	print "Array : ",arr," to be searched for: ",key
	high = size - 1
	mid = int((low+high) / 2)
	while low <= high:
		temp=0
		if key == int(arr[mid]):
			print "Found ",key," at position: ",mid+1,"\n"
			return mid+1
			temp=1
			break
		elif key > int(arr[mid]):
			low = mid + 1
			mid = int((low + high) / 2 )
		else:
			high = mid - 1
			mid = int((low + high) / 2 )
	if temp==0:
		print"Not found \n"
		return 0

class MyTest(unittest.TestCase):
	def test_positive(self):
		self.assertEqual(binary_search([10,20,30,40,50],5,40),4)
	def test_negative(self):
		self.assertEqual(binary_search([10,20,30,40,50],5,4),0)

arr=[]
size=int(input("How many elements you want to enter :"))
for i in range(0, size):
	print "Enter element"
	arr.append(raw_input())
print "Input array"
print (arr )
print "\n-----------------\nTesting...\n-----------------\n"
arr.sort()
print "Sorted array is "
print (arr)
key=int(input("Enter the element to be searched: "))
position=binary_search(arr, size, key)
unittest.main()
