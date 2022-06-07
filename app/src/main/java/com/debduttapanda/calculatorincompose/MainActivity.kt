package com.debduttapanda.calculatorincompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.debduttapanda.calculatorincompose.ui.theme.CalculatorInComposeTheme

class MainActivity : ComponentActivity() {
    val textValue = mutableStateOf("")
    val resultValue = mutableStateOf("Result")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorInComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    Column {
                        TextField(
                            value = textValue.value,
                            onValueChange = {
                                textValue.value = it
                            },
                            label = {
                                Text("Label")
                            },
                            placeholder = {
                                Text("Hint")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                        Button(onClick = {
                            if(textValue.value.isNotEmpty()){
                                try {
                                    resultValue.value = (textValue.value.toInt()*2).toString()
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Bad Input", Toast.LENGTH_SHORT).show()
                                }
                            }
                            else{
                                Toast.makeText(context, "Bad Input", Toast.LENGTH_SHORT).show()
                            }
                        }) {
                            Text("Click Me")
                        }
                        Text(resultValue.value)
                    }
                }
            }
        }
    }
}