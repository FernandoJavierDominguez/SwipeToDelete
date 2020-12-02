package com.fernandodominguezpacheco.reign

import java.util.*

data class Story (
    var id: Int = 0,
    var story_title : String? = "",
    var author:  String? = "",
    var story_url : String? = "",
    var created_at : Date = Date()
){
}