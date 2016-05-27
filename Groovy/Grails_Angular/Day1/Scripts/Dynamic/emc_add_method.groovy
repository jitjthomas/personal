String.metaClass.swapCase = { ->
	String s = delegate
	def sb = new StringBuffer()
	s.each {
		sb << (Character.isUpperCase(it as char) ? Character.toLowerCase(it as char) : Character.toUpperCase(it as char))
	}
	sb.toString();
}

String.metaClass.replaceChar = { o, r ->
	def sb = new StringBuffer()
	String s = delegate 
	s.each {
		sb << (it==o? r : it)
	}
	sb.toString()
}

Integer.metaClass.addFive = {
	Integer i = delegate
	 i+5
}
Integer.metaClass.getUnitDigit = {
	Integer i = delegate
	i % 10
}

String x = 'hElLO'
println x.swapCase()

String y = 'clap'
println y.replaceChar('l', 'r')

int z = 17
println z.addFive()
println z.unitDigit

