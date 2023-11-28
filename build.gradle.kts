plugins {
    id("java")
    kotlin("jvm") version "1.3.40"
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    implementation("org.junit.platform:junit-platform-launcher:1.10.1")
    implementation("org.junit.jupiter:junit-jupiter-params:5.10.1")

//    Logging
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0"){
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }

//    Report Portal
    testImplementation("com.epam.reportportal:agent-java-junit5:5.1.10")
    testImplementation("com.epam.reportportal:logger-java-log4j:5.1.8")
    testImplementation("org.aspectj:aspectjweaver:1.9.2")

//    Others
    testImplementation("org.hamcrest:hamcrest:2.2")


}

tasks.test {
    testLogging.showStandardStreams = true
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)

    val weaver = classpath.find{
        it.name.contains("aspectjweaver")
    }
    jvmArgs(listOf("-javaagent:$weaver"))
}