class anInterceptable implements GroovyInterceptable{
	def method1() {
		println 'existing method called...'
	}
	
	def invokeMethod(String name, args) {
		"invokeMethod called for method ${name}"
	}
}

class Normal {
	def method1(x) {
		println "method1 called with arg - ${x}"
	}
	
	def method2 = {
		println "method2 closure called with arg - ${it}"
	}
	
	def method3(x){
		println "method 3 called with arg - ${x}"
	}
	
	def methodMissing(String name, args) {
		println "method with name ${name} with args ${args} - missing"
	}
	
	def invokeMethod(String name, args) {
		println "method with name ${name} with args ${args} - invoked"
	}
}

Normal.metaClass.method3 = {
	println "method 3 overridden in metaclass with arg - ${it}"
}

//Normal.metaClass.invokeMethod = {String name, args ->
//	println "method with name ${name} with args ${args} - metaclass invoked"
//}

// 1. If the class implements interceptable always use invokeMethod
//def ai = new anInterceptable()
//println ai.method2()
//println ai.method1()

def an = new Normal()
//2. Method in meta call preferred over what is there in the class
//an.method3(3)
//3. method is available in class use it
//an.method1(4)
//4. method is available as a closure call it
//an.method2(5)
//5. missing method called
//an.method4(2,3)
//an.method5(5,6)