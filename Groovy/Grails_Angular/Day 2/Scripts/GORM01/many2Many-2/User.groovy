package com.ardhika.learn

class User {

    static constraints = {
		firstName blank:false, size:3..20
		lastName blank:false, size:3..20
		userName blank:false, size:6..12
		password blank:false, password:true
		email blank:false, email:true
		homePage url:true, nullable:true
		bio maxSize:150, nullable:true
    }
	
	String firstName
	String lastName
	String userName
	String password
	String email
	String homePage
	String bio
	
	static hasMany=[ownedCircles:Circle, memberships:Membership]

	
	String toString() {
		"$lastName, $firstName"
	}
}
