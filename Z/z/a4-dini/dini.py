#a4
import threading
import random
import time
from pymongo import MongoClient

class Philosopher(threading.Thread):
	running = True
	connection = MongoClient("localhost",27017)
	printcounter = 0
	
	@staticmethod
	def readFromMongo(self,index):
		print "Reading raw data: "
		db = Philosopher.connection.test.diniraw
		limit = printcounter
		cursor = db.find({"ph_no":index})[limit:limit+1]
		print cursor[0]
		self.printcounter+=1
		self.printcounter%=9
	
	def __init__(self,i,xname,forkOnLeft,forkOnRight):
		threading.Thread.__init__(self)
		self.index = i
		self.name = xname
		self.forkOnLeft = forkOnLeft
		self.forkOnRight = forkOnRight
		
	def run(self):
		while self.running:
			time.sleep(random.uniform(3,13))
			print self.name," is hungary"
			self.dine()
	
	def dine(self):
		fork1, fork2 = self.forkOnLeft, self.forkOnRight
		while self.running:
			fork1.acquire(True)
			locked = fork2.acquire(False)
			if locked: break
			fork1.release()
			print self.name, " swaps fork"
			fork1, fork2 = fork2, fork1
		else:
			return
			
		self.dining()
		fork1.release()
		fork2.release()
	
	def dining(self):
		print self.name, " starts eating"
		self.readFromMongo(self,self.index)
		time.sleep(random.uniform(1,10))
		print self.name," finished eating and is now thinking"
		
def DiniPhilo():
	forks = [threading.Lock() for n in range(5)]
	pnames = ['A','B','C','D','E']
	philo = [Philosopher(i,pnames[i],forks[i%5],forks[(i+1)%5]) for i in range(5)]
	
	random.seed(5627)
	Philosopher.running = True
	for p in philo: p.start()
	time.sleep(50)
	Philosopher.running = False
	print "Finishing"
	
DiniPhilo()
