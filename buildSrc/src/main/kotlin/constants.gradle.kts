import quest.toybox.SculptorSharedPlugin
import quest.toybox.sculptor.extension.ContributorRank
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    `java-library`
    kotlin("jvm")
}

group = project.property("group")!!
version = project.property("version")!!

repositories {
    mavenCentral()
}

val contributors = mapOf(
    "Ellie McQuinn" to ContributorRank.PROJECT_OWNER,
    "Toybox System" to ContributorRank.PROJECT_OWNER
).also { ext["contributors"] = it }

val extraReplacements = mutableMapOf(
    "license" to project.property("license"),
    "homepage" to project.property("mod_homepage"),
    "issue_tracker" to project.property("mod_issues"),
    "sources_url" to project.property("mod_sources"),
    "description" to "A modern extensible modding template for all of our mods.",
    "nf_authors" to contributors.filterValues(ContributorRank::isAuthor).keys.joinToString(","),
).also { ext["extra_replacements"] = it }

apply<SculptorSharedPlugin>()

val sculptor = the<SculptorExtension>()

extraReplacements["fl_minecraft_constraint"] = ">=${sculptor.minecraftVersion.normalizedVersion}"
extraReplacements["nf_minecraft_constraint"] = ">=${sculptor.minecraftVersion}"
