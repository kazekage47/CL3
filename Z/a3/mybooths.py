from flask import Flask, request, render_template
from booths import *

app=Flask(__name__)

@app.route('/')
def mainpage():
	return render_template('index.html', product=None)

@app.route('/eval', methods=['POST','GET'])
def multiply():
	x=mybooth(int(request.form['num1']),int(request.form['num2']))
	p=binaryToDecimal(x[:-1])
	return render_template('index.html',product=p)
app.run()
