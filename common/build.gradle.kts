import quest.toybox.sculptor.sculptorParent

plugins {
    id("constants")
    id("quest.toybox.sculptor-common")
}

sculptorParent("common")

sculptor.finalizeMods()
