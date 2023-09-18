package com.aleiva.hcompose.ui.heroexplorer.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(setSearchTerm: (String) -> Unit) {
  val (term, setTerm) = remember { mutableStateOf("") }
  val keyboardController = LocalSoftwareKeyboardController.current

  OutlinedTextField (
    value = term,
    singleLine = true,
    onValueChange = { newTerm -> setTerm(newTerm) },
    placeholder = { Text(text = "Search a hero") },
    leadingIcon = { Icon(Icons.Filled.Search, "Search icon") },
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Text,
      imeAction = ImeAction.Search
    ),
    keyboardActions = KeyboardActions(
      onSearch = {
        setSearchTerm(term)
        keyboardController?.hide()
      },
    ),
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
  )
}