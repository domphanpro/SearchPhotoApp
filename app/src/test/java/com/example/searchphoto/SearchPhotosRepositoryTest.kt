package com.example.searchphoto

import com.example.core.model.DataState
import com.example.core.repository.consultation.model.ResultResponse
import com.example.core.repository.consultation.model.SearchPhotosResponse
import com.example.core.repository.consultation.model.UrlsPhotoResponse
import com.example.core.repository.consultation.repository.SearchPhotosRepository
import com.example.core.repository.consultation.repository.SearchPhotosRepositoryImpl
import com.example.core.repository.consultation.service.RetrofitConsultationService
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import junitparams.JUnitParamsRunner
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(JUnitParamsRunner::class)
class SearchPhotosRepositoryTest {

    private lateinit var repository: SearchPhotosRepository
    private lateinit var consultationService: RetrofitConsultationService


    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun init() {
        MockKAnnotations.init(this)
        consultationService = mockk(relaxed = true)
        repository = SearchPhotosRepositoryImpl(consultationService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
        unmockkAll()
    }

    @Test
    fun test() {
        val searchResponse = SearchPhotosResponse(
            results = listOf(
                ResultResponse(
                    alt_description = "alt_description",
                    description = "description",
                    created_at = "18/08/19",
                    id = "1",
                    urls = UrlsPhotoResponse(
                        full = "",
                        raw = "",
                        regular = "",
                        small = "",
                        thumb = ""
                    )
                )
            ), total = 0, total_pages = 0
        )

        coEvery { consultationService.getPhotosSearch(query = "voiture") } returns searchResponse
        mainCoroutineRule.testDispatcher.runBlockingTest {
            repository.getPhotosSearch("voiture").collectIndexed { index, value ->
                when (index) {
                    0 -> assert(value is DataState.Loading)
                    1 -> assert(value is DataState.Success)
                }
            }

        }

    }

}