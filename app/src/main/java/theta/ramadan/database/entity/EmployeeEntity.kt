package theta.ramadan.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Employee")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    var id: Int = 0,

    @ColumnInfo(name = "employee_name")
    var name: String,

    @ColumnInfo(name = "employee_phone")
    var phone: String
) : Serializable
//{
//
//
//   fun toEmployee() {
//       Employee(id, name, phone)
//   }
//}
