package org.craftedsw.tripservicekata.trip

import com.nhaarman.mockito_kotlin.isNotNull
import org.craftedsw.tripservicekata.TripService_Original
import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.User
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

class TripServiceTest {

    @Test(expected = UserNotLoggedInException::class)
    fun shouldGiveExceptionIfUserIsNotLoggedIn() {

        // given
        val user = User()

        /**
         * system under test
         */
        val sut = TripServiceWithoutLoggedInUser()

        // when
        sut.getTripsByUser(user = user)
    }

    @Test
    fun shouldReturnEmptyList() {
        val user = User()

        val sut = TripServiceWithLoggedInUser()

        val result = sut.getTripsByUser(user = user)

        assertThat(result, notNullValue())
    }
}

// TODO use mockito
class TripServiceWithoutLoggedInUser(): TripService_Original() {

    override fun loggedInUser(): User? {
        return null
    }
}

class TripServiceWithLoggedInUser() : TripService_Original() {

    override fun loggedInUser(): User? {
        return User()
    }
}
