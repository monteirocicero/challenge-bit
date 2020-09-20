package com.orecic.domain.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty


class Order @JsonCreator
constructor(@param:JsonProperty("name") val name: String, @param:JsonProperty("code") val code: String,
            @param:JsonProperty("date") val date: String, @param:JsonProperty("dimension") val dimension: Dimension) {
}

class Dimension @JsonCreator
constructor(@param:JsonProperty("weight")  val weight: String, @param:JsonProperty("height") val height: String,
            @param:JsonProperty("width") val width: String, @param:JsonProperty("length")  val length: String) {

}