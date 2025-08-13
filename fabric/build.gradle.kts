import quest.toybox.sculptor.sculptorChild

plugins {
    id("quest.toybox.sculptor-fabric")
}

sculptorChild("common", project(":common"))

sculptor.finalizeMods()
