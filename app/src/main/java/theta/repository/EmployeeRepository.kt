package theta.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import theta.ramadan.database.dao.EmployeeDao
import theta.ramadan.database.db.EmployeeDatabase
import theta.ramadan.database.entity.Employee

class EmployeeRepository(application: Application) {
    private var employeeDAO: EmployeeDao? = null
    private var employeeList: LiveData<List<Employee>>? = null


    init {
        val db = EmployeeDatabase.getDatabase(application)
        employeeDAO = db?.employeeDao()
        employeeList = employeeDAO?.provideAllEmployees()
    }


    fun getAllEmployees(): LiveData<List<Employee>>? {
        return employeeList
    }

    fun insertEmployee(employee: Employee) {
        InsertEmployeeAsyncTask(employeeDAO, employee).execute()
    }

    fun deleteEmployee(employee: Employee) {
        DeleteEmployeeAsyncTask(employeeDAO, employee).execute()

    }

    // Async Tasks (Background Thread)........
    class InsertEmployeeAsyncTask(
        private var employeeDAO: EmployeeDao?,
        private val employee: Employee
    ) :
        AsyncTask<Employee, Void, Long>() {
        override fun doInBackground(vararg params: Employee?): Long {
            // In Background......
            employeeDAO?.insertEmployee(employee)
            return 1
        }
    }

    class DeleteEmployeeAsyncTask(
        private var employeeDAO: EmployeeDao?,
        private val employee: Employee
    ) :
        AsyncTask<Employee, Void, Long>() {
        override fun doInBackground(vararg params: Employee?): Long {
            // In Background......
            employeeDAO?.deleteEmployee(employee)
            return 1
        }
    }

}
