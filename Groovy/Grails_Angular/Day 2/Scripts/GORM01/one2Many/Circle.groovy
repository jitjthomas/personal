package com.ardhika.learn

class Circle {

    static constraints = {
		name blank:false, size:10..50
		description blank:false, size:10..250
		owner nullable:false
    }
	
	static hasMany = [discussions:Discussion]
	
	String name
	String description
	User owner
}
