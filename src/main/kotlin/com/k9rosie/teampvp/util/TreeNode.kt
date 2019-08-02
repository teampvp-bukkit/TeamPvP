package com.k9rosie.teampvp.util

class TreeNode<T>(var value: T, var parent: TreeNode<T>? = null) {
    var children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node: TreeNode<T>): TreeNode<T> {
        children.add(node)
        node.parent = this
        return this
    }

    fun isLeaf(): Boolean {
        return children.size == 0
    }
}