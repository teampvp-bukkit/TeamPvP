package com.k9rosie.teampvp

object Timer {
    inline fun repeatingTask(interval: Int, task: () -> Unit): RepeatingTask {

    }

    abstract class Task(val time: Int = -1, val interval: Int = 20) {
        abstract var taskID: Int

        fun start() {
            print("start")
        }
        fun stop() {
            print("stopped")
        }
    }
}

/*package com.k9rosie.teampvp

import com.k9rosie.teampvp.util.severe
import org.bukkit.Bukkit

class Timer(
    var time: Long = -1,
    val interval: Long = 20,
    val delay: Long = 0,
    val onStart: () -> Unit = {},
    val onTick: () -> Unit = {},
    val onEnd: () -> Unit = {}
    ) {
    private var taskID: Int = 0

    fun start() {
        if (taskID != 0 && time > -1) {
            Bukkit.getLogger().severe(NLS.TIMER_ALREADY_STARTED)
            return
        }

        val task = {
            println("$taskID: $time")
            onTick()
            time--
            if (time <= -1) {
                onEnd()
                stop()
            }
        }

        onStart()
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Plugin.instance, task, delay, interval)
    }

    fun pause() {
        Bukkit.getScheduler().cancelTask(taskID)
        taskID = 0
    }

    fun stop() {
        time = -1
        pause()
    }
}
*/