package com.rockstar.real

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rockstar.real.ui.theme.RealTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
//Main Activity of Transit Tracker
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting("TransitTracker")
            }
        }
    }
}
//Sample Data for lazy coloumn
data class Data(val source: String, val destination: String, var body: Float, var isClicked: Boolean = false)
object SampleData {
    // Sample conversation data
    val Sample_1 = listOf(
        Data("A", "B", 10.0f),
        Data("B", "C", 11.0f),
        Data("C", "D", 12.0f),
        Data("D", "E", 13.0f),
        Data("E", "F", 13.0f),
        Data("F", "I", 16.0f),
        Data("I", "J", 16.0f),
        Data("J", "K", 17.0f),
        Data("K", "L", 18.0f),
        Data("L", "M", 19.0f),
        Data("M", "N", 20.0f),
        Data("N", "O", 21.0f),
        Data("O", "P", 22.0f),
        Data("P", "Q", 23.0f),
        Data("Q", "R", 23.0f)
    )
}
//Sample Data for Ordinary coloumn
object SampleData_2 {
    // Sample conversation data
    val Sample_2 = listOf(
        Data("A", "B", 10.0f),
        Data("B", "C", 11.0f),
        Data("C", "D", 12.0f),
        Data("D", "E", 13.0f),
        Data("E", "F", 13.0f),
        Data("F", "I", 16.0f),
        Data("I", "J", 16.0f),
        Data("J", "K", 17.0f),
        Data("K", "L", 18.0f),
        Data("L", "M", 19.0f)
    )
}
@Composable
fun MessageCard(msg: Data, isKm: Boolean) {
    //checking if distance is reached makes distance green
    val textColor = if (msg.isClicked) {
        if (msg.body > 0) {
            Color.Green
        } else {
            Color.Red
        }
    } else {
        MaterialTheme.colorScheme.primary
    }

    Row(
        //Aligning data vertically
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = msg.source,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .width(120.dp)
                .padding(start = 40.dp),
            fontSize = 20.sp,
            fontFamily= FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = msg.destination,
            color = Color.Blue,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .width(120.dp)
                .padding(start = 35.dp),
            fontSize = 20.sp,
            fontFamily= FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "${msg.body} ${if (isKm) "km" else "miles"}",
            color = textColor, // Use textColor here
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 16.sp,
            fontFamily= FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
@Composable
fun Conversation(messages: List<Data>, isKm: Boolean) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message, isKm)
        }
    }
}
@Composable
fun OrdinaryColumn(messages: List<Data>, isKm: Boolean) {
    Column {
        messages.forEach { message ->
            MessageCard(message, isKm)
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var distanceKm by remember { mutableStateOf(0.0f) }
    var distanceMiles by remember { mutableStateOf(0.0f) }
    var totalDistance by remember { mutableStateOf(0.0f) }
    var progress by remember { mutableStateOf(0.0f) }
    var distanceKm_1 by remember { mutableStateOf(0.0f) }
    var distanceMiles_1 by remember { mutableStateOf(0.0f) }
    var totalDistance_1 by remember { mutableStateOf(0.0f) }
    var progress_1 by remember { mutableStateOf(0.0f) }
    var isKm by remember { mutableStateOf(true) }
    var isKm_1 by remember { mutableStateOf(true) }
    var buttonText by remember { mutableStateOf("Convert") }
    var currentIndex by remember { mutableStateOf(0) }
    var currentIndex_1 by remember { mutableStateOf(0) }
    var showLazyColumn by remember { mutableStateOf(true) }
    totalDistance = SampleData.Sample_1.sumByDouble { it.body.toDouble() }.toFloat()
    totalDistance_1 = SampleData_2.Sample_2.sumByDouble { it.body.toDouble() }.toFloat()
    Column{
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome to $name",
            modifier = modifier
                .padding(start = 60.dp),
            color=Color.Red,
            fontSize = 20.sp,
            fontFamily= FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold

        )
        Spacer(modifier = Modifier.height(20.dp))
        if(showLazyColumn){
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(8.dp),
                color = Color.Cyan
            )

        }
        else{
            LinearProgressIndicator(
                progress = progress_1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(8.dp),
                color = Color.Cyan
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "DISTANCE COVERED",
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 20.dp),
                color=Color.Blue,
                fontFamily= FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.width(40.dp))
            if(showLazyColumn){
                val tc = if (distanceKm==totalDistance) {
                    Color.Cyan
                }
                else {
                    if (distanceKm==0.0f) {
                        Color.Red
                    } else {
                        Color.Green
                    }
                }
                Text(
                    text = "${if (isKm) distanceKm else distanceMiles} ${if (isKm) "km" else "miles"}",
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontSize = 16.sp,
                    fontFamily= FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    color=tc
                )}
            else{
                val tc = if (distanceKm_1==totalDistance_1) {
                    Color.Cyan
                }
                else {
                    if (distanceKm_1==0.0f) {
                        Color.Red
                    } else {
                        Color.Green
                    }
                }
                Text(
                    text = "${if (isKm_1) distanceKm_1 else distanceMiles_1} ${if (isKm_1) "km" else "miles"}",
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontSize = 16.sp,
                    fontFamily= FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    color=tc
                )

            }
        }

        Row {
            Text(
                text = "DISTANCE LEFT",
                modifier = Modifier

                    .padding(horizontal = 20.dp),
                color=Color.Blue,
                fontFamily= FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.width(70.dp))
            if(showLazyColumn) {
                val remainingDistance = totalDistance - distanceKm.toFloat() // Distance left in kilometers
                val remainingDistance_miles = totalDistance - distanceMiles.toFloat() // Distance left in kilometers
                val tc = if (remainingDistance == totalDistance) {
                    Color.Cyan
                } else {
                    if (remainingDistance == 0.0f) {
                        Color.Red
                    } else {
                        Color.Magenta
                    }
                }
                Text(
                    text = "${if (isKm) remainingDistance else remainingDistance_miles} ${if (isKm) "km" else "miles"}",
                    fontSize = 16.sp,
                    fontFamily= FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    color=tc
                )
            }
            else{
                val remainingDistance_1 =
                    totalDistance_1 - distanceKm_1.toFloat() // Distance left in kilometers
                val remainingDistance_miles_1 =
                    totalDistance_1 - distanceMiles_1.toFloat() // Distance left in kilometers
                val tc = if (remainingDistance_1 == totalDistance_1) {
                    Color.Cyan
                } else {
                    if (remainingDistance_1 == 0.0f) {
                        Color.Red
                    } else {
                        Color.Magenta
                    }
                }
                Text(
                    text = "${if (isKm_1) remainingDistance_1 else remainingDistance_miles_1} ${if (isKm_1) "km" else "miles"}",
                    fontSize = 16.sp,
                    fontFamily= FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    color=tc
                )

            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Button(
            onClick = { showLazyColumn = !showLazyColumn },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 10.dp)
                .width(250.dp)
                .height(48.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = if (showLazyColumn) "Switch to Ordinary Column" else "Switch to Lazy Column")
        }

        Row{
            Button(
                onClick = {
                    if(showLazyColumn){
                        isKm = !isKm
                        buttonText = if (isKm) "Convert to Miles" else "Convert to Kilometers"

                        SampleData.Sample_1.forEach { data ->
                            if (isKm) {
                                data.body = convertMilesToKm(data.body)
                            } else {
                                data.body = convertKmToMiles(data.body)
                            }
                        }

                    }
                    else{
                        isKm_1 = !isKm_1
                        buttonText = if (isKm_1) "Convert to Miles" else "Convert to Kilometers"

                        SampleData_2.Sample_2.forEach { data ->
                            if (isKm_1) {
                                data.body = convertMilesToKm(data.body)
                            } else {
                                data.body = convertKmToMiles(data.body)
                            }
                        }

                    }

                },
                modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(horizontal = 20.dp)
                    .height(40.dp)
                    .width(120.dp),
                enabled = true,
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor =  Color.Blue, contentColor = Color.White)
            ) {
                Text(text = "CONVERT")
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    if (currentIndex < SampleData.Sample_1.size && showLazyColumn) {
                        SampleData.Sample_1[currentIndex].isClicked = true
                        val distance = SampleData.Sample_1[currentIndex].body
                        val convertedDistance_k = if (isKm) distance else convertMilesToKm(distance)
                        val convertedDistance_m = if (isKm) convertKmToMiles(distance) else distance
                        distanceKm += convertedDistance_k
                        distanceMiles += convertedDistance_m
                        currentIndex++
                        if(isKm){
                            progress = distanceKm / totalDistance

                        }
                        else{
                            progress = distanceMiles /  totalDistance

                        }

                        if (progress > 1.0f) {
                            progress = 1.0f
                        }
                    }
                    else{
                        SampleData_2.Sample_2[currentIndex_1].isClicked = true
                        val distance_1 = SampleData_2.Sample_2[currentIndex_1].body
                        val convertedDistance_k = if (isKm_1) distance_1 else convertMilesToKm(distance_1)
                        val convertedDistance_m = if (isKm_1) convertKmToMiles(distance_1) else distance_1
                        distanceKm_1 += convertedDistance_k
                        distanceMiles_1 += convertedDistance_m
                        currentIndex_1++
                        if(isKm_1){
                            progress_1 = distanceKm_1 / totalDistance_1

                        }
                        else{
                            progress_1 = distanceMiles_1 /  totalDistance_1

                        }

                        if (progress_1 > 1.0f) {
                            progress_1 = 1.0f
                        }
                    }

                }
                ,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(40.dp)
                    .width(120.dp),
                enabled = true,
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor =  Color.Blue, contentColor = Color.White)
            ) {
                Text(text = "+STOP")
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Row{
            Text(
                text = "SOURCE",
                modifier =
                Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 20.dp),
                color=Color.Magenta,
                fontFamily= FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold

            )

            Text(
                text = "DESTINATION",
                modifier = Modifier.padding(bottom = 8.dp),
                color=Color.Magenta,
                fontFamily= FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "DISTANCE",
                modifier = Modifier.padding(bottom = 8.dp),
                color=Color.Magenta,
                fontFamily= FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        if (showLazyColumn) {
            Conversation(messages = SampleData.Sample_1, isKm = isKm)
        } else {
            OrdinaryColumn(messages = SampleData_2.Sample_2, isKm = isKm_1)
        }
     }
}
private fun convertMilesToKm(miles: Float): Float {
    // Converting  miles to kilometers
    return miles / 0.621371f
}

private fun convertKmToMiles(km: Float): Float {
    // Converting kilometers to miles
    return km * 0.621371f
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RealTheme {
        Greeting("TravelTransit")
    }
}








