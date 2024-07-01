package com.alpermelkeli.registerscreencompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldValidation(
    type: String,
    leadingIconVector: ImageVector,
    text: String,
    onValueChange: (String) -> Unit,
    isValid: MutableState<Boolean>,
    isPrivate:Boolean
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
        value = text,
        textStyle = TextStyle.Default.copy(color = Color.White, fontSize = 12.sp),
        visualTransformation = if(isPrivate) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = type, fontSize = 12.sp, fontFamily = FontFamily.SansSerif) },
        trailingIcon = {
            if (isValid.value) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
            } else {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        },
        leadingIcon = { Icon(imageVector = leadingIconVector, contentDescription = null) }
    )
}
