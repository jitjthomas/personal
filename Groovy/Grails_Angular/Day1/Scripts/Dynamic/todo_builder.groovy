class TodoBuilder {
	def result = new StringWriter()
	def level = 0
	
	def build(closure) {
		result << "To - do List:\n"
		closure.delegate = this
		closure()
		println result 
	}
	
	def methodMissing(String name, args) {
		handle name, args
	}
	
	def propertyMissing(String name) {
		Object[] emptyParams = []
		handle name, emptyParams
	}
	
	def handle(String name, args) {
		level++
		level.times { result << " "}
		def bullet = placeProperBullet(args)
		result << bullet
		result << name.replaceAll("_", " ")
		result << printArgs(args)
		result << "\n"

		if(args.length > 0 && args[-1] instanceof Closure) {
			def theClosure = args[-1]
			theClosure.delegate = this
			theClosure()
		}
		
		level--
	}
	
	def placeProperBullet(args) {
		args.length > 0 && args[0] instanceof Map && args[0]['status'] == 'done' ? 'x ' : '- '
	}
	
	def printArgs(args) {
		def values = ""
		if(args.length > 0 && args[0] instanceof Map) {
			values = " ["
			def count = 0
			args[0].each { key, value ->
				if(key == 'status') return
				count++
				if (count > 1) values += " "
				values += "${key} : ${value}"
			}
			values += "]"
		}
		values
	}
}

def tdb = new TodoBuilder()
tdb.build {
	create_groovy_presentation (start:'15-May', end:'31-May'){
		learn_groovy(end:'17-May', status:'done')
		leanr_mop
	}
}