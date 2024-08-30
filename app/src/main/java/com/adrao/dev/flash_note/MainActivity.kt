package com.adrao.dev.flash_note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.adrao.dev.flash_note.core.domain.ui.RootNavHost
import com.adrao.dev.flash_note.core.ui.theme.Flash_noteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Flash_noteTheme {
                val rootNavController = rememberNavController()
                RootNavHost(rootNavHostController = rootNavController)
            }
        }
    }
}