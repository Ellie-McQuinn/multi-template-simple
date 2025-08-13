import quest.toybox.sculptor.commonDataRun
import quest.toybox.sculptor.sculptorChild

plugins {
    id("quest.toybox.sculptor-neoforge")
}

sculptorChild("common", project(":common"))

sculptor.finalizeMods()

neoForge {
    runs {
        commonDataRun(project(":common"), project)
    }
}
