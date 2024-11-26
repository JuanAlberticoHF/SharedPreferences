package com.juanalberticohf.practicafinal

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var guardar : Button
    private lateinit var editText: EditText
    private lateinit var sw: MaterialSwitch
    private lateinit var checkBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // bind
        guardar = findViewById(R.id.guardar)
        editText = findViewById(R.id.editText)
        sw = findViewById(R.id.switchh)
        checkBox = findViewById(R.id.checkbox)

        guardar.setOnClickListener {
            val prefs : SharedPreferences = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putBoolean("switch", sw.isChecked)
            editor.putBoolean("checkbox", checkBox.isChecked)
            editor.putString("texto", editText.text.toString())
            //editor.commit()
            editor.apply()
        }

        // Carga de datos por defecto
        val default_prefs=getSharedPreferences("preferencias", MODE_PRIVATE)
        editText.setText(default_prefs.getString("texto", "No has guardado nada"))
        checkBox.isChecked=default_prefs.getBoolean("checkbox", true)
        sw.isChecked=default_prefs.getBoolean("switch", true)
    }
}