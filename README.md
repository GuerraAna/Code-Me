# Code-Me

This is a Kotlin Compose Multiplatform project targeting Android, iOS, Web (Wasm) and Desktop (JVM).

All Gradle commands must be run from the [`cmp/`](./cmp) directory:

```bash
cd cmp
```

## Project structure

* [`cmp/composeApp`](./cmp/composeApp) — the shared Compose Multiplatform application. Its `src` folder contains:
  - `commonMain` — code shared across all targets
  - `androidMain`, `iosMain`, `desktopMain`, `wasmJsMain` — platform-specific code
* [`cmp/iosApp`](./cmp/iosApp) — the iOS application entry point (Xcode project). Add SwiftUI code here if needed.

## Prerequisites

- **JDK 17 or 21** — JDK 26+ is not supported by this Gradle version. The project is configured to use
  Homebrew's OpenJDK 21 via `org.gradle.java.home` in [`cmp/gradle.properties`](./cmp/gradle.properties).
  Adjust that property if your JDK lives elsewhere.
- **Android**: Android SDK installed and an emulator running or a device connected (`adb devices`).
- **iOS**: Xcode (macOS only).
- **Web**: a browser with Wasm GC support — Chrome 119+ or Firefox 120+.

## Running the apps

- **Android**: `./gradlew :composeApp:installDebug` (installs on a connected device/emulator)
  or `./gradlew :composeApp:assembleDebug` to only build the APK.
- **Desktop**:
  - Standard run: `./gradlew :composeApp:run`
  - Native installer (.dmg/.msi/.deb): `./gradlew :composeApp:packageDmg` (or `packageMsi`/`packageDeb`)
- **Web** (Wasm target): `./gradlew :composeApp:wasmJsBrowserDevelopmentRun`, then open
  `http://localhost:8080` (check the console output if the port differs).
- **iOS**: open [`cmp/iosApp/iosApp.xcodeproj`](./cmp/iosApp/iosApp.xcodeproj) in Xcode and run it from there.
  The Kotlin framework is built automatically by the Xcode build.

### Running everything at once

```bash
cd cmp
./gradlew :composeApp:run & \
./gradlew :composeApp:wasmJsBrowserDevelopmentRun & \
./gradlew :composeApp:installDebug & \
open iosApp/iosApp.xcodeproj & \
wait
```

## Running tests

- Android: `./gradlew :composeApp:testDebugUnitTest`
- Desktop: `./gradlew :composeApp:desktopTest`
- Web (Wasm): `./gradlew :composeApp:wasmJsBrowserTest`
- iOS: `./gradlew :composeApp:iosSimulatorArm64Test`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…
