package ru.example.studentdatastore

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun LifecycleOwner.launchWhenCreated(block: suspend CoroutineScope.() -> Unit): Job =
    lifecycleScope.launchWhenCreated(block)

inline fun <T>Flow<T>.collectOnCreate(owner: LifecycleOwner, crossinline action: suspend (value: T) -> Unit) {
    owner.launchWhenCreated { collect(action) }
}