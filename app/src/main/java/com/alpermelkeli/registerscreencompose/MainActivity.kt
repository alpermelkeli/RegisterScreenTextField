package com.alpermelkeli.registerscreencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alpermelkeli.registerscreencompose.ui.theme.RegisterScreenComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterScreenComposeTheme {
                MainScreen()
            }
        }
    }

}

@Composable
fun MainScreen() {
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    val phoneNumberText = remember { mutableStateOf("") }

    val isEmailValid = remember { mutableStateOf(false) }
    val isPasswordValid = remember { mutableStateOf(false) }
    val isPhoneNumberValid = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldValidation(
            type = "E-mail",
            leadingIconVector = Icons.Default.Email,
            text = emailText.value,
            onValueChange = {
                emailText.value = it
                isEmailValid.value = isEmailValid(it)
            },
            isValid = isEmailValid,
            isPrivate = false
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextFieldValidation(
            type = "Password",
            leadingIconVector = Icons.Default.Lock,
            text = passwordText.value,
            onValueChange = {
                passwordText.value = it
                isPasswordValid.value = isPasswordValid(it)
            },
            isValid = isPasswordValid,
            isPrivate = true
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextFieldValidation(
            type = "Phone Number",
            leadingIconVector = Icons.Default.Phone,
            text = phoneNumberText.value,
            onValueChange = {
                phoneNumberText.value = it
                isPhoneNumberValid.value = isPhoneNumberValid(it)
            },
            isValid = isPhoneNumberValid,
            isPrivate = false
        )

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                println("Register clicked!")
            },
            enabled = isEmailValid.value && isPasswordValid.value && isPhoneNumberValid.value,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text(text = "Register")
        }
    }
}



