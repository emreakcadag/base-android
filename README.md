# Twitter Clone App

It is a Twitter clone application built to use the latest Android libraries and technologies.

## Tech stack & Open-source libraries

- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
    + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Gradle Kotlin Dsl](https://kotlinlang.org/docs/gradle.html)
- [MotionLayout](https://developer.android.com/training/constraint-layout/motionlayout) - is a layout type that helps you manage motion and widget animation in your app.
- Jetpack
    - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
    - ViewModel - Manages UI-related data holder and lifecycle aware.
    - DataBinding - Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    - ViewBinding - Binds UI component in view layer.
    - DataStore - is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers.
    - Room Persistence - Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
    - Navigation Component - Designed for apps that have one main activity with multiple fragment destinations.
- Architecture
    - MVVM Architecture (View - (DataBinding & ViewBnding) - ViewModel - Model)
    - Repository Pattern
- Firebase
    - [Remote Config](https://firebase.google.com/docs/remote-config) - Firebase Remote Config is a cloud service that lets you change the behavior and appearance of your app
      without requiring users to download an app update.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [Gson](https://github.com/google/gson) - JSON library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide) - Loading and caching images from network.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for building ripple animation, and CardView.

![architecture](https://user-images.githubusercontent.com/24237865/77502018-f7d36000-6e9c-11ea-92b0-1097240c8689.png)

## Installation

Please make sure google-play-services.json is included in app modules root direction.

## Author

[Emre Akçadağ](https://emreakcadag.com)

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.emreakcadag.com/linkedin/)

## License

[MIT](https://choosealicense.com/licenses/mit/)