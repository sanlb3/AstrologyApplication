package api

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.astrologyapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Call : AppCompatActivity(){

// IDK WHAT IM DOING

    suspend fun getPredictions(view: android.view.View) {
    try {
        val result = GlobalScope.async {
            callAztroAPI("https://sameer-kumar-aztro-v1.p.rapidapi.com/?sign=" + horoscopeName + "&day=today")
        }.await()
        onResponse(result)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
    private fun callAztroAPI(apiUrl:String ):String?{
        var result: String? = ""
        val url: URL;
        var connection: HttpURLConnection? = null
        try {
            url = URL(apiUrl)
            connection = url.openConnection() as HttpURLConnection
            // set headers for the request
            // set host name
            connection.setRequestProperty("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
            // set the rapid-api key
            connection.setRequestProperty("x-rapidapi-key", "<key here>")
            connection.setRequestProperty("content-type", "application/x-www-form-urlencoded")
            // set the request method - POST
            connection.requestMethod = "POST"
            val `in` = connection.inputStream
            val reader = InputStreamReader(`in`)
            // read the response data
            var data = reader.read()
            while (data != -1) {
                val current = data.toChar()
                result += current
                data = reader.read()
            }
            return result
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // if not able to retrieve data return null
        return null
    }

    private fun onResponse(result: String?) {
        try {
            // convert the string to JSON object for better reading
            val resultJson = JSONObject(result)
            // Initialize prediction text
            var prediction ="Today's prediction nn"
            prediction += this.horoscopeName+"n"
            // Update text with various fields from response
            prediction += resultJson.getString("date_range")+"nn"
            prediction += resultJson.getString("description")
            //Update the prediction to the view
            setContentView(R.layout.activity_prediction)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun setText(text: TextView?, value: String) {
        runOnUiThread { text!!.text = value }
    }
}