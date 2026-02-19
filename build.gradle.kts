plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

//    implementation("org.apache.logging.log4j:log4j-bom:2.24.3")
//    implementation("org.apache.logging.log4j:log4j-api")
//    implementation("org.apache.logging.log4j:log4j-core")
//    implementation("org.apache.logging.log4j:log4j-slf4j-impl")

    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks.test {
    useJUnitPlatform()
}
