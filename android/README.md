# healthCues Android (Kotlin)

Simple native Android app that displays:

healthCues on BentoBoxDS

## Build & Run (Android Studio)
1. Open the folder `healthcues/android` in Android Studio.
2. Let Gradle sync. If prompted, use JDK 17 and install any missing SDK components.
3. Select your Pixel device or an emulator.
4. Click Run.

## Command line (optional)
If you prefer CLI builds, ensure JDK 17 and Android SDK are installed and ANDROID_HOME is set, then from `healthcues/android`:
- Generate wrapper (if needed): `gradle wrapper`
- Assemble debug: `./gradlew assembleDebug`
- Install to connected device: `./gradlew installDebug`
