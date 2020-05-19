package theta.ramadan.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_room.*
import theta.ramadan.database.dao.EmployeeDao
import theta.ramadan.database.db.EmployeeDatabase
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
            //    roomViewModel.addEmployee(employee)
            //   roomViewModel.deleteEmployee(employee)
        }


        roomViewModel.employeeList?.observe(this, Observer {
            //    adapter.addList(it)
            EmployeeDatabase.getDatabase(this)?.employeeDao()?.provideAllEmployees()
        })

    }
}
