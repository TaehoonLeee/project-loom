package com.example.project.loom.maven

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main() {
    val executors = Executors.newVirtualThreadPerTaskExecutor()
    val future = executors.submit(Callable {
        Thread.sleep(1000)
        "Project Loom"
    })
    runBlocking {
        val job = async {
            delay(1000)
            "Coroutine"
        }
        println(job.await())
        job.join()
    }
    println(future.get())
}