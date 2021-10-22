import com.test.data.repository.MarvelRepository
import com.test.data.source.RemoteDataSource
import com.test.domain.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class MarvelRepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    private val mockedItemData = ItemData(
        "Name",
        "ResourceURI",
        "Type"
    )

    private val mockedSubData = SubData(
        "Available",
        "CollectionURI",
        listOf(mockedItemData),
        "Returned"
    )


    private val mockedCharacter = CharacterResult(
        id = 1011334,
        name = "3-D Man",
        description = "He loves 3-D movies!",
        "Modified",
        "ResourceURI",
        thumbnail = Thumbnail(
            path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
            extension = "jpg"
        ),
        mockedSubData
    )

    private val mockedCharacterData = Data(
        20,
        20,
        0,
        listOf(mockedCharacter),
        20
    )


    private val mockedResponse = ResponseCharacters(
        code = 200,
        status = "Ok",
        mockedCharacterData
    )

    lateinit var marvelRepository: MarvelRepository

    @Before
    fun setUp() {
        marvelRepository = MarvelRepository(remoteDataSource)
    }

    @Test
    fun `Confirm if getRemoteCharacters gets characters from API`(): Unit = runBlocking {
        whenever(remoteDataSource.getCaharcters(0)).thenReturn(mockedResponse.data.results)
        val result = marvelRepository.suspenCharacters(0)
        assertEquals(mockedResponse.data.results, result)
    }

    @Test
    fun `Confirm if getDetailsCharacterById retrieves a character from the Api`(): Unit =
        runBlocking {
            whenever(remoteDataSource.getDetails(6)).thenReturn(mockedCharacter)
            val result = marvelRepository.suspendDetails(6)
            assertEquals(mockedCharacter, result)
        }

}
