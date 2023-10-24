package com.hnq40.myapplication.tuan5

import android.content.Context
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import java.util.Queue

class VolleyKotlinFn {
    var strJSON = ""
    fun getData(context: Context?, textView: TextView?)
    {
        val queue = Volley.newRequestQueue(context)
        val url = "https://batdongsanabc.000webhostapp.com/thanglong/array_json_new.json";
        val request = JsonArrayRequest(url,
            {res->
            for (i in 0..res.length())
            {
                try {
                    val person = res.getJSONObject(i)
                    val id = person.getString("id")
                    val  name = person.getString("name")
                    val email = person.getString("email")
                    strJSON+= "Id: $id\n"
                    strJSON+= "Name: $name\n"
                    strJSON+= "Email: $email\n"
                }

                catch (e: JSONException)
                {
                    e.printStackTrace()
                }

            }
            textView!!.text = strJSON
        },
            { error->textView!!.text = error.message})
    }
}