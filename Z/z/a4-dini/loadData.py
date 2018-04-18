#a4-load data
from pymongo import MongoClient
from datetime import datetime

def readFromFile(fname):
	connection = MongoClient("localhost",27017)
	db = connection.test.diniraw
	fd = open(fname,'r').read().strip().split('\n')
	for line in fd:
		record = line.strip().split(',')
		print record
		record = [int(e) for e in record]
		post = {"ph_no":record[0],"time":str(datetime.now()),"temp":record[1]}
		db.insert_one(post)
		
readFromFile("input.txt")
