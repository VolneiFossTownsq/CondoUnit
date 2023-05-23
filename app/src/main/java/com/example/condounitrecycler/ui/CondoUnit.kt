package com.example.condounitrecycler.ui

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class CondoUnit(
    val id: String,
    val unitName: String,
    val unitDescription: String,
    val unitPicture: String
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(unitName)
        dest.writeString(unitDescription)
        dest.writeString(unitPicture)
    }

    companion object CREATOR : Parcelable.Creator<CondoUnit> {
        override fun createFromParcel(parcel: Parcel): CondoUnit {
            return CondoUnit(parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString())
        }

        override fun newArray(size: Int): Array<CondoUnit?> {
            return arrayOfNulls(size)
        }
    }
}
