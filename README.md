# Compose Onboarding App
![onboarding_cover-01](https://github.com/user-attachments/assets/3b16ce40-de6e-455f-9076-b2aace7e676d)

## Overview
This Android application demonstrates a modern onboarding experience using Jetpack Compose, Material 3 design, and Accompanist libraries. The app features three distinct layouts to guide users through the initial app introduction.

## Screenshots
<p float="left">
  <img src="https://github.com/user-attachments/assets/4b15c8a8-092e-40c8-b5c9-da91f0a05430" width="250" />
  <img src="https://github.com/user-attachments/assets/e73aaa65-44fc-4a65-b2b0-cbb5149aa087" width="250" />
  <img src="https://github.com/user-attachments/assets/e2131b91-2d65-41cb-970c-b8f1d36fefd8" width="250" />
</p>

## Features
- 🎨 Material 3 Design System
- 📱 Responsive Layouts
- 🚀 Smooth Onboarding Experience
- 📸 Accompanist Integration

## Tech Stack
- Jetpack Compose
- Material 3
- Accompanist
- Kotlin


## Key Dependencies
```gradle
dependencies {
    // Compose
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material3:material3:$material3_version"
    
    // Accompanist
    implementation "com.google.accompanist:accompanist-pager:$accompanist_version"
    implementation "com.google.accompanist:accompanist-systemuicontroller:$accompanist_version"
    
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"
}
```


## How to Run
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on emulator or physical device

## Customization
- Modify `OnboardingScreens.kt` to change layouts
- Update drawable resources for custom images
- Adjust colors in `theme.kt`
