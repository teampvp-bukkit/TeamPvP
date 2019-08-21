package com.k9rosie.teampvp.world

import org.bukkit.Location
import org.bukkit.block.BlockState
import org.bukkit.block.data.BlockData
import kotlin.math.max
import kotlin.math.min

class Region(val name: String, val regionType: RegionType, var corner1: Location?, var corner2: Location?) {
    enum class RegionType {
        BATTLEFIELD,
        INTERMISSION_GATE,
        DEATH,
        OBJECTIVE,
        BASE
    }

    data class BlockRange(val val1: Int, val val2: Int, val val3: Int)

    lateinit var blocks: Array<Pair<BlockState, BlockData>>

    fun blocks(): Array<Pair<BlockState, BlockData>> {
        val blocks = mutableListOf<Pair<BlockState, BlockData>>()
        val bukkitWorld = corner1?.world!!
        val (topX, topY, topZ) = range(corner1!!, corner2!!)
        val (botX, botY, botZ) = range(corner1!!, corner2!!, false)
        for (x in botX..topX) {
            for (y in botY..topY) {
                for (z in botZ..topZ) {
                    val block = bukkitWorld.getBlockAt(x, y, z)
                    blocks.add(Pair(block.state, block.blockData.clone()))
                }
            }
        }

        return blocks.toTypedArray()
    }

    fun save() {
        blocks = blocks()
    }

    fun revert() {
        for ((state, data) in blocks) {
            state.update(true, false)
            state.blockData = data
        }
    }

    infix fun inRegion(location: Location): Boolean {
        val x = location.blockX
        val y = location.blockY
        val z = location.blockZ
        val (topX, topY, topZ) = range(corner1!!, corner2!!)
        val (botX, botY, botZ) = range(corner1!!, corner2!!, false)

        return x in botX..topX && y in botY..topY && z in botZ..topZ
    }

    private fun range(block1: Location, block2: Location, max: Boolean = true): BlockRange {
        return BlockRange(
            if (max) max(block1.blockX, block2.blockX) else min(block1.blockX, block2.blockX),
            if (max) max(block1.blockY, block2.blockY) else min(block1.blockY, block2.blockY),
            if (max) max(block1.blockZ, block2.blockZ) else min(block1.blockZ, block2.blockZ)
        )
    }
}
