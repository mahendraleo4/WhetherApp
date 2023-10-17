package com.example.whetherapp.foundation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Creates a flow that produces a single value from the return value of [action].
 */
fun <T> flowSingle(action: suspend () -> T): Flow<T> = flow { emit(action.invoke()) }
