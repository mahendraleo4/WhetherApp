package com.example.whetherapp.foundation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<Input, Output> {

  /**
   * Implement this method to build your use case Flowable.
   */
  protected abstract fun onBuild(params: Input): Flow<Output>

  /**
   * Returns the default background scheduler where the Flowable will be
   * executed in. By default, this is setDeviceId to [Dispatchers.IO] unless overwritten.
   */
  protected fun defaultBackgroundScheduler() = Dispatchers.IO

  /**
   * Builds the use case using the default dispatcher.
   */
  fun build(params: Input): Flow<Output> = flow { emitAll(onBuild(params)) }
    .flowOn(defaultBackgroundScheduler())
}