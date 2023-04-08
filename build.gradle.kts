// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    ey.samarin.composabletemplates.Config.Plugins.plugins.forEach { (name, ver) ->
        id(name) version ver apply false
    }
}