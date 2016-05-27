import com.ardhika.learn.User


class BootStrap {

    def init = { servletContext ->
		
		def user = new User(firstName:'Tim', lastName:'Norton', 
							userName:'timnor', password:'hello123', 
							email:'tim@norton.com')
		
		if(user.save()) {
			println user.id + "--> $user"
			println user.email
		}
		else {
			println 'user not saved'
			user.errors.allErrors.each {
				println it
			}
		}
		
		user.email = 'tim@norton.co.uk'
		println "email changed to $user.email"
    }
	
    def destroy = {
    }
}
