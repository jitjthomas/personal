languages = new XmlParser().parse('langs.xml')
println "Languages and authors"
languages.each {
	println "${it.@name} authored by ${it.author[0].text()}"
}
def languagesByAuthor = { authorName ->
	languages.findAll { 
		it.author[0].text() == authorName 
	}.collect {it.@name }.join(', ')
}
println "Languages by Wirth:" + languagesByAuthor('Wirth')