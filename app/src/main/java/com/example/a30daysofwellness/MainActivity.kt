package com.example.a30daysofwellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofwellness.model.Day
import com.example.a30daysofwellness.model.Days.dayss
import com.example.a30daysofwellness.ui.theme._30DaysOfWellnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfWellnessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DaysOfWellnessApp()
                }
            }
        }
    }
}

@Composable
fun DaysOfWellnessApp()  {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            wellnessAppBar()
        }

    )
    { it ->
        LazyColumn(contentPadding = it  ) {
            items(dayss) {
                dayitem(
                    day = it,
                    modifier = Modifier .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun wellnessAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun dayitem(
    day: Day,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .clickable { expanded = !expanded }

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)

        ) {
            Column(modifier = Modifier.weight(1f)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium))) {
            daynumber(day.daynumber)
            daytitle(day.title)
            dayImage(day.imageRes)
                if (expanded) {
                    daydescription(day.descriptionRes)
                }
        }
        }
    }
}
@Composable
fun dayImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.FillWidth,
        painter = painterResource(imageRes),
        contentDescription = null
    )
}
@Composable
fun daytitle(
    @StringRes Supername: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Supername),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier .padding(top = 8.dp)
        )

    }
}
@Composable
fun daynumber(
    @StringRes daynumber: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(daynumber),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier

        )

    }
}
@Composable
fun daydescription(
    @StringRes daydescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(daydescription),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DaysPreview() {
    _30DaysOfWellnessTheme(darkTheme = false) {
        DaysOfWellnessApp()

    }
}