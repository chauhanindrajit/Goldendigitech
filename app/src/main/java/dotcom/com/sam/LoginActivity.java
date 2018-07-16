package dotcom.com.sam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText ed_username,ed_pass;
    String username,password;
    Button btn_login;
    TextView txt_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=ed_username.getText().toString();
                password=ed_pass.getText().toString();
                if(validation(username,password))
                {
                }

            }
        });

        txt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView()
    {
        ed_username=(EditText)findViewById(R.id.username);
        ed_pass=(EditText)findViewById(R.id.pass);
        btn_login=(Button) findViewById(R.id.btn_login);
        txt_skip=findViewById(R.id.txt_skip);

    }




    private boolean validation(String username,String password ){
        boolean flag=true;
        if(username==null||username.equalsIgnoreCase(""))
        {
            ed_username.setError("enter user name");
            flag=false;
        }
        else if(password==null||password.equalsIgnoreCase(""))
        {
            ed_pass.setError("enter password");
            flag=false;
        }
        else if(password.length()<=6)
        {
            ed_pass.setError("password should contain minimum 8 character");
            flag=false;

        }

        return flag;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
