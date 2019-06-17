package com.samiroispov.cbrcurrency.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by samirosipov on 17/06/2019
 */
data class DailyResponse(
    @SerializedName("Date")
    @Expose
    var date: String?,

    @SerializedName("PreviousDate")
    @Expose
    var previousDate: String?,

    @SerializedName("PreviousURL")
    @Expose
    var previousURL: String?,

    @SerializedName("Timestamp")
    @Expose
    var timestamp: String?,

    @SerializedName("Valute")
    @Expose
    var valutes: HashMap<String, ValuteProperties>?

): Serializable


data class ValuteProperties(
    @SerializedName("ID")
    @Expose
    var id: String?,

    @SerializedName("NumCode")
    @Expose
    var numCode: String?,

    @SerializedName("CharCode")
    @Expose
    var charCode: String?,

    @SerializedName("Nominal")
    @Expose
    var nominal: Int?,

    @SerializedName("Name")
    @Expose
    var name: String?,

    @SerializedName("Value")
    @Expose
    var value: Double?,

    @SerializedName("Previous")
    @Expose
    var previous: Double?
): Serializable
