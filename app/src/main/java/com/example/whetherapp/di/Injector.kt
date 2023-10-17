package com.example.whetherapp.di

import kotlin.reflect.KClass

object Injector {

    val components : MutableMap<KClass<*>, Any> = mutableMapOf()

    inline fun <reified T> provideComponent(component : T?) {
        if(component == null) {
            this.components.remove(T::class)
        } else {
            this.components[T::class] = components as Any
        }
    }

    inline fun <reified T> of() : T {
        return this.components[T::class] as T
    }
}