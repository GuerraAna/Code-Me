---
name: run-platforms
description: How to run, verify and troubleshoot each platform target of this Compose Multiplatform project (Web/Wasm, Desktop JVM, Android, iOS). Invoke whenever the user asks to run, build, or test the app on any platform.
---

# Running the Code-Me app per platform

Project root for all commands: `cmp/`. Use the Gradle wrapper: `./gradlew`.

## Environment (always verify first)

- **JDK 17 or 21 only** — newer JDKs (e.g. the system JDK 26) break the Gradle build.
  Always run Gradle with `JAVA_HOME=/opt/homebrew/opt/openjdk@21` (also set in
  `gradle.properties` via `org.gradle.java.home`).
- Gradle wrapper: Gradle 8.14.5, Kotlin 2.0.21.
- Working directory for all commands below: `cmp/`.

## Per-platform run commands

| Platform | Command | Notes |
|---|---|---|
| Web (Wasm, dev + hot reload) | `./gradlew :composeApp:wasmJsBrowserDevelopmentRun` | Opens at http://localhost:8080 (port may vary — check console output). Use `browser_preview` so the user can see it. |
| Web (Wasm, production) | `./gradlew :composeApp:wasmJsBrowserProductionRun` | Slower build, optimized output. |
| Desktop (JVM) | `./gradlew :composeApp:run` | Native window; distributable via `:composeApp:packageDmg`. |
| Android | `./gradlew :composeApp:installDebug` | Requires emulator running or device connected — verify with `adb devices` first. Build-only: `:composeApp:assembleDebug` (APK in `composeApp/build/outputs/apk/`). |
| iOS (macOS only) | Open `cmp/iosApp/iosApp.xcodeproj` in Xcode and press Run | Cannot be run from the terminal reliably; the `CodeMe` shared framework is compiled during the Xcode build. |

## Before running: checklist

1. Confirm the target platform with the user if ambiguous ("rodar o app" → ask which target, default suggestion: Web dev run for fastest feedback).
2. Verify JDK: `JAVA_HOME=/opt/homebrew/opt/openjdk@21` must exist.
3. Android only: `adb devices` must list a device/emulator.
4. Run Gradle commands from `cmp/`, not the repo root.
5. Long-running runs (dev server, desktop app): launch in background (`timeout: 0`) and monitor with `get_output`; for web, open a `browser_preview` at the printed port.

## Verification after changes

- Compile check without running a full app: `./gradlew :composeApp:compileKotlinDesktop` (fast JVM compile of common code).
- iOS compile check: `./gradlew :composeApp:compileKotlinIosSimulatorArm64` (add `compileKotlinIosX64 compileKotlinIosArm64` to cover all iOS targets).
- Full check: `./gradlew :composeApp:check`.
- Wasm browser runs need a browser with Wasm GC (Chrome 119+, Firefox 120+; Safari is unsupported).

## Troubleshooting

- `JAVA_HOME` unset → build may pick JDK 26 and fail. Always prefix commands with `JAVA_HOME=/opt/homebrew/opt/openjdk@21`.
- wasmJs tasks download Node/Yarn/binaryen on first run — expect a slow first build.
- Port already in use on web run → read the actual port from the console output.
- iOS build failures in shared framework → run `./gradlew :composeApp:embedAndSignAppleFrameworkForXcode` to reproduce outside Xcode.
- kotlin-lsp (VS Code) project import fails in `:composeApp:commonizeNativeDistribution` with
  `ClassNotFoundException: com.intellij.platform.core.nio.fs.MultiRoutingFileSystemProvider` →
  known kotlin-lsp bug: the LS leaks `java.nio.file.spi.DefaultFileSystemProvider` into the
  commonizer's child JVM. Workaround: warm the cache from a normal terminal with
  `JAVA_HOME=/opt/homebrew/opt/openjdk@21 ./gradlew :composeApp:prepareKotlinIdeaImport`
  (tasks succeed outside the LS and stay cached/UP-TO-DATE for the next import),
  then restart the language server in VS Code.
