# SwipeToDelete

The main view of the app is a scrolling list view of recent posts in date order. If the user touches a post, it displays a webview with the linked article. If the user slides a cell, they remove an individual post from this list. Once a post is deleted it does not reappear even if the data is updated. The user can pull to refresh the list 

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
