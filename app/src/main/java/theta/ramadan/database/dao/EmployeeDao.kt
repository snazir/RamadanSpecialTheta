package theta.ramadan.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import theta.ramadan.database.entity.Employee

@Dao
abstract class EmployeeDao {
    // Data Access Object for EmployeeEntity

    @Insert
    abstract fun insertEmployee(employee: Employee)

    @Insert
    abstract fun insertEmployeeList(employeeList: List<Employee>)

    @Delete
    abstract fun deleteEmployee(employee: Employee)

    @Update
    abstract fun updateEmployee(employee: Employee)

    @Query("Select * From employee")
    abstract fun provideAllEmployees(): LiveData<List<Employee>>

    @Query("Select * From employee WHERE employee_id = :id ")
    abstract fun provideEmployeeById(id: Int): Employee
}
