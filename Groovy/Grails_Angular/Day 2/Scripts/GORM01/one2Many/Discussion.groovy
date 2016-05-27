package com.ardhika.learn

class Discussion {

    static constraints = {
		topic blank:false, size:15..250
    }
	
	static belongsTo=[circle:Circle]
	
	String topic //need to add more
}
