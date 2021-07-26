import com.vanniktech.maven.publish.MavenPublishPluginExtension
import com.vanniktech.maven.publish.SonatypeHost
import net.minecraftforge.gradle.common.util.RunConfig
import net.minecraftforge.gradle.userdev.UserDevExtension
import org.gradle.jvm.toolchain.JvmVendorSpec.ADOPTOPENJDK
import java.time.Instant.now
import java.time.format.DateTimeFormatter.ISO_INSTANT

plugins {
	idea
	`java-library`
	kotlin("jvm") version "latest.release"
	id("org.jetbrains.dokka") version "latest.release"
	id("com.vanniktech.maven.publish")
	id("net.minecraftforge.gradle")
}

// Config -> Minecraft
val forgeVersion = getProperty("forgeVersion")
val minecraftVersion = getProperty("minecraftVersion")

val version = getProperty("VERSION_NAME")
val group = getProperty("GROUP")
val modId = getProperty("POM_ARTIFACT_ID")
val libraryName = getProperty("POM_NAME")
val author = getProperty("POM_DEVELOPER_NAME")

val testModId = "craftingrecipes_test"

// JVM Info
println(
	"""
		Java: ${System.getProperty("java.version")} 
		JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")}) 
		Arch: ${System.getProperty("os.arch")}
	""".trimIndent()
)

repositories {
	maven("https://thedarkcolour.github.io/KotlinForForge/")
	mavenCentral()
}

dependencies {
	"minecraft"(group = "net.minecraftforge", name = "forge", version = "$minecraftVersion-$forgeVersion")
	implementation(group = "thedarkcolour", name = "kotlinforforge", version = "latest.release")
	implementation(group = "io.github.microutils", name = "kotlin-logging-jvm", version = "latest.release")
}

// Minecraft
configure<UserDevExtension> {
	mappings("official", minecraftVersion)

	runs {
		create("data") {
			workingDirectory(file("run"))

			taskName = "datagen"

			// Recommended logging data for a userdev environment
			property("forge.logging.markers" to "SCAN,REGISTRIES,REGISTRYDUMP")

			// Recommended logging level for the console
			property("forge.logging.console.level" to "debug")

			// Specify the mod id for data generation, where to output the resulting resource, and where to look for existing resources.
			args(
				"--mod",
				testModId,
				"--all",
				"--output",
				file("src/generated/resources/"),
				"--existing",
				file("src/test/resources/")
			)

			mods {
				create(testModId) {
					source(sourceSets["test"])
				}
			}
		}
	}
}

// Setup
project.group = group
project.version = version
base.archivesName.set(modId)

// Sets the toolchain to compile against OpenJDK 16
java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(16))
		vendor.set(ADOPTOPENJDK)
	}
}

// Finalize the jar by re-obfuscating
tasks.named<Jar>("jar") {
	// Manifest
	manifest {
		attributes(
			"Specification-Title" to libraryName,
			"Specification-Vendor" to author,
			"Specification-Version" to "1",
			"Implementation-Title" to libraryName,
			"Implementation-Version" to project.version,
			"Implementation-Vendor" to author,
			"Implementation-Timestamp" to ISO_INSTANT.format(now()),
			"FMLModType" to "LIBRARY",
		)
	}

	finalizedBy("reobfJar")
}

tasks.dokkaHtml.configure {
	outputDirectory.set(projectDir.resolve("docs"))
}

// Publishing to maven central
extensions.getByType<MavenPublishPluginExtension>().sonatypeHost = SonatypeHost.S01

fun RunConfig.property(property: Pair<String, String>) = property(property.first, property.second)
fun getProperty(name: String, defaultValue: String = "") = findProperty(name)?.toString() ?: defaultValue