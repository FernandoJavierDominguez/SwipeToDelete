# SwipeToDelete

The main view of the app is a scrolling list view of recent posts in date order. If the user touches a post, it displays a webview with the linked article. If the user slides a cell, they remove an individual post from this list. Once a post is deleted it does not reappear even if the data is updated. The user can pull to refresh the list.

# Strategy
If there is an Internet connection, the data ordered by date is captured from the API using OkHttp3, Retrofit and Gson. They are then saved to a local database using Room. To avoid duplicating the data obtained from the API, only those data that contain a date greater than that obtained in the last data load are stored in the database.
The view is only load with the data from local database. If there is no Internet connection, the data from the local database is displayed directly, without trying to capture the data from the API.

For navigation between fragments, graphic navigation is used. More info at: https://developer.android.com/guide/navigation/navigation-design-graph?hl=es

To pass information between the fragments a sharedViewModel is used. More info at: https://developer.android.com/topic/libraries/architecture/viewmodel#sharing

For simplicity, Dagger Hilt has been used for dependency injection. More info at: https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419

# Requirements
kotlin version = "1.4.10"

In your gradle:
  - minSdkVersion 23
  - targetSdkVersion 30

# Features
  - Clean Architecture 
  - MVVM
  - Dagger Hilt
  - Room 
  - Retrofit
  - OkHttp3
  - Coroutines
