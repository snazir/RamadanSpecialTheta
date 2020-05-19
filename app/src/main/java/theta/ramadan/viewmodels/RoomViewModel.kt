package theta.ramadan.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import theta.ramadan.models.Employee

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    var employeeList: MutableLiveData<ArrayList<Employee>>? = MutableLiveData()


}
