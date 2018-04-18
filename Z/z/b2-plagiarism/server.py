#b2-server
from check import *
from flask import *

app = Flask(__name__)

@app.route('/')
def home():
	return render_template('index.html',res=0,sen_count=0,sen_perc=0,word_count=0,word_perc=0)
	
@app.route('/eval',methods=['POST','GET'])
def eval():
	str1 = request.form['str1']
	r = 1
	sc, sp = checkerLine(str1)
	wc, wp = checkerWord(str1)
	return render_template('index.html',res=r,sen_count=sc,sen_perc=sp,word_count=wc,word_perc=wp)
	
if __name__ == '__main__':
	app.run()
