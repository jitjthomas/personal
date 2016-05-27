import com.ipl.academy.*

def dep = new Department(code:'MECH', name:'Mechanical Engineering')

dep.save(flush:true)

println dep.id

dep.addToProfessors(new Professor(firstName:'Peter', lastName:'Cook', email:'pcook@yahoo.com'))

dep.save(flush:true)

dep.professors.each { println it }

Professor.list().each {println "--$it"}