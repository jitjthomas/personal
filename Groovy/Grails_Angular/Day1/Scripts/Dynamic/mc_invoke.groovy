class XmlBuilder {

}

XmlBuilder.metaClass.invokeMethod = { name, args ->
	println "<${name}>"
	if(args.size() > 0 && args[0] instanceof Closure) {
		args[0].delegate = delegate
		args[0].call()
	}
	else {
		println args[0].toString()
	}
	println "</${name}>"
	
}
def xml = new XmlBuilder()

xml.html {
		head {
			title "Sample Page"
		}
		body {
			h1 "Sample"
			p "sample paragraph"
		}
}
