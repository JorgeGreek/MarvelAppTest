import com.test.data.repository.MarvelRepository
import com.test.usecase.GetDetails
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetDetailsTest {

    @Mock
    lateinit var marvelRepository: MarvelRepository

    lateinit var getDetails: GetDetails


    @Before
    fun setUp() {
        getDetails = GetDetails(marvelRepository)
    }

    @Test
    fun `Confirm if getDetailCharacterById retrieves a character from the API`(): Unit =
        runBlocking {
            whenever(marvelRepository.suspendDetails(6)).thenReturn(mockedCharacter)
            val result = getDetails.invoke(6)
            Assert.assertEquals(mockedCharacter, result)
        }
    
}