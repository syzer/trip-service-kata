const UserSession = require('./UserSession')
const TripDAO = require('./TripDAO')

class TripService {
  getTripsByUser(user) {
    let tripList = []
    const loggedUser = UserSession.getLoggedUser()
    let isFriend = false
    if (!loggedUser) {
      const friends = user.getFriends()
      for (let i = 0; i < friends.length; i++) {
        const friend = friends[i]
        if (friend === loggedUser) {
          isFriend = true
          break
        }
      }
      if (isFriend) {
        tripList = TripDAO.findTripsByUser(user)
      }
      return tripList
    }
    throw new Error('User not logged in.')
  }
}

module.exports = TripService
