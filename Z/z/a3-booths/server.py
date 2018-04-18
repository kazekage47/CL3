#a3-server
from booths import *
from flask import *

app = Flask(__name__)

@app.route('/')
def home():
	return render_template('index.html',product = 0)
	
@app.route('/eval', methods=['POST','GET'])
def eval():
	p = MyBooths(int(request.form['num1']),int(request.form['num2']))
	return render_template('index.html',product = p)
	
if __name__ == '__main__':
	app.run()
