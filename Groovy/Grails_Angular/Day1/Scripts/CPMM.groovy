import com.ipl.academy.*
def d1 = new Department(code:'MECH', name:'Mechanical Engineering')
d1.save(flush:true)
        
def p1 = new Professor(firstName:'Peter', lastName:'Cook', email:'pcook@gmail.com', department:d1)
def p2 = new Professor(firstName:'Peter', lastName:'Broown', email:'pbrown@gmail.com', department:d1)
def p3 = new Professor(firstName:'Thomas', lastName:'Cook', email:'tcook@gmail.com', department:d1)
p1.save(flush:true)
p2.save(flush:true)
p3.save(flush:true)
        
def c1 = new Course(code:'FLD101', name:'Fluid Dynamics 1', department:d1)
def c2 = new Course(code:'FLD102', name:'Fluid Dynamics 2', department:d1)
def c3 = new Course(code:'SOM101', name:'Strength Of Materials 1', department:d1)
def c4 = new Course(code:'SOM102', name:'Strength Of Materials 2', department:d1)
c1.save(flush:true)
c2.save(flush:true)
c3.save(flush:true)
c4.save(flush:true)

p1.addToExpertise(new Expertise(expertise:c1))
p1.addToExpertise(new Expertise(expertise:c2))
p1.save(flush:true)
c2.addToExperts(new Expertise(expert:p2))


println "-----Courses for $p1-----"
def c = p1.expertise.collect{it.expertise}
c.each {println it}
println "-----Professors for $c2-----"
def p = c2.experts.collect {it.expert}
p.each {println it}
