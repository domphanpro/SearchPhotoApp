import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugin.Id.JAVA_LIBRARY)
    id(Plugin.Id.KOTLIN)
}


repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {
    implementation(LibraryDependency.kotlinStdlib)
}