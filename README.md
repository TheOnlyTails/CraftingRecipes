[![Maven metadata URL](https://img.shields.io/maven-metadata/v?color=blue&label=maven%20central&logo=gradle&metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fservice%2Flocal%2Frepositories%2Freleases%2Fcontent%2Fcom%2Ftheonlytails%2Fcraftingrecipes%2Fmaven-metadata.xml&style=for-the-badge)](https://search.maven.org/artifact/com.theonlytails/craftingrecipes)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/TheOnlyTails/craftingrecipes/Java%20CI%20with%20Gradle?label=gradle%20build&logo=github&style=for-the-badge)
![Kotlin](https://img.shields.io/badge/kotlin-%236C3FD1.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/gradle-%2302303A.svg?style=for-the-badge&logo=gradle&logoColor=white)
![GitHub License](https://img.shields.io/github/license/theonlytails/craftingrecipes?style=for-the-badge&logo=key)

# CraftingRecipes

A Kotlin DSL for creating crafting recipes in Minecraft Forge mods.

For documentation and usage instructions, please take a look at
the [wiki](https://github.com/TheOnlyTails/CraftingRecipes/wiki).

KDocs for the library (generated with [Dokka](https://github.com/kotlin/dokka)): https://craftingrecipes.theonlytails.com/

Here's
the [`maven-metadata.xml`](https://s01.oss.sonatype.org/service/local/repositories/releases/content/com/theonlytails/craftingrecipes/maven-metadata.xml)
of this library.

## Installation

_Don't forget to replace the VERSION key with the version in the top with the Maven Central badge at the top!_

#### Gradle/Groovy

```groovy
repositories {
    mavenCentral()
}

dependencies {
    def craftingRecipes = fg.deobf(project.dependencies.create(group: "com.theonlytails", name: "craftingrecipes", version: VERSION) {
	    transitive = false
    })
    
    implementation fg.deobf(craftingRecipes)
}
```

#### Gradle/Kotlin

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    val craftingRecipes = project.dependencies.create(group = "com.theonlytails", name = "craftingrecipes", version = VERSION)
		.apply { isTransitive = false }
    
    implementation(project.the<DependencyManagementExtension>().deobf(craftingRecipes))
}
```

The `isTransitive` property is added to make sure the library is imported correctly.

---

Check out other DSLs in the DataGenerators family!
- [LootTables](https://github.com/theonlytails/loottables)
- [BlockModels](https://github.com/theonlytails/BlockModels)
