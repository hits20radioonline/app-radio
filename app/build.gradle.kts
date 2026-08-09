plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hits20radio.online.v2"
    compileSdk = 34 // Ajustado a una versión estable recomendada para evitar conflictos con librerías de terceros

    defaultConfig {
        applicationId = "com.hits20radio.online.v2"
        minSdk = 23
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    val m = "1.10.1"
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.media3:media3-exoplayer:$m")
    implementation("androidx.media3:media3-exoplayer-hls:$m")
    implementation("androidx.media3:media3-ui:$m")
    implementation("androidx.media3:media3-session:$m")
    
    // Librería del vúmetro / ecualizador visual dinámico
    implementation("com.github.gauravk95:audiovisualizer:0.9.2")
}
