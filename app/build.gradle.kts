plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }
android {
 namespace="com.hits20radio.online"; compileSdk=36
 defaultConfig { applicationId="com.hits20radio.online.v2"; minSdk=23; targetSdk=36; versionCode=2; versionName="2.0" }
 buildTypes { release { isMinifyEnabled=false } }
 compileOptions { sourceCompatibility=JavaVersion.VERSION_11; targetCompatibility=JavaVersion.VERSION_11 }
 kotlinOptions { jvmTarget="11" }
}
dependencies {
 val m="1.10.1"
 implementation("androidx.core:core-ktx:1.17.0")
 implementation("androidx.appcompat:appcompat:1.7.1")
 implementation("com.google.android.material:material:1.13.0")
 implementation("androidx.media3:media3-exoplayer:$m")
 implementation("androidx.media3:media3-exoplayer-hls:$m")
 implementation("androidx.media3:media3-ui:$m")
 implementation("androidx.media3:media3-session:$m")
}
