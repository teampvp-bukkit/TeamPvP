package com.k9rosie.teampvp.util

import com.k9rosie.teampvp.Plugin
import org.bukkit.Bukkit

class RepeatingTask(
    var time: Long = -1,
    var delay: Long = 0,
    val onEnd: () -> Unit = {},
    inline val task: () -> Unit
) {
    var taskId = 0

    fun start() {
        if (taskId != 0 && time > -1) {
            Bukkit.getLogger().warning("Attempted to start a timer that has already been started")
        }

        val runnable = Runnable {
            task()
            time--
            if (time <= -1) {
                onEnd()
                stop()
            }
        }

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Plugin.instance, runnable, delay, time)
    }

    fun pause() {
        Bukkit.getScheduler().cancelTask(taskId)
        taskId = 0
    }

    fun stop() {
        Bukkit.getScheduler().cancelTask(taskId)
        time = -1
        taskId = 0
    }
}