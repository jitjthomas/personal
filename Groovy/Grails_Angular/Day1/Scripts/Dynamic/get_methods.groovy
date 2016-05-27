def x = "Hello"

def methods = x.metaClass.methods.findAll {it.name.startsWith "value"}

methods.each {println it}

x.metaClass.properties.each { println it}