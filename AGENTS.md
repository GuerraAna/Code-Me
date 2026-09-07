# Code-Me — Project Rules

Compose Multiplatform (Kotlin) app living in `cmp/` — targets: Web (Wasm),
Desktop (JVM), Android, iOS. Editor: VS Code with the JetBrains Kotlin
language server (`JetBrains.kotlin-server`); open `Code-Me.code-workspace`.

## Rules

- Run Gradle only from `cmp/` and always with
  `JAVA_HOME=/opt/homebrew/opt/openjdk@21` (JDK 26 breaks the build).
- When the user asks to run, build or test any platform, use the
  `run-platforms` skill for the correct command and verification checklist.
- Do not commit `build/`, `.gradle/`, `.idea/`, `.fleet/` or `local.properties`.
- Keep VS Code config in `Code-Me.code-workspace` (versioned) — never in
  `.vscode/settings.json` overrides that conflict with it.
