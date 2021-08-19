plugins {
    id(Plugin.Id.ANDROID_APPLICATION)
    id(Plugin.Id.KOTLIN_ANDROID)
    id(Plugin.Id.DAGGER_HILT)
    kotlin(Plugin.Id.KAPT)

}

android {
    compileSdkVersion(projectconfig.AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(projectconfig.BuildConfig.Versions.ANDROID_BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = "com.example.searchphoto"
        minSdkVersion(projectconfig.AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(projectconfig.AndroidConfig.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {


    implementation(LibraryDependency.kotlinStdlib)
    implementation(LibraryDependency.coreKtx)
    implementation(LibraryDependency.appcompat)
    implementation(LibraryDependency.kotlinCoroutines)
    implementation(LibraryDependency.kotlinCoroutinesAndroid)
    implementation(LibraryDependency.LifeCycle.liveData)
    implementation(LibraryDependency.design)
    implementation(LibraryDependency.constraintlayout)
    implementation(LibraryDependency.activityKtx)
    implementation(LibraryDependency.recyclerview)
    implementation(LibraryDependency.picasso)
    implementation(LibraryDependency.Network.retrofit2)
    implementation(LibraryDependency.Test.junitParams)

    implementation(LibraryDependency.roomRuntime)
    implementation(LibraryDependency.roomKtx)
    implementation (LibraryDependency.fragmentKtx)
    kapt(LibraryDependency.roomCompiler)

    implementation(LibraryDependency.daggerHilt)
    kapt(LibraryDependency.daggerHiltCompiler)

    testImplementation(LibraryDependency.Test.junit)
    androidTestImplementation(LibraryDependency.Test.junitExt)
    androidTestImplementation(LibraryDependency.Test.espresso)
    testImplementation(LibraryDependency.Test.archCore)
    testImplementation(LibraryDependency.Test.archCoreTesting)
    testImplementation(LibraryDependency.Test.mockk)
    testImplementation(LibraryDependency.Test.mockkAndroid)
    testImplementation(LibraryDependency.Test.assertjCore)
    testImplementation(LibraryDependency.Test.kotlinCoroutinesTest)

    // region Projects implementation

    implementation(project(Modules.Repository.consultation))
    implementation(project(Modules.Repository.network))
    implementation(project(Modules.Model))

    // endregion


}