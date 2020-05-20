package theta.ramadan.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import theta.ramadan.database.entity.Employee
import theta.repository.EmployeeRepository

class RoomViewModel(application: Application) : AndroidViewModel(application) {


    var employeeList: LiveData<List<Employee>>?
    private var employeeRepository: EmployeeRepository? = null


    init {
        employeeRepository = EmployeeRepository(application)
        employeeList = employeeRepository?.getAllEmployees()
    }


    fun insertEmployeeToDatabase(employee: Employee) {
        employeeRepository?.insertEmployee(employee)

    }

    fun deleteEmployee(employee: Employee) {
        employeeRepository?.deleteEmployee(employee)
    }
}
