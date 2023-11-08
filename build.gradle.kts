plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

apply(plugin = "io.spring.dependency-management")

group = "br.com.luislabs"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    val mapStructVersion = "1.5.5.Final"

    // Jackson
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")

    // Flyway
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    // Map Struct
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")
    implementation("org.mapstruct:mapstruct:$mapStructVersion")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")

    // Mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Tests
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
