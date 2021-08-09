import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
}

val jarName = "redis-client"
group = "com.redislabs"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-webflux")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("redis.clients:jedis:3.6.0")

    implementation(group = "io.projectreactor.kotlin", name = "reactor-kotlin-extensions", version = "1.0.2.RELEASE")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-reactor")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-jdk8")
    implementation(group = "org.reflections", name = "reflections", version = "0.9.12")

    api(group = "org.springdoc", name = "springdoc-openapi-webflux-core", version = "1.4.0")
    api(group = "org.springdoc", name = "springdoc-openapi-kotlin", version = "1.4.0")
    api(group = "org.springdoc", name = "springdoc-openapi-webflux-ui", version = "1.4.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}