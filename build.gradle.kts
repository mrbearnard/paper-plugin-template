plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.plugin.yml)
    alias(libs.plugins.paperweight.userdev)
}

group = "me.mrbernard"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper)
    implementation(libs.bundles.cloud)
}

tasks {
    build {
        dependsOn("shadowJar")
    }

    runServer {
        minecraftVersion("1.21.11")
    }
}

kotlin {
    jvmToolchain(21)
}

paper {
    main = "me.mrbernard.paperPluginTemplate.PaperPluginTemplate"
    version = project.version as String
    apiVersion = "1.21"
}