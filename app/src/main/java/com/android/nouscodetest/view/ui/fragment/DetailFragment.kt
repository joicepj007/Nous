package com.android.nouscodetest.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.nouscodetest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import android.content.Intent

import android.net.Uri
import android.text.util.Linkify


class DetailFragment : Fragment() {

    lateinit var title: String
    lateinit var description: String
    lateinit var uri: Uri
    lateinit var url: String
            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         url = arguments?.let { DetailFragmentArgs.fromBundle(it).url }.toString()
         arguments?.getString("title")?.let {
            title = it
        }
        arguments?.getString("description")?.let {
            description = it
        }
        item_name.setText(title)
        item_description.setText(description)
        Picasso.get().load(url).into(img_preview);
         uri = Uri.parse(url)

        btn_send.onClick {
            sendEmail()
        }
    }
   private fun sendEmail()
   {
       val send_report = Intent(Intent.ACTION_SEND)
       send_report.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(""))
       send_report.putExtra(Intent.EXTRA_SUBJECT, title)
       send_report.putExtra(Intent.EXTRA_STREAM, uri)
       send_report.putExtra(Intent.EXTRA_TEXT, description+"\n\n"+""+url)
       send_report.type = "text/plain"
       send_report.type = "image/png"
       startActivityForResult(Intent.createChooser(send_report, "Choose an Email client"), 77)
   }



}