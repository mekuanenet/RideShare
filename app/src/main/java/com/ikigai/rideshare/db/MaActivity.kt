/*
package com.ikigai.rideshare.db

class MainActivity : AppCompatActivity() {
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null
    var buttonLogin: Button? = null
    var textViewRegister: TextView? = null
    var db: UserDao? = null
    var dataBase: UserDataBase? = null
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)
        dataBase = Room.databaseBuilder(this, UserDataBase::class.java, "mi-database.db")
            .allowMainThreadQueries()
            .build()
        db = dataBase!!.userDao
        textViewRegister.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            }
        })
        buttonLogin.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                val email: String = editTextEmail.getText().toString().trim()
                val password: String = editTextPassword.getText().toString().trim()
                val user = db!!.getUser(email, password)
                if (user != null) {
                    val i = Intent(this@MainActivity, HomeActivity::class.java)
                    i.putExtra("User", user)
                    startActivity(i)
                    finish()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Unregistered user, or incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}*/
