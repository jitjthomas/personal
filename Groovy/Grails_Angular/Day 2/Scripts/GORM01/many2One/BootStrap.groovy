import com.ardhika.learn.*


class BootStrap {

	def init = { servletContext ->
		setupSampleUser()
	}

	def destroy = {
	}

	def setupSampleUser() {
		def user = new User(firstName:'Tim', lastName:'Norton',
				userName:'timnor', password:'hello123',
				email:'tim@norton.com')

		if(user.save()) {
			println user.id + "--> $user"
			println user.email
		}
		else {
			println 'user not saved'
			user.errors.allErrors.each { println it }
		}

		//		user.email = 'tim@norton.co.uk'
		//		println "email changed to $user.email"

		def circle = new Circle(name:'Test circle 1', description:'describe test circle 1', owner:user)
		circle.save(flush:true)
		
		def disc = new Discussion(topic: 'topic 123456789123?', circle:circle, owner:user)
		disc.save(flush:true)

	}
}
