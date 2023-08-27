## Tournament and Matchmaking
This is an project that uses sql as its persistent storage and uses mongodb when frequently accesed collections such as country lists are accesed
in mongo collection there are UkList	UsList	TrList	FrList	GrList and When a user sends enter the tournamentrequest that user is inserted into a user's country list in a mongo database and when the collections 5 different country columns have at least 1 user in their lists
group containing the users is created. When the groups is created regarding users are removed from the respective lists. Lists work as a queue meaning that removing is done from the start as they are first ones to enter to the tournament The winner is decided by random.
## Using mongo
Using mongo to store different country's list and accessing them to create groups makes the the overall performace better compared to storing everything on the mysql.
## what can be improved
due to time limitation i was not able to implement asyc methods which is crucial for scalable applications such as this one

## All methods
Matchmaking class
public void StartMatchmaking(@RequestParam(name = "matchmakingid") int matchmakingid)
  when the collections 5 different country columns have at least 1 user in their lists automatically called

public List<User> getLeaderBoard(@RequestParam(name = "group_id") int group_id)
  Returns the leaderboard for the group 

Tournament class
public List<User> getLeaderBoard(@RequestParam(name = "CountryName") String Countryname)
  returns the leaderboard of the country

public Tournament CreateTournamentRequest()
  creates a new tournament

public Boolean EnterTournamentRequest(@RequestBody User user, @RequestParam(name = "Tournament_id") int Tournament_id)
  a user enters the tournament given the conditions are met

User class
public User CreateUserRequest()
  A new user is created country is decided by random

public User UpdateLevelRequest()
  level of the user is increased by one

public User UpdateScoreRequest()
  scores of the first and second places users are increased 

  


