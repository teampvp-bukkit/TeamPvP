/* thank you to whoever wrote this article: https://nvbn.github.io/2016/04/28/kotlin-events/ */

package com.k9rosie.teampvp.events

open class Event<T> {
    private val handlers = mutableListOf<(T) -> Unit>()

    infix fun on(handler: (T) -> Unit) = handlers.add(handler)

    fun emit(event: T) {
        for (subscriber in handlers) {
            subscriber(event)
        }
    }
}