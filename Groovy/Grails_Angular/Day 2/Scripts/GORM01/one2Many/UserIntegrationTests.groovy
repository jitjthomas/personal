package com.ardhika.learn

import static org.junit.Assert.*
import org.junit.*

class UserIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testCreatingUser() {
		def user = new User(firstName:'Jim', lastName:'Dalton',
			userName:'jimdal', password:'hello123',
			email:'jim@dalton.com')
		boolean saved = user.save()
		assertTrue saved
    }
}
