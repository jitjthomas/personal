class Car {
	def check() { println 'checking....'}
	def start() { println 'starting...' }
	def drive() { println 'driving...'}
}

Car.metaClass.invokeMethod = { String name, args ->
	println 'invoke method called...'
	
	if(name != 'check') {
		println 'need to check this out!'
		Car.metaClass.getMetaMethod('check').invoke(delegate, args)
	}
	def validMethod = Car.metaClass.getMetaMethod(name, args)
	if(validMethod) {
		validMethod.invoke(delegate, args)
	}
	else {
		Car.metaClass.invokeMissingMethod(delegate, name, args)
	}
}

Car.metaClass.methodMissing = {String name, args ->
	println "sorry! dont know how to ${name}"
	Car.metaClass."${name}" = { 
		println "Learnt to ${name}"
	}
}

Car car = new Car()

car.check()
car.start()
car.drive()
car.speed()
car.stop()
car.speed()
car.stop()