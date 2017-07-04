package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.TripService_Original
import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.user.User
import org.junit.Test

class TripServiceTest {

    @Test(expected = CollaboratorCallException::class)
    fun shouldGiveExceptionIfUserIsNotLoggedIn() {

        // given
        val user = User()

        /**
         * system under test
         */
        val sut = TripService_Original()

        // when
        sut.getTripsByUser(user = user)
    }
}
