package com.asmjahid.djangoretrofit;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.asmjahid.djangoretrofit.Api.RetrofitInterface;
import com.asmjahid.djangoretrofit.Model.RetrofitApi;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadFilesTask().execute("");
    }

    //private method for this tutorial
    @SuppressLint("StaticFieldLeak")
    private class DownloadFilesTask extends AsyncTask<String, Integer, List<RetrofitApi>> {

        protected List<RetrofitApi> doInBackground(String... urls) {

            RetrofitInterface api = new RetrofitInterface();
            return api.GetUniversity();
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(List<RetrofitApi> results) {

            StringBuilder sb = new StringBuilder();
            for(RetrofitApi university : results)
            {
                Log.d("Output: ", university.getName());
                sb.append(university.getName()).append("\n");
            }

            ((TextView) findViewById(R.id.txt_log)).setText(sb.toString());

        }
    }
}
