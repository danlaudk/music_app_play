package dao

import models.User

import scala.collection.mutable

class UserDAO  {

  private val users = mutable.Map( // should be private
    "Werner" -> User("Werner", "werner"),
    "Daniel" -> User("Daniel", "daniel")
  )

  def getUser(username: String): Option[User] = {
    users.get(username)
  }

  def addUser(username: String, password: String): Option[User] = {
    if(users.contains(username)) {
      Option.empty
    } else {
      val user = User(username, password)
      users.put(username, user)
      Option(user)
    }
  }

}