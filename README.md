# ms-tech-challenge

Tech challenge for Marley Spoon, coded by Kotlin for Android platform.

## Install  

- Clone repository
- Change space id, environment id and access token in app/build.gradle file  
- Run the app (minimum SDK version 21)

## Rendered data  

Displaying a preview of all recipes in RecyclerView with list item
Recipes page:  

- Recipe Image
- Recipe Title  

Recipe Detail page (BottomSheet):  

- Recipe Image  
- Recipe Title  
- Chef Name  
- Tags  
- Description  

## Architecture  

MVVM with Repository pattern, removed ViewState classes becasue layering is that complex.
  
## Libraries  

- [Architecture Components](https://developer.android.com/arch)
- [Material](https://material.io/develop/android/docs/getting-started)  
- [Android Databinding](https://developer.android.com/topic/libraries/data-binding/index.html)  
- [Dagger 2](https://dagger.dev/) for dependency injection  
- RxJava, RxAndroid, and RxKotlin  
- [Glide](https://github.com/bumptech/glide) for image loading  
- [OkHttp & Retrofit](https://square.github.io/retrofit/) for network calls  
- [SuperBottomSheet](https://github.com/andrefrsousa/SuperBottomSheet) for bottomsheet recipe detail page
