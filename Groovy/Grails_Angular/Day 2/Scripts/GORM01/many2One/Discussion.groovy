package com.ardhika.learn

class Discussion {

    static constraints = {
		topic blank:false, size:15..250
		owner nullable:false
    }
	
	static belongsTo=[circle:Circle]
	
	String topic //need to add more
	User owner
}
