package com.example.kuit7_android.ui.contact.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun textFieldEx() {

    var textState by remember { mutableStateOf("") }//state저장 변수
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            MyTextField(
                value = textState,//새로운 상태가 하위로 전달됨
                onValueChange = { textState = it }//자식에서 받은값으로 textstate바뀜->리컴포지션
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "현재 입력값: " + textState)
        }
    }
}
@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,//입력된 값이 부모로 올라감
        label = { Text("내용을 입력하세요") }
    )
}

@Preview(showBackground = true)
@Composable
fun textFieldPreview() {
    textFieldEx()
}