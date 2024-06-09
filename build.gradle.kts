plugins {
    id("java")
    id("application")
}

group = "com.group7"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.10.2"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//}
//
//tasks.test {
//    useJUnitPlatform()
//}

application.mainClass.set("appDomain.AppDriver")

tasks.withType<Jar> {
    manifest.attributes ("Main-Class" to "appDomain.AppDriver")
}

tasks.register<JavaExec>("execJar") {
    classpath = files(tasks["jar"])
    args = listOf("fileName", "compareType", "shapeType") // Add your desired arguments here
}
