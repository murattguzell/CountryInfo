
# Country Info

This project is an Android application where users can view data about different countries. The application pulls the information of various countries via API and presents it to the user. Users can view a list of countries' names, flags and other basic information. They can also refresh the list by scrolling and the app ensures that the data is up-to-date.

Objective:
To provide users with easy access to basic information about countries around the world.
To present country information quickly and efficiently with a user-friendly interface.
Target Audience:
Users of all age groups who want to learn about countries around the world.
It is suitable for travelers, students and people interested in global information in general.
The app has a robust infrastructure using modern Android development tools (such as MVVM, LiveData, Coroutines), allowing users to conveniently observe data.


## Özellikler

- View Country Information:

Users can view a list of the names, flags and basic information of countries around the world.

- Swipe Refresh List:

Users can refresh the data and access the most up-to-date information by swiping down the screen. An animation is shown during the refresh process.

- Dynamic Data Updates:

The app updates the list by pulling data from the internet and always feeds the user with up-to-date data. A “loading” animation is displayed during the data update.

- Error Management:

In case of internet connection or data retrieval problems, the app notifies the user and provides a blank list accordingly. Animations and visuals inform the user in case of errors.

- User Friendly Interface:

With a simple and straightforward user interface, users can quickly view country information. The interface is made more interactive and pleasant with animations.
- Loading Indicator:

The app notifies the user of the data extraction process by showing a “loading” animation while the data is loading. This animation informs the user to wait while the process is in progress. 

- Görsel İçerik İndirme:

Uygulama, her ülkenin bayrağını ve diğer görsel içeriklerini hızlı bir şekilde indirip gösterir. Görsellerin yüklenmesi sırasında bir animasyon gösterilir.

- Veri Kaynağını Güncelleme:

Kullanıcılar, uygulamayı kullanırken veri kaynağı sürekli olarak güncellenir ve en doğru veriler sağlanır. Güncelleme sırasında animasyonlar kullanıcıyı bilgilendirir ve işlem tamamlandığında kullanıcıyı bilgilendirir.
  
## Kullanılan Teknolojiler

## Technologies Used

**Fragment:** Makes user interface components modular and reusable. In the project, it manages the interface in different pieces and improves the overall layout of the application.

**MVVM (Model-View-ViewModel):** Manages application data and provides the connection between UI and data. It provides separation between Model, View and ViewModel components and helps to make the application code more organized and testable. In the project, it is used to process application data and bind it to the user interface.

**LiveData:** Used as a lifecycle-aware data manager. It ensures that data is delivered to UI components securely. In the project, it automatically reflects data changes to the user interface.

**ViewBinding:** Provides type-safe access to XML layout files. This makes coding safer and error-free. In the project, it provides easy and secure access to components in XML files.

**SwipeRefreshLayout:** Allows the user to swipe to refresh the list. This increases user interaction and facilitates dynamic data updates. In the project, it allows users to manually update the list.

**Navigation Component:** Switches between fragments and securely passes arguments. This makes in-app navigation easier and safer. In the project, it provides secure and efficient transitions between fragments.

**Room:**

Description: Provides persistent data storage and interaction with the SQLite database. DAO (Data Access Object) and RoomDatabase classes are used for database operations. In the project, FoodDatabase and FoodDao classes permanently store and read food data. Room provides secure storage and management of data.

Usage in the Project: After being pulled from the internet, the data is stored in the Room database for 10 minutes. After 10 minutes, it is pulled from the internet again to update the data. If the internet connection is not established, the old data in the Room database continues to be used.

**Glide:** Provides loading and display of images. It is used for downloading images and creating placeholders. This makes it easier to manage the visual content of the application. In the project, it is used to load and display food images.

**Retrofit:** Used to perform network operations with REST API. It is used to retrieve and transform JSON data. This performs data retrieval operations over the network in a simple and efficient way. In the project, it is used to retrieve food data from the internet.

**Coroutines:** Kotlin Coroutines manage background operations. Asynchronous operations are performed with functions such as viewModelScope.launch and withContext. This lightens the UI workload and provides a smoother user experience. In the project, it is used to process data in the background and update the UI.

**SharedPreferences:** Used to permanently store small pieces of data within the application. The PrivateSharedPreferences class manages data storage and reading operations. This allows storing user settings and small pieces of data. In the project, it is used to store the data update time.
## Screenshots

![](https://github.com/murattguzell/CountryInfo/blob/master/gif/country.gif?raw=true)

  
