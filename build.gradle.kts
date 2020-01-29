plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
}

val arrow_version = "0.10.3"

group = "com.siha80.kotlin.study"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

apply(plugin = "java-library")
apply(plugin = "kotlin-kapt")

repositories {
    jcenter()
    mavenCentral()

    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://dl.bintray.com/spekframework/spek-dev") }
    maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
}

dependencies {
    implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
    implementation("org.springframework.session:spring-session-core")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    implementation("io.r2dbc:r2dbc-postgresql:0.8.0.RELEASE")

    compile ("io.arrow-kt:arrow-core:$arrow_version")
    compile ("io.arrow-kt:arrow-syntax:$arrow_version")
    compile ("io.arrow-kt:arrow-typeclasses:0.9.0")
    compile ("io.arrow-kt:arrow-data:0.8.2")
    compile ("io.arrow-kt:arrow-instances-core:0.8.2")
    compile ("io.arrow-kt:arrow-instances-data:0.8.2")
    compile ("io.arrow-kt:arrow-free:$arrow_version")
    compile ("io.arrow-kt:arrow-instances-free:0.8.2")
    compile ("io.arrow-kt:arrow-mtl:$arrow_version")
    compile ("io.arrow-kt:arrow-integration-retrofit-adapter:$arrow_version")
    compile ("io.arrow-kt:arrow-generic:$arrow_version")
    compile ("io.arrow-kt:arrow-recursion:$arrow_version")

//    compile ("io.arrow-kt:arrow-effects:0.8.2")
//    compile ("io.arrow-kt:arrow-effects-instances:0.8.2 ")
//    compile ("io.arrow-kt:arrow-effects-rx2:$arrow_version")
//    compile ("io.arrow-kt:arrow-effects-rx2-instances:$arrow_version")
//    compile ("io.arrow-kt:arrow-effects-reactor:$arrow_version")
//    compile ("io.arrow-kt:arrow-effects-reactor-instances:$arrow_version")
//    compile ("io.arrow-kt:arrow-effects-kotlinx-coroutines:$arrow_version")
//    compile ("io.arrow-kt:arrow-optics:$arrow_version")
//    compile ("io.arrow-kt:arrow-effects-kotlinx-coroutines-instances:$arrow_version")
//    compile ("io.arrow-kt:arrow-instances-recursion:$arrow_version")


    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
//    testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
    testImplementation("io.projectreactor:reactor-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.M2")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
