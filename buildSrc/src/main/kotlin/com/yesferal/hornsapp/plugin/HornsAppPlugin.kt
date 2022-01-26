package com.yesferal.hornsapp.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import com.yesferal.hornsapp.plugin.dependency.HornsApp

class HornsAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val message = "HornsApp Plugin Version: ${HornsApp.plugin}"
        val extension = project.extensions.create<HornsAppExtension>(message)
        project.task("sayHello"){
            doLast{
                println(extension.message)
            }
        }
    }
}
