import com.example.hello3.Student
import com.google.gson.annotations.SerializedName
data class LoginResponse (
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)

