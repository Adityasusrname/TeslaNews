package com.learning.tests

import com.learning.teslanews.TeslaNewsClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class Tests {

    @Test
    fun sampleTest() {
        assertEquals(true, true)
    }

    @Test
    fun get_articles_test() = runBlocking {
        val client = TeslaNewsClient()
        val response = client.api.get_articles()
        assertNotNull(response.articles)


    }


}


