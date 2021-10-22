import com.test.domain.*

val mockedItemData = ItemData(
    "Name",
    "ResourceURI",
    "Type"
)

val mockedSubData = SubData(
    "Available",
    "CollectionURI",
    listOf(mockedItemData),
    "Returned"
)


val mockedCharacter = CharacterResult(
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

val mockedCharacterData = Data(
    20,
    20,
    0,
    listOf(mockedCharacter),
    20
)


val mockedResponse = ResponseCharacters(
    code = 200,
    status = "Ok",
    mockedCharacterData
)