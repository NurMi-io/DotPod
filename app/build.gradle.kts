/* Plugin
*/
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}
/* SDK
*/
android {
    compileSdkVersion(22)

    defaultConfig {
        applicationId("com.nurmi.dotpod")
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode(1)
        versionName("1.0-beta")
        
        // 베타 버전으로 설정
        versionNameSuffix("-beta")
    }
}
