String.metaClass.getCharCount = {
	delegate.size()
}

class Kid {
	Map props = [:]
}

Kid.metaClass.getName = {
	delegate.props["name"]
}

Kid.metaClass.setName = { value ->
	delegate.props["name"] = value
}

def x = "Hello"
println x.charCount

Kid k = new Kid()
k.name = 'Tom'
println k.name