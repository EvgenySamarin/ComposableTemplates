package ey.samarin.composabletemplates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ey.samarin.composables.InputTextField
import ey.samarin.composables.InputTextFieldUI
import ey.samarin.composabletemplates.ui.theme.ComposableTemplatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableTemplatesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        InputTextField(
                            uiData = InputTextFieldUI(
                                text = "InputTextField sample",
                                clearTextModeOn = true,
                            )
                        )
                    }
                }
            }
        }
    }
}