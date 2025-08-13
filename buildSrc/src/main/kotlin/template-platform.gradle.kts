import com.google.gson.JsonObject
import quest.toybox.sculptor.extension.ContributorRank
import quest.toybox.sculptor.gets
import quest.toybox.sculptor.sculptorChild
import quest.toybox.sculptor.task.JsonProcessingReader

// Signifies a Project that will be released to users, e.g. Fabric and NeoForge sub projects.

plugins {
    id("constants")
}

tasks.processResources {
    filesMatching(listOf("**/*.json", "**/*.mcmeta")) {
        val processor: (JsonObject.() -> Unit)? = when (name) {
            "fabric.mod.json" -> { ->
                val authors = getAsJsonArray("authors")
                val contributors = getAsJsonArray("contributors")

                for ((contributor, role) in ext.gets<Map<String, ContributorRank>>("contributors")) {
                    if (role.isAuthor()) {
                        authors.add(contributor)
                    } else {
                        contributors.add(contributor)
                    }
                }
            }
            else -> null
        }

        filter(mapOf("processor" to processor), JsonProcessingReader::class.java)
    }
}

tasks.jar {
    manifest {
        attributes(
            "SPDX-License-Identifier" to project.property("license") as String
        )
    }
}

sculptorChild("common", project(":common"))
