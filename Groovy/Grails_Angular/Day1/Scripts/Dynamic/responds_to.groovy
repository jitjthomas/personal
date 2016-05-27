class Some {
	Integer x 
	String y
	
	def m1() {println "no params"}
	def m2(Integer a) { println "Passed an Integer ${a}"}
	def m3(String s) { println "Passed a String ${s}" }
	def m4(Integer a, String s) { println "Passed an Intgere ${a} and a String ${s}"}
}

Some s = new Some()

s.m1()
s.m2(2)
s.m3 'Hello'
s.m4 2, 'Helo'

if(s.metaClass.respondsTo(s, "m1")) println 'Got m1 with no params'
if(s.metaClass.respondsTo(s, "m2", Integer)) println 'Got m2 with Integer Param'
if(s.metaClass.respondsTo(s, "m3", String)) println 'Got m3 with String Param'
if(s.metaClass.respondsTo(s, "m3", Integer, String)) println 'Got m3 with Integer and String Param'
if(s.metaClass.hasProperty(s, 'x')) println "Got a property by name x"
