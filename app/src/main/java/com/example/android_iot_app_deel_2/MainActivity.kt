package com.example.android_iot_app_deel_2

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.android_iot_app_deel_2.ui.theme.Android_IoT_App_Deel_2Theme
import java.io.Console

class MainActivity : ComponentActivity() {

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(true)).get(MainViewModel::class.java)

        setContent {
            Android_IoT_App_Deel_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Lamp(viewModel.lamp1_on.value, {
                             viewModel.setLamp1On(it)
                             Log.d("Change lamp 1",if(it) "on" else "off")
                        })
                        Lamp()
                        Lamp()
                    }
                }
            }
        }
    }
}

@Composable
fun Lamp(on: Boolean = false, toggle: (Boolean) -> Unit = {}) {
    Card {
        Image(painter= painterResource(id = if (on) R.drawable.lamp else R.drawable.lampoff),
            contentDescription = "Lamp",
            modifier=Modifier.background(Color.Blue)
        )
        Switch(checked = on, onCheckedChange = toggle )
    }
}


@Preview(showBackground = true)
@Composable
fun LampPreview() {
    Android_IoT_App_Deel_2Theme {
        Surface(
            //modifier = Modifier.fillMaxSize(),
            //color = MaterialTheme.colorScheme.background
        ) {
           Lamp(true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Android_IoT_App_Deel_2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Lamp()
                Lamp()
                Lamp()
            }
        }
    }
}