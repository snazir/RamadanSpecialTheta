package theta.ramadan.responses

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("page")
    val pageNumber: Int = 0,
    @SerializedName("data")
    val userList: ArrayList<User>
)


data class User(
    val id: Int,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)
