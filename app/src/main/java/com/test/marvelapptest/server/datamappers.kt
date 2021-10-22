package com.test.marvelapptest.server

import com.test.marvelapptest.server.model.SubData as ServerSubData
import com.test.marvelapptest.server.model.Data as ServerData
import com.test.marvelapptest.server.model.ResponseCharacters as ServerResponse
import com.test.marvelapptest.server.model.Thumbnail as ServerThumbnail
import com.test.marvelapptest.server.model.CharacterResult as ServerCharacter
import com.test.marvelapptest.server.model.ItemData as ServerItemData

import com.test.domain.SubData as DomainSubData
import com.test.domain.Data as DomainData
import com.test.domain.ResponseCharacters as DomainResponse
import com.test.domain.Thumbnail as DomainThumbnail
import com.test.domain.CharacterResult as DomainCharacter
import com.test.domain.ItemData as DomainItemData


/*  Domain to Server */

fun DomainResponse.toServerResponse(): ServerResponse = ServerResponse(
    code,
    status,
    data.toServerData()
)

fun DomainData.toServerData(): ServerData = ServerData(
    count,
    limit,
    offset,
    results.map { it.toServerCharacter() },
    total
)

fun DomainCharacter.toServerCharacter(): ServerCharacter = ServerCharacter(
    id,
    name,
    description,
    modified,
    resourceURI,
    thumbnail.toServerThumbnail(),
    comics.toServerSubData()
)

fun DomainThumbnail.toServerThumbnail(): ServerThumbnail = ServerThumbnail(
    extension,
    path
)

fun DomainSubData.toServerSubData(): ServerSubData = ServerSubData(
    available,
    collectionURI,
    items.map{ it.toServerItemData() },
    returned
)

fun DomainItemData.toServerItemData(): ServerItemData = ServerItemData(
    name,
    resourceURI,
    type
)




/*  Server to Domain */

fun ServerResponse.toDomainResponse(): DomainResponse = DomainResponse(
    code,
    status,
    data.toDomainData()
)

fun ServerData.toDomainData(): DomainData = DomainData(
    count,
    limit,
    offset,
    results.map { it.toDomainCharacter() },
    total
)


fun ServerCharacter.toDomainCharacter(): DomainCharacter = DomainCharacter(
    id,
    name,
    description,
    modified,
    resourceURI,
    thumbnail.toDomainThumbnail(),
    comics.toDomainSubData()
)

fun ServerThumbnail.toDomainThumbnail(): DomainThumbnail = DomainThumbnail(
    extension,
    path
)

fun ServerSubData.toDomainSubData(): DomainSubData = DomainSubData(
    available,
    collectionURI,
    items.map { it.toDomainItemData() },
    returned
)

fun ServerItemData.toDomainItemData(): DomainItemData = DomainItemData(
    name,
    resourceURI,
    type
)

