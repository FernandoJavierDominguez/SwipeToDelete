package com.fernandodominguezpacheco.reign.framework

import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.Refresh
import com.fernandodominguezpacheco.reign.framework.db.Story as RoomStory
import com.fernandodominguezpacheco.reign.framework.server.Story as ServerStory
import com.fernandodominguezpacheco.reign.framework.db.Refresh as RoomRefresh

fun Story.toRoomStory(): RoomStory = RoomStory(
    id,
    story_title,
    author,
    story_url,
    created_at
)

fun RoomStory.toStory(): Story = Story(
    id,
    story_title,
    author,
    story_url,
    created_at
)

fun ServerStory.toStory() : Story = Story(
    0,
    story_title,
    author,
    story_url,
    created_at

)

fun Refresh.toRoomRefresh(): RoomRefresh = RoomRefresh(
    id,
    date_refresh
)

fun RoomRefresh.toRefresh() : Refresh = Refresh(
    id,
    date_refresh
)

