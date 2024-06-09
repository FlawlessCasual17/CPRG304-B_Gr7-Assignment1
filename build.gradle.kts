plugins {
    id("java")
    id("application")
}

group = "com.group7"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

sourceSets.main { java.srcDirs("src") }

application.mainClass.set("appDomain.AppDriver")

tasks.withType<Jar> {
    archiveFileName.set("Sort.jar")
    manifest.attributes("Main-Class" to "appDomain.AppDriver")
}

tasks.register<JavaExec>("execJar") {
    classpath = files(tasks["jar"])
    args = listOf("fileName", "compareType", "shapeType") // Add your desired arguments here
}
