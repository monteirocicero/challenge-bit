package com.orecic

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.orecic")
		.start()
}

