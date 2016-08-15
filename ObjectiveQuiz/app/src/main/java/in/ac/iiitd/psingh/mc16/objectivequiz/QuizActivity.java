package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNext;
    TextView Number;
    int ans;
    int output;
    private static final String TAG = "QuizActivity";

    public int prime(int ans)
    {
        int i,flag=0;
        for(i=2;i<ans;i++)
        {
            if(ans%i==0)
            {
                flag=1;
                break;
            }
            else
            {
                flag=0;
            }
        }

        return flag;

    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);




        Number = (TextView) findViewById(R.id.textViewer);

        mNext = (Button) findViewById(R.id.next_button);
        mNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int Min = 1, Max = 1000;

                Random num = new Random();
                ans = num.nextInt(Max - Min + 1) + Min;


                Number.setText(String.valueOf(ans));


            }
        });

        mTrueButton = (Button) findViewById(R.id.TrueButton);

        mTrueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View correct) {

                output=prime(ans);
                if (savedInstanceState != null) {
                    //Restore the fragment's instance
                    savedInstanceState.putInt("ans",ans);
                    savedInstanceState.putString("Text", Number.getText().toString());

                }

                if (prime(ans) == 0) {
                    Toast.makeText(getApplicationContext(), "Correct Ans!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Please Try Again!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);

        mFalseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View correct) {

                output=prime(ans);
                if (savedInstanceState != null) {
                    //Restore the fragment's instance
                    savedInstanceState.putInt("ans",ans);
                    savedInstanceState.putString("Text", Number.getText().toString());

                }

                if (prime(ans) == 1) {
                    Toast.makeText(getApplicationContext(), "Correct Ans!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Please Try Again!", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("ans",ans);
        savedInstanceState.putInt("output",output);
        savedInstanceState.putString("Text", Number.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        ans=savedInstanceState.getInt("ans");
        savedInstanceState.putInt("output",output);
        Number.setText(savedInstanceState.getString("Text"));
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this,"landscape",Toast.LENGTH_SHORT).show();

        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Toast.makeText(this,"portrait",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
