plugins {
    id("java")
}

group = "org.qrbot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.2.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.google.zxing:core:3.5.1")
    implementation("com.google.zxing:javase:3.4.1")
    implementation("org.telegram:telegrambots:5.6.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
