import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.compose") version "1.5.10"
}

group = "com.example"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material) // Use material (Jetbrains Compose supported)
    // DO NOT add material3 from AndroidX on Desktop
    implementation("org.jetbrains.compose.material3:material3-desktop:1.2.1") // ✅ Correct material3 for desktop
}

kotlin {
    jvmToolchain(17)
    sourceSets.all {
        languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "My-Portfolio"
            packageVersion = "1.0.0"
        }
    }
}
