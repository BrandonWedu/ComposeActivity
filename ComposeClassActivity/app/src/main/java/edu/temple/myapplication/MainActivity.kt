package edu.temple.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpForm("Android")
                }
            }
        }
    }
}

@Composable
fun SignUpForm(name: String, modifier: Modifier = Modifier) {
Column (horizontalAlignment = Alignment.CenterHorizontally) {

    var userName by rememberSaveable { mutableStateOf("")}
    var email by rememberSaveable { mutableStateOf("")}
    var age by rememberSaveable { mutableStateOf("")}
    Text(
        text = "Sign Up Form",
        modifier = modifier,
        fontSize = 28.sp
    )

    TextField(
        value= userName,
        onValueChange = { userName = it },
        label = {Text("Name")}
    )

    TextField(
        value= email,
        onValueChange = { email = it },
        label = {Text("Email")}
    )

    TextField(
        value= age,
        onValueChange = { age = it },
        label = {Text("Age")}
    )
    Button(onClick = {
        var message: String
        if (name != "")
            message = "Thank you for signing up"
        else
            message = "Please complete the form"
    }){
        Text("Save")
    }


}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        SignUpForm("Android")
    }
}