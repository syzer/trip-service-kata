package org.craftedsw.tripservicekata

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.trip.Trip
import org.craftedsw.tripservicekata.trip.TripDAO
import org.craftedsw.tripservicekata.user.User
import org.craftedsw.tripservicekata.user.UserSession
import java.util.*
import java.util.Objects.isNull

open class TripService_Original {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User? = loggedInUser()

        if (isNull(loggedUser)) {
            throw UserNotLoggedInException()
        }

        val isFriend: Boolean = loggedUser!!.isFriend(user)

        if (isFriend) {
            tripList = TripDAO.findTripsByUser(user)
        }
        return tripList
    }

    open fun loggedInUser() = UserSession.instance.loggedUser

}
