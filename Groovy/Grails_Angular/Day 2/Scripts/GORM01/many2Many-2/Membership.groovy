package com.ardhika.learn

class Membership {

    static constraints = {
		user nullable:false
		circle nullable:false
    }
	
	static belongsTo = [user:User, circle:Circle]
}
