package pm.example.alarme

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pm.example.alarme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var pendingIntent: PendingIntent
    private lateinit var alarmManager: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.timePicker.setIs24HourView(true)
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, alarmManager::class.java)
        binding.bottomNavigationView.setOnItemSelectedListener { item -> when(item.itemId){
            R.id.repetir  -> repeat()
            R.id.definir -> setAlarm()
            R.id.cancelar -> cancelAlarm()
        }
            false
        }

    }

    fun repeat(){
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            (1000*60).toLong(),
            pendingIntent
        )
        Toast.makeText(this, "repetir Alarm", Toast.LENGTH_SHORT).show()

    }
    fun setAlarm(){
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, binding.timePicker.getHour())
            set(Calendar.MINUTE, binding.timePicker.getMinute())
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND,0)
        }
  alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,pendingIntent)
        val msg = "%02d" .format(calendar[Calendar.HOUR_OF_DAY])+":" + "%02d".format(calendar[Calendar.MINUTE])
        Toast.makeText(this,"Alarme definido para as $msg", Toast.LENGTH_SHORT).show()
    }
    fun cancelAlarm(){
        alarmManager.cancel(pendingIntent)
        Toast.makeText(this, "Alarme cancelado", Toast.LENGTH_SHORT).show()
    }
}