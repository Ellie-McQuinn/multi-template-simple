import quest.toybox.sculptor.commonDataRun

plugins {
    id("template-platform")
    id("quest.toybox.sculptor-neoforge")
}

sculptor.finalizeMods()

neoForge {
    runs {
        commonDataRun(project(":common"), project)
    }
}
