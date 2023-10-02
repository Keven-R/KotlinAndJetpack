package com.edu.curtin.kotlinandjetpack.viewmodel

sealed class ExampleEvent{
    object TempEvent: ExampleEvent()
    data class TempEventPrams(val pos: Int): ExampleEvent()
}
