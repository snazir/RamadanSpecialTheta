package theta.ramadan.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Employee")
data class EmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    val id: Int,

    @ColumnInfo(name = "employee_name")
    val name: String,

    @ColumnInfo(name = "employee_phone")
    val phone: String
)
