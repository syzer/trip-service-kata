package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.TripService_Original
import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.User
import org.junit.Test

class TripServiceTest {

    @Test(expected = UserNotLoggedInException::class)
    fun shouldGiveExceptionIfUserIsNotLoggedIn() {

        // given
        val user = User()

        /**
         * system under test
         */
        val sut = MyMockOfTripService()

        // when
        sut.getTripsByUser(user = user)
    }
}

class MyMockOfTripService(): TripService_Original() {

    override fun loggedInUser(): User? {
        return null
    }
}