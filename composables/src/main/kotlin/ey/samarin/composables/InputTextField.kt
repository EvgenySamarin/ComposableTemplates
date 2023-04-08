package ey.samarin.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

//region Preview samples
class InputTextFieldUIProvider : PreviewParameterProvider<InputTextFieldUI> {
    override val values = sequenceOf(
        InputTextFieldUI(
            text = "",
            placeHolderText = "Placeholder"
        ),
        InputTextFieldUI(
            text = "Short text",
        ),
        InputTextFieldUI(
            text = "Text disabled",
            enabled = false,
        ),
        InputTextFieldUI(
            text = "With clear text mode",
            clearTextModeOn = true,
        ),
        InputTextFieldUI(
            text = "",
            placeHolderText = "Placeholder with very long very long very long text",
        ),
        InputTextFieldUI(
            text = "Very long long long long long long long long long long long long long long long text",
        ),
        InputTextFieldUI(
            text = "Text with error",
            hasError = true,
            errorText = "Error text",
        ),
        InputTextFieldUI(
            text = "Password",
            type = InputType.PASSWORD,
        ),
    )
}
//endregion

enum class InputType {
    TEXT, PASSWORD
}

data class InputTextFieldUI(
    val text: String,
    val placeHolderText: String = "",
    val hasError: Boolean = false,
    val errorText: String? = null,
    val clearTextModeOn: Boolean = false,
    val enabled: Boolean = true,
    val type: InputType = InputType.TEXT,
)


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun InputTextField(
    @PreviewParameter(InputTextFieldUIProvider::class) uiData: InputTextFieldUI,
    modifier: Modifier = Modifier,
    onValueChange: (TextFieldValue) -> Unit = {},
) {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(uiData.text))
    }

    val focusManager = LocalFocusManager.current
    val isClearTextMode = uiData.enabled
            && uiData.clearTextModeOn
            && text.text.isNotEmpty()

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            placeholder = {
                Text(
                    text = uiData.placeHolderText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            enabled = uiData.enabled,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = when (uiData.type) {
                    InputType.TEXT -> ImeAction.Next
                    InputType.PASSWORD -> ImeAction.Done
                }
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            visualTransformation = when (uiData.type) {
                InputType.TEXT -> VisualTransformation.None
                InputType.PASSWORD -> PasswordVisualTransformation()
            },
            isError = uiData.hasError,
            onValueChange = { textValue ->
                text = textValue
                onValueChange(textValue)
            },
            trailingIcon = if (isClearTextMode) {
                {
                    Icon(
                        modifier = Modifier.clickable {
                            text = TextFieldValue("")
                        },
                        painter = painterResource(android.R.drawable.ic_menu_close_clear_cancel),
                        contentDescription = "clear text",
                    )
                }
            } else null,
        )
        if (uiData.hasError && !uiData.errorText.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = uiData.errorText,
                color = Color.Red,
            )
        }
    }
}