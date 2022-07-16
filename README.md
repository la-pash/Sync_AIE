## Author

**Seif Eddine Kharrachi**

# Sync

Native Android App that display a list of employees fetched from api .

## API Reference

#### Get all employees

```http
  GET  https://pre-screening.free.beeceptor.com/employees.
```

## key Components

[![](https://img.shields.io/badge/WORK_MANAGER-blue.svg)]()

[![](https://img.shields.io/badge/MVVM_ARCHITECTURE-orange.svg)]()

[![](https://img.shields.io/badge/ROOM-yellow.svg)]()

[![](https://img.shields.io/badge/Live_Data-purple.svg)]()

[![](https://img.shields.io/badge/Retrofit-green.svg)]()

## Features

-  TargetSdkVersion: 29 ( Android 10 ) .
-  Displays A List of employees on the main UI .
-  Uses Work Manager to run background services .
-  Uses LiveData to subscribe to changes .
-  Uses Foreground Services with PeriodicWorkRequest introduced in WorkManager .

## Configuration

Make sure to have enabled androidx and included these following dependecies .

```bash
  // Work Manager
  implementation "androidx.work:work-runtime:2.7.1"

  // Room components
  implementation "androidx.room:room-runtime:2.3.0"
  annotationProcessor "androidx.room:room-compiler:2.3.0"
  androidTestImplementation "androidx.room:room-testing:2.3.0"

  // Lifecycle components
  implementation "androidx.lifecycle:lifecycle-viewmodel:2.3.1"
  implementation "androidx.lifecycle:lifecycle-livedata:2.3.1"
  implementation "androidx.lifecycle:lifecycle-common-java8:2.3.1"
```

## Project Structure

```bash
pasha.app.syncproject
    ├
    ├── acitivities
    ├────────├── acitivities
    ├────────├── adapters
    ├
    ├── repositories
    ├───────├── local
    ├───────├── external
    ├
    ├── room
    ├────├── entities
    ├────├── daos
    ├────├── roomDb.java
    ├
    ├── services
    ├── viewModel
    ├── BaseApp.java

```

## Tech Stack

**IDE** : Android Studio .
**Programming Language** : Java .
**UI** : XML .
**Architecture** : MVVM .
**Jetpack components** : Room, LiveData, Work Manager, View Model

