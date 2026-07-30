package com.ayuk.tvapp.data

import com.ayuk.tvapp.data.api.TvMazeApiService
import com.ayuk.tvapp.data.model.Tvshow
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    private val api = mockk<TvMazeApiService>()

    private lateinit var repository: Repository

    @Before
    fun setup() {
        repository = Repository(api)
    }

    //test1
    @Test
    fun `getShows returns list of tv shows`() = runTest {

        val shows = listOf(
            Tvshow(
                id = 1,
                name = "Breaking Bad",
                image = null,
                rating = null,
                summary = "",
                premiered = ""
            )
        )

        coEvery { api.getShows() } returns shows

        val result = repository.getShows()

        assertEquals(shows, result)
    }

    //test2
    @Test
    fun `getShowDetail returns tv show`() = runTest {

        val show = Tvshow(
            id = 1,
            name = "Breaking Bad",
            image = null,
            rating = null,
            summary = "Summary",
            premiered = "2008-01-20"
        )

        coEvery { api.getShowDetail(1) } returns show

        val result = repository.getShowDetail(1)

        assertEquals(show, result)
    }
}