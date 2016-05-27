class Dog {
	def bark() {println 'Woof!'}
	def sit() {println 'sitting…'}
	def jump() {println 'boink!'}
}


def doAction(animal, action) {
	animal."${action}"()
}

def a = new Dog()
doAction(a, "bark")
doAction(a, "sit")
doAction(a, "jump")