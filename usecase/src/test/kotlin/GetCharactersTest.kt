import com.test.data.repository.MarvelRepository
import com.test.usecase.GetCharacters
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersTest {

    @Mock
    lateinit var marvelRepository: MarvelRepository

    lateinit var getCharacters: GetCharacters

    @Before
    fun setUp() {
        getCharacters = GetCharacters(marvelRepository)
    }

    @Test
    fun `Confirm if getRemoteCharacters gets characters from API`(): Unit = runBlocking {
        whenever(marvelRepository.suspenCharacters(0)).thenReturn(mockedResponse.data.results)
        val result = getCharacters.invoke(0)
        assertEquals(result, mockedResponse.data.results)
    }

}