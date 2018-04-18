import webapp2
import os
from google.appengine.ext.webapp import template
from google.appengine.ext import db

class Employee(db.Model):
    first_name = db.StringProperty()
 
class MainPage(webapp2.RequestHandler):
    def get(self):
        employee_query = Employee.all()
        employees = employee_query.fetch(10)
        template_values = {'employees':employees}
        path = os.path.join(os.path.dirname(__file__),'index.html')
        self.response.out.write(template.render(path, template_values))


class AddEmployee(webapp2.RequestHandler):
    def post(self):
        employee = Employee()
        employee.first_name = self.request.get('first_name')
        employee.put()
        self.redirect('/')
#         
app = webapp2.WSGIApplication([
('/',MainPage),
('/add',AddEmployee)
], debug=True)

if __name__=='__main__':
    app.run()