def checker(str1):
    file_data=""
    with open('input.txt','rt') as f:
        for line in f:
            file_data = file_data + line
            
    a = file_data.split('.')
    print 'Original File: ', a
    b = str1.split('.')
    print 'Input Text ', b
    
    for i in range(len(a)-1):
    	a[i]=str(a[i]).strip()

    for i in range(len(b)-1):
    	b[i]=str(b[i]).strip()

     
    count = 0
    for i in a:
    	print('\n')
    	print(i)
    	print('Compared With: ')
        for j in range(0,len(b)-1):
        	print(b[j])
        	if i==b[j]:
		        count=count+1
		
                 
    print "Total count matched = ",count
    print "Original length: ", len(a)-1
    percentage = (float(count)/(len(a)-1))*100.0                
    return percentage

