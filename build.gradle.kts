plugins { id("java"); id("application") }

group = "com.group7"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

sourceSets.main { java.srcDirs("src") }

val mainClass = "appDomain.AppDriver"

application.mainClass.set(mainClass)

tasks.withType<Jar> {
    archiveFileName.set("Sort.jar")
    manifest.attributes("Main-Class" to mainClass)
}

tasks.register<JavaExec>("execJar") {
    classpath = files(tasks["jar"])
    args = listOf("fileName", "compareType", "shapeType")
}




