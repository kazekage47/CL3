from plag import *
from flask import Flask , request, render_template

app = Flask(__name__)

@app.route('/')
def fun():
    return render_template('index.html',msg=None)
    
@app.route('/eval',methods=['POST','GET'])
def check():
    a = checker(request.form['string'])
    return render_template('index.html',msg=a)

if __name__=="__main__":
    app.run()
