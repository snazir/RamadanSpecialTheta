package theta.ramadan.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_room.*
import theta.ramadan.database.entity.Employee
import theta.ramadan.viewmodels.RoomViewModel

class RoomActivity : AppCompatActivity() {

    // Room Database, MVVM (Model, View, ViewModel)
    //MVC > MVP > MVVM
    // ViewModel
    // LiveData


    lateinit var roomViewModel: RoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)


        //Initialization
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel::class.java)


        floatingButton.setOnClickListener {
            // Add Employee
            addEmployee()
            //   roomViewModel.deleteEmployee(employee)
        }


        roomViewModel.employeeList?.observe(this, Observer {
            employeeCount.text =employeeCount.text.toString() +  it.size
            //    adapter.addList(it)
//            EmployeeDatabase.getDatabase(this)?.employeeDao()?.provideAllEmployees()
        })

    }

    private fun deleteEmployee() {
        val employee = Employee(name = "Salman", phone = "1234342")
        roomViewModel.deleteEmployee(employee)

    }

    private fun addEmployee() {
        val employee = Employee(name = "Salman", phone = "1234342")

        roomViewModel.insertEmployeeToDatabase(employee)
    }
}
