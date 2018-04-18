#b2
def checkerLine(str1):
	print "-----SENTENCE-----"
	db_data = ""
	with open("db.txt",'rt') as f:
		db_data = f.read()
		
	a = db_data.split('.')
	for i in range(len(a)-1):
		a[i] = a[i].strip().lower()
	b = str1.split('.')
	for i in range(len(b)-1):
		b[i] = b[i].strip().lower()
		
	match_count = 0
	for i in range(len(b)-1):
		for j in range(len(a)-1):
			if b[i] == a[j]:
				print "A: ",a[j]," B: ",b[i]
				match_count+=1
				
	print "Match Count: ",match_count
	perc = (float(match_count)/(len(b)-1))*100.0
	if float(perc)>100.0: perc=100.0
	print "Percentage: ", perc
	return match_count,perc

def checkerWord(str1):
	print "-----WORD-----"
	db_data=""
	with open("db.txt",'rt') as f:
		db_data = f.read()
		
	a = db_data.split()
	for i in range(len(a)):
		a[i] = a[i].strip(' .').lower()
	b = str1.split()
	for i in range(len(b)):
		b[i] = b[i].strip(' .').lower()
		
	match_count = 0
	for i in range(len(b)):
		for j in range(len(a)):
			if b[i] == a[j]:
				print "A: ",a[j]," B: ",b[i]
				match_count+=1
				
	print "Match Count: ",match_count
	perc = (float(match_count)/len(b))*100.0
	if float(perc)>100.0: perc=100.0
	print "Percentage: ", perc
	return match_count,perc
	
#checkerLine("hello dropbox. Arnav Shrivastava.")
#checkerWord("hello dropbox. Arnav Shrivastava. Anjali Jain. Akshay. Ashish.")
