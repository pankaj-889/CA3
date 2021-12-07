package com.example.ca3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val imageView : ImageView = findViewById(R.id.image)

        registerForContextMenu(imageView)

        val months = arrayOf<String?>("Select","below 18","18-30","31-50","above 60")
        val arrayadapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,months)
        val spin : Spinner = findViewById(R.id.spinner2)
        val button : Button = findViewById(R.id.button)
        var name:EditText = findViewById(R.id.editTextTextPersonName)
        button.setOnClickListener {
            val nameVal = name.text.toString().trim()
            if(nameVal==""){
                name.setError("Please provide the name")
            }else{
                var checkBoxVal1 = ""
                var checkBoxVal2 = ""
                val Checkbox1 : CheckBox = findViewById(R.id.Checkbox1)
                val Checkbox2 : CheckBox = findViewById(R.id.Checkbox2)
                if(Checkbox1.isChecked){
                    checkBoxVal1 += "Hindi"
                }
                if(Checkbox2.isChecked){
                    checkBoxVal2 += "English"
                }
                val radio_Group : RadioGroup = findViewById(R.id.radio_Group)
                val radio1 : RadioButton = findViewById(R.id.Radio1)
                val radio2 : RadioButton = findViewById(R.id.Radio2)
                var radioVal = ""
                radio_Group.setOnCheckedChangeListener{
                    _, selected_id ->
                    val radioBtn : RadioButton = findViewById(selected_id)
                    when(radioBtn){
                        radio1->{
                            radioVal="Male"
                        }
                        radio2->{
                            radioVal="Female"
                        }
                    }
                }

                val spinnerVal = spin.selectedItem.toString()
                val intent = Intent(this@MainActivity, Print::class.java)
                intent.putExtra("nameVal", nameVal)
                intent.putExtra("checkBoxVal1", checkBoxVal1)
                intent.putExtra("checkBoxVal2", checkBoxVal2)
                intent.putExtra("radioVal", radioVal)
                intent.putExtra("spinnerVal", spinnerVal)
                startActivity(intent)
            }
        }
        spin.adapter = arrayadapter
        spin.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                  spin.setSelection(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1->{
                finish()
                return true
            }
            R.id.item2->{
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"download this app")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent,"share"))
                return true
            }
        }
        return false

    }
}
